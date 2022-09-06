package week7_0725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_BJ4358 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String,Integer> map = new HashMap<>();
		String s;
		int total = 0;
		
		//입력
		while((s = br.readLine()) != null) {
//			s = br.readLine();
//			if("end".equals(s)) break;
			total++;
			if(!map.containsKey(s)) map.put(s, 1);
			else map.replace(s, map.get(s)+1);
		}
		
		//키 값만 리스트로 변경하여 정렬
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		
		//정렬한 대로 퍼센트 출력
		for(String l : list) {
			System.out.println(l+" "+
			String.format("%.4f", (double)map.get(l) * 100 / (double) total));
		}
	}

}
