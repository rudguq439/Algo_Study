package week5_0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BJ20291 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String,Integer> list = new HashMap<>();
		StringTokenizer st;
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), ".");
			String name = st.nextToken();
			String ext = st.nextToken();
			
			if(list.containsKey(ext)) {
				list.replace(ext,list.get(ext)+1);
			}
			else list.put(ext, 1);
		}
		
		//키 값 정렬
		String[] sorted = list.keySet().toArray(new String[0]);
		Arrays.sort(sorted);
		
		//정렬된 키 값으로 값 찾아 출력
		for(String s : sorted) {
			System.out.println(s+" "+list.get(s));
		}
	}

}
