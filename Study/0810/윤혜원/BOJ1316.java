package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1316그룹단어체커 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {

		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i=0; i<N; i++) {
			if(Group())
				count++;
		}
		System.out.println(count);
	}
	public static boolean Group() throws IOException {
		String st = br.readLine();
		boolean[] alpha = new boolean[26];
		int now = 0;
		int len = st.length();
		
		for(int j=0; j<len; j++) {
			char c = st.charAt(j);
			if(now != c) {
				if(alpha[c - 'a'] == false) {
					alpha[c - 'a'] = true;
					now = c;
				}else {
					return false;
				}
			}
		}
		return true;
	}

}
