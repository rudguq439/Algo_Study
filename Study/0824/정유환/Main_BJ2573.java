package weeka11_0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ2573 {

	private static class Pos {
		int x,y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int N, M;
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {-1,1,0,0};

	//빙하가 하나인지 확인
	private static boolean checkGlacier(int[][] map) {
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		int split = 0;
		
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
				
				split++;
			}
		}
		
		if(split < 2) return true;
		else return false;
	}
	
	//빙하 녹이기
	private static int removeGlacier(int[][] map) {
		int cnt = 0;
		boolean zeroed = true;
        int[][] temp;
		
		while(checkGlacier(map)) {
			zeroed = true;
			
			//이미 0이된 빙하를 포함해 녹이면 안되므로 변경 전 맵 저장
			temp = new int[N][M];
			for(int n = 0; n < N; n++) {
				temp[n] = Arrays.copyOf(map[n], M);
			}
			
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					if(map[n][m] == 0) continue;
					zeroed = false;
					
					for(int d = 0; d < 4; d++) {
						int nx = m + dx[d];
						int ny = n + dy[d];
						
						if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
						
						if(temp[ny][nx] == 0) map[n][m] -= 1;
						if(map[n][m] < 0) map[n][m] = 0;
					}
				}
			}
			
			cnt++;
			if(zeroed) {
				cnt = 0;
				return cnt;
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = removeGlacier(map);
		
		System.out.println(cnt);
	}

}

//dfs로 빙하 확인하고 bfs로 빙하 위치 저장 후 녹이기도 가능