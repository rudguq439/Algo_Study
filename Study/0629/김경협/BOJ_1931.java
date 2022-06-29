import java.io.*;
import java.util.*;

public class BOJ_1931 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1] != o2[1] ? Integer.compare(o1[1],o2[1]) : Integer.compare(o1[0],o2[0]));
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new int[]{Integer.parseInt(st.nextToken()),
								Integer.parseInt(st.nextToken())}
					);
		}
		
		System.out.println(solve(N, pq));
		
	}
	
	static int solve(int N, PriorityQueue<int[]> pq) {
		int cnt = 0, endTime = 0;
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			if(curr[0] >= endTime) {
				endTime = curr[1];
				cnt++;
			}
		}
		
		return cnt;
	}
}
