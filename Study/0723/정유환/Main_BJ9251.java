package week6_0718;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ9251 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		
		int alen = a.length();
		int blen = b.length();
		
		int[][] dp = new int[alen+1][blen+1];
		
		for(int i = 1; i <= alen; i++) {
			for(int j = 1; j <= blen; j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		System.out.println(dp[alen][blen]);
	}

}
