package week9_0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ1966 {

	//번호와 우선순위 저장
	private static class Print{
		int no, priority;
		
		public Print(int no, int priority) {
			this.no = no;
			this.priority = priority;
		}
	}
	
	//현재 Queue의 최대 우선순위 값 검색
	private static int findMax(Queue<Print> q) {
		int max = Integer.MIN_VALUE;
		
		for(Print p : q) {
			max = max < p.priority ? p.priority : max;
		}
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			Queue<Print> q = new LinkedList<>();
			
			for(int n = 0; n < N; n++) {
				q.add(new Print(n, Integer.parseInt(st.nextToken())));
			}
			
			int cnt = 0;
			while(true) {
				int max = findMax(q);
				
				Print cur = q.poll();
				if(cur.priority != max) {
					q.add(cur);
				}
				else {
					if(cur.no == M) break;
					else cnt++;
				}
			}
			
			System.out.println(cnt+1);
		}	
	}

}
