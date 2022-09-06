package week5_0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BJ18870 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] axis = new int[N];
		int[] sorted = new int[N];
		Map<Integer,Integer> ranks = new HashMap<>();
				
		for(int n = 0; n < N; n++) {
			int input = Integer.parseInt(st.nextToken());
			axis[n] = input;
			sorted[n] = input;
		}
		
		//입력값 정렬하고 이에 맞게 순위 0부터 지정
		Arrays.sort(sorted);
		int rank = 0;
		for(int i : sorted) {
			if(ranks.containsKey(i)) continue;
			ranks.put(i, rank);
			rank++;
		}
		
		//syso는 시간초과
		StringBuilder sb = new StringBuilder();
		for(int i : axis) {
			int r = ranks.get(i);
			sb.append(r).append(' ');
		}
		System.out.println(sb);
	}

}
