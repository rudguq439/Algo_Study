package week6_0718;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ16120 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int len = s.length();
		int cnt = 0;
		
		for(int i = 0; i < len; i++) {
			char c = s.charAt(i);
			
			if(c == 'P') cnt++;
			else { //c == 'A'
				//PPAP가 되기 위해선 A 다음 문자가 P야하고 그 전에 P가 2번 이상 나왔어야함
				if(i < len-1 && s.charAt(i+1) == 'P' && cnt >= 2) cnt -= 2;
				else {
					System.out.println("NP");
					return;
				}
			}
		}
		
		if(cnt == 1) System.out.println("PPAP");
		else System.out.println("NP");
	}
	
}
//contains replace는 시간초과
//PPAP: PPPAPPAPAPPAPPPAPAPPAP
//PPPA: PPAPPPPAPAPPAPPAPPPAPA
//PAPA