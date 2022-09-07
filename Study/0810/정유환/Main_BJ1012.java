package week9_0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ1012 {
	
	private static class Pos {
		int x,y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {-1,1,0,0};
	
	private static int bfs(int[][] map, int M, int N) {
		int cnt = 0;
		
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(map[n][m] == 0 || visited[n][m]) continue;
				
				q.add(new Pos(m,n));
				visited[n][m] = true;
				
				while(!q.isEmpty()) {
					Pos cur = q.poll();
					
					for(int d = 0; d < 4; d++) {
						int nx = cur.x + dx[d];
						int ny = cur.y + dy[d];
						
						if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
						if(map[ny][nx] == 0 || visited[ny][nx]) continue;
						
						q.add(new Pos(nx,ny));
						visited[ny][nx] = true;
					}
				}
				
				//인접 지역 갯수 증가
				cnt++;
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][M];
			
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[y][x] = 1;
			}

			int res = bfs(map, M,N);
			System.out.println(res);
		}		
	}

}
