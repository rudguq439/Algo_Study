package weeka10_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_BJ2751 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		for(int n = 0; n < N; n++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i : list) {
			sb.append(i+"\n");
		}
		
		System.out.println(sb);
	}

}
