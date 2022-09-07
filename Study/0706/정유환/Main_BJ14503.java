package week4_0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ14503 {

	private static class Roomba {
		int r;
		int c;
		int d;
		int cnt;
		
		public Roomba(int r, int c, int d, int cnt) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.cnt = cnt;
		}
	}
	
	private static int[] dc = {0,1,0,-1};
	private static int[] dr = {-1,0,1,0};
	private static int N, M;

	private static Roomba search(int[][] map, boolean[][] visited, Roomba roomba) {
		int cnt = 0;
		visited[roomba.r][roomba.c] = true;

		//규칙에 따라 이동
		while(cnt <= 4) {
			int nc = roomba.c;
			int nr = roomba.r;
			
			if(cnt == 4) {
				//0->2 2->0 1->3 3->1
				int back = (roomba.d+2)%4;
				
				nc = roomba.c + dc[back];
				nr = roomba.r + dr[back];
				
				if(nc < 0 || nc >= M || nr < 0 || nr >= N) break;
				if(map[nr][nc] == 1) break;
				
				roomba = new Roomba(nr, nc, roomba.d, roomba.cnt);	
			}
			else {
				//0->3 1->0 2->1 3->2
				int left = (roomba.d+3)%4;
				
				nc = roomba.c + dc[left];
				nr = roomba.r + dr[left];
				
				if(nc < 0 || nc >= M || nr < 0 || nr >= N
						|| map[nr][nc] == 1 || visited[nr][nc]) {
					cnt++;
					roomba.d = left;
					continue;
				}
				
				roomba = new Roomba(nr,nc,left,roomba.cnt+1);
				visited[nr][nc] = true;
			}
			
			cnt = 0;
		}
		
		return roomba;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		Roomba roomba = new Roomba(r,c,d,1);
		
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		roomba = search(map, visited, roomba);

		System.out.println(roomba.cnt);
	}

}
