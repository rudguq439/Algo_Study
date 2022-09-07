package week5_0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main_BJ1302 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String,Integer> list = new HashMap<>();
		
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			
			if(list.containsKey(s)) {
				list.replace(s,list.get(s)+1);
			}
			else list.put(s, 1);
		}
		
		int max = Integer.MIN_VALUE;
		
		//최대값 찾기
		for(int v : list.values()) {
			if(v > max) max = v;
		}
		
		//키 값 정렬
		String[] sorted = list.keySet().toArray(new String[0]);
		Arrays.sort(sorted);
		
		//정렬된 키값으로 최대값이랑 같은 키 찾기
		for(String s : sorted) {
			if(list.get(s) == max) {
				System.out.println(s);
				break;
			}
		}
	}

}
