package week2_0620;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ14425 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<String> group = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i < N; i++) {
			group.add(br.readLine());
		}
		
		for(int i = 0; i < M; i++) {
			list.add(br.readLine());
		}
		
		int cnt = 0;
		
		//group은 중복이 없으니까 이를 기준으로 list를 group에 비교
		for(String word : list) {
			if(group.indexOf(word) >= 0) cnt++;
		}
		
		System.out.println(cnt);
	}

}
