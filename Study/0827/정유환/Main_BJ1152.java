package weeka11_0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ1152 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		char[] carr = br.readLine().toCharArray();
//		
//		int cnt = 1;
//		if(carr[0] == ' ') cnt--;
//		if(carr[carr.length-1] == ' ') cnt--;
//		
//		for(char c : carr) {
//			if(c == ' ') cnt++;
//		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		while(st.hasMoreTokens()) {
			st.nextToken();
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
