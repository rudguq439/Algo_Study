package week9_0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ12904 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String T = br.readLine();
		
		int slen = S.length();
		
		//문자열 넣고 빼고 뒤집고는 stringbuilder 또는 stringbuffer(멀티쓰레드 최적) 사용
		StringBuilder sb = new StringBuilder();
		sb.append(T);
		int sblen = sb.length();
		
		//뒤에서 앞으로 빼가면서 확인
		while(slen < sblen) {			
			if(sb.charAt(sblen-1) == 'A') {
				sb.deleteCharAt(sblen-1);
			}
			else if(sb.charAt(sblen-1) == 'B') {
				sb.deleteCharAt(sblen-1);
				sb.reverse();
			}
			
			sblen = sb.length();
		}
		
		if(S.equals(sb.toString())) System.out.println(1);
		else System.out.println(0);
	}
	
}
