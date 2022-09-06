package week3_0627;

import java.util.List;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ1916 {
	
	//priority queue를 위한 comparable
	private static class Way implements Comparable<Way>{
		int end;
		int cost;
		
		public Way(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Way w) {
			return this.cost > w.cost ? 1 : -1;
		}
	}
	
	private static int dijkstra(List<List<Way>> ways, int[] dist, int N, int start, int end) {
		PriorityQueue<Way> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		
		pq.offer(new Way(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Way pos = pq.poll();
			int cur = pos.end;
			
			if(!visited[cur]) {
				visited[cur] = true;
				
				for(Way w : ways.get(cur)) {
					//현재 도착지 비용보다 현 위치에서 도착지로 가는 비용이 쌀 경우 교체
					if(!visited[w.end] && dist[w.end] > dist[cur] + w.cost) {
						dist[w.end] = dist[cur] + w.cost;
						pq.add(new Way(w.end, dist[w.end]));
					}
				}
			}
		}
		
		return dist[end];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		//길 저장
		List<List<Way>> ways = new ArrayList<>();
		
		for(int n = 0; n <= N; n++) {
			ways.add(new ArrayList<Way>());
		}
		
		//다익스트라
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			ways.get(s).add(new Way(e,c));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(ways,dist,N,start,end));
	}

}
