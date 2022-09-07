package week7_0725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_BJ2608 {
	
	private static String[] symbols = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
	private static int[] values = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
	
	private static int StoI(Map<String,Integer> symbols, String s) {
		int res = 0;
		String[] sarr = s.split("");
		int len = s.length();
		
		for(int i = 0; i < len; i++) {
			String c = sarr[i];
			
			//IV, IX, XL, XC, CD, CM 확인
			if(("I".equals(c) || "X".equals(c) || "C".equals(c)) && i < len-1) {
				String t = c + sarr[i+1];
				
				if(symbols.containsKey(t)) {
					res += symbols.get(t);
					i++;
					continue;
				}
			}
			res += symbols.get(c);
		}
		
		return res;
	}
	
	private static String ItoS(int input) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 12; i >= 0; i--) {
			int t = input / values[i];
			
			if(t != 0) {
				for(int j = 0; j < t; j++) {
					sb.append(symbols[i]);
				}
				input %= values[i];
			}
		
		}
		
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sa = br.readLine();
		String sb = br.readLine();
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < 13; i++) {
			map.put(symbols[i], values[i]);
		}
		
		int ia = StoI(map, sa);
		int ib = StoI(map, sb);
		int ians = ia+ib;
		String sans = ItoS(ians);
		
		System.out.println(ians);
		System.out.println(sans);
	}

}
