package weeka11_0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ2675 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			char[] S = st.nextToken().toCharArray();
			
			StringBuilder sb = new StringBuilder();
			for(char c : S) {
				for(int r = 0; r < R; r++) {
					sb.append(c);
				}
			}
			
			System.out.println(sb);
		}
	}

}
