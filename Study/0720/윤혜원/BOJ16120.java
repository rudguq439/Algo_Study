package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16120PPAP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		
		int cnt = 0;
		boolean flag = true;
		for(int i=0; i<st.length(); i++) {
			char c = st.charAt(i);
			if(c == 'P') {
				cnt++;
				System.out.println("p-cnt : "+cnt);
			}else {
				if(c == 'A') {
					if(cnt >= 2 && i+1 <st.length() && st.charAt(i+1) == 'P') {
						cnt--;
						i++;
						System.out.println("a-cnt : "+cnt);
					}
					else {
						flag = false;
						break;
					}
				}
			}
		}
		if(cnt > 1)
			flag = false;
		
		if(flag == true)
			System.out.println("PPAP");
		else 
			System.out.println("NP");
	}
}
