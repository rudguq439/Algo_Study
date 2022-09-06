package week8_0801;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_BJ1316 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Character> check = new ArrayList<>();
		
		int cnt = 0;
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			int len = s.length();
			boolean flag = true;
			
			for(int i = 0; i < len; i++) {
				char c = s.charAt(i);
				
				if(check.contains(c)) {
					if(check.lastIndexOf(c) != i-1) {
						flag = false;
						break;
					}
					check.add(c);
				}
				else check.add(c);
			}
			
			if(flag) cnt++;
			check.clear();
		}
		
		System.out.println(cnt);
	}

}
