package weeka10_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ2178 {
	
	private static class Pos {
		int x,y,cnt;
		
		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {-1,1,0,0};
	private static int N,M;
	private static int min = Integer.MAX_VALUE;
	
	private static void searchMaze(int[][] map) {
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[N+1][M+1];
		q.add(new Pos(1,1,1));
		visited[1][1] = true;
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			if(cur.x == M && cur.y == N) {
				min = min > cur.cnt ? cur.cnt : min;
				continue; //현재 위치에서 더 이상 조사 필요 x
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(nx < 1 || nx > M || ny < 1 || ny > N) continue;
				if(map[ny][nx] == 0 || visited[ny][nx]) continue;
				
				q.add(new Pos(nx,ny,cur.cnt+1));
				visited[ny][nx] = true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+1];
		
		for(int n = 0; n < N; n++) {
			char[] inputs = br.readLine().toCharArray();
			
			for(int m = 0; m < M; m++) {
				map[n+1][m+1] = inputs[m]-'0'; 
			}
		}
		
		searchMaze(map);
		
		System.out.println(min);
	}

}

//dfs는 시간초과