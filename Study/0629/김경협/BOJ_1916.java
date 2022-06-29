import java.io.*;
import java.util.*;

public class BOJ_1916 {
	static int N,M, start, dest;
	static ArrayList<int[]>[] adj;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N];
		
		for(int i = 0; i < N; ++i) {
			adj[i] = new ArrayList<int[]>();
		}
		
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			adj[from].add(new int[] {to, cost});
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()) - 1;
		dest = Integer.parseInt(st.nextToken()) - 1;
		
		System.out.println(solve());
	}
	
	static int solve() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1], o2[1]));
		int[] dist = new int[N];
		
		for(int i = 0; i < N; ++i) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		pq.offer(new int[] {start, 0});
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			int currIdx = curr[0];
			int currCost = curr[1];
			
			if(dist[currIdx] < currCost) {	// 현재까지 그 경로까지의 거리가 최소값보다 작다면 패스
				continue;
			}
			
			for(int i = 0, len = adj[currIdx].size(); i < len; ++i) {
				int[] next = adj[currIdx].get(i);
				int nextIdx = next[0];
				int nextCost = next[1];
				
				if(dist[nextIdx] > currCost + nextCost) {
					dist[nextIdx] = currCost + nextCost;
					pq.offer(new int[] {nextIdx, dist[nextIdx]});
				}
			}
		}
		
		return dist[dest];
	}
}
