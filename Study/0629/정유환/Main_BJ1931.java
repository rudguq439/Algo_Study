package week3_0627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ1931 {

	private static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting m) {
			if(this.end == m.end) return this.start - m.start;
			return this.end - m.end;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			meetings[n] = new Meeting(a,b);
		}
		
		//끝나는 순으로 정렬
		Arrays.sort(meetings);
		int cnt = 0;
		int prev_end = 0;
		
		for(int i = 0; i < N; i++) {
			if(prev_end <= meetings[i].start) {
				prev_end = meetings[i].end;
				cnt++;
			}
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(meetings[i].start+","+meetings[i].end);
		}
		
		System.out.println(cnt);
	}

}
