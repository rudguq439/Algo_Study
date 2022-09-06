package week5_0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ18405 {
	
	private static class Virus implements Comparable<Virus>{
		int x;
		int y;
		int k;
		
		public Virus(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
		
		@Override
		public int compareTo(Virus o) {
			return this.k - o.k > 0 ? 1 : -1;
		}
	}
	
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {-1,1,0,0};
	
	private static void bfs(int[][] map, List<Virus> list, int N, int K, int S) {
		boolean[][] visited = new boolean[N+1][N+1];
		Queue<Virus> q = new LinkedList<>();
		Queue<Virus> nq = new LinkedList<>();
		
		int s = S;
		
		//번호순으로 넣어둬야 번호순으로 퍼짐
		for(Virus v : list) {
			q.add(v);
			visited[v.y][v.x] = true;
		}
		
		//번호 순으로 인접 칸으로 퍼짐
		while(s > 0 && !q.isEmpty()) {
			Virus cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(nx < 1 || nx > N || ny < 1 || ny > N) continue;
				if(visited[ny][nx]) continue;
				
				map[ny][nx] = cur.k;
				visited[ny][nx] = true;
				nq.add(new Virus(nx, ny, cur.k));
			}
			
			if(q.isEmpty()) {
				q = nq;
				nq = new LinkedList<>();
				s--;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		List<Virus> list = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int k = Integer.parseInt(st.nextToken());
				map[i][j] = k;
				if(k != 0) list.add(new Virus(j,i,k));
			}
		}
		//바이러스 번호순으로 정렬
		Collections.sort(list);
		
		st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		bfs(map, list, N, K, S);
		
		System.out.println(map[X][Y]);
	}
}
