import java.util.*;
import java.io.*;

public class BOJ_15988 {
	
	static final int MOD = 1000000009;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()), largest = 0;
		int[] inputs = new int[N];
		
		for(int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(br.readLine());
			largest = Math.max(inputs[i], largest);
		}
		
		
		long dp[] = new long[largest + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4; i <= largest; i++) {
			dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % MOD;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			sb.append(dp[inputs[i]]).append("\n");
		}
		
		System.out.println(sb);
	}

}
