package weeka11_0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_BJ1157 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashMap<Character,Integer> hm = new HashMap<>();
		
		String s = br.readLine().toUpperCase();
		
		char[] cs = s.toCharArray();
		int cslen = cs.length;
		
		for(int i = 0; i < cslen; i++) {
			if(hm.containsKey(cs[i])) {
				hm.put(cs[i], hm.get(cs[i])+1);
			}
			else {
				hm.put(cs[i], 1);
			}
		}
		
		int max = Integer.MIN_VALUE;
		char max_c = ' ';
		int max_cnt = 0;
		
		for(char c : hm.keySet()) {
			if(max == hm.get(c)) max_cnt++;
			if(max < hm.get(c)) {
				max = hm.get(c);
				max_c = c;
				max_cnt = 1;
			}
		}
		
		if(max_cnt > 1) System.out.println("?");
		else System.out.println(max_c);
	}

}
//다른 방법
//int[] alpha 배열 -'A' -'a' 하고 최대 구하기