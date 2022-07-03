package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5525IOIOI {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String st = br.readLine();
		char[] ch = st.toCharArray();
		
		int count = 0;
		int result = 0;
		
		for(int i=1; i<M-1; i++) {
			if(ch[i-1] == 'I' && ch[i] == 'O' && ch[i+1] == 'I') {
				count++;
				if(count == N) {
					count--;
					result++;
				}
				i++;
			}else {
				count = 0;
			}
		}
		System.out.println(result);
	}

}
