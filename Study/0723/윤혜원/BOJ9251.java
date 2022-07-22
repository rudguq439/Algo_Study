package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LCS는 점화식 외우기
// 두 문자열의 각 자리를 비교하여 일치할 경우 dp [i][j] = dp [i-1][j-1] +1이 되고, 
// 일치하지 않을 경우는 dp [i][j] = Math.max(dp [i-1][j], dp [i][j-1])
public class BOJ9251LCS {
	static String a, b;
	static int dp[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine();
		b = br.readLine();
		dp = new int[a.length()+1][b.length()+1];
		
		for(int i=1; i<=a.length(); i++) {
			for(int j=1; j<=b.length(); j++) {
				if(a.charAt(i-1) != b.charAt(j-1)) { //일치하지 않을 경우
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}else { //일치할 경우
					dp[i][j] = dp[i-1][j-1]+1;
				}
			}
		}
		System.out.println(dp[a.length()][b.length()]);
	}

}
