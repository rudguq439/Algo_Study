package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class BOJ20291파일정리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //파일 개수
		Map<String, Integer> hm = new TreeMap<>();
		
		for(int i=0; i<N; i++) {
			String st = br.readLine();
			for(int j=0; j<st.length(); j++) {
				if(st.charAt(j) == '.') {
					String key = st.substring(j+1);
					if(hm.containsKey(key)) {
						int num = hm.get(key);
						hm.replace(key, ++num);
					}else {
						hm.put(key, 1);
					}
				}
			}
		}
		for(String k : hm.keySet()) {
			System.out.println(k + " " + hm.get(k));
		}
	}
}
