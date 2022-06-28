package week2_0620;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ17086 {
	
	//상어 위치 저장 class 구조체
	private static class Pos {
		private int x;
		private int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	//8방향
	private static int[] dx = {0,1,1,1,0,-1,-1,-1};
	private static int[] dy = {-1,-1,0,1,1,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] map = new int[N][M];
		Queue<Pos> q = new LinkedList<>();
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if(map[n][m] == 1) q.add(new Pos(m,n));
			}
		}
		//상어 위치 저장
		
		int ans = Integer.MIN_VALUE;
		int[][] dis = new int[N][M];
		
		//상어 위치에서 BFS 검색, 거리를 dis에 저장
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			for(int i = 0; i < 8; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				//범위 밖에 나가면 안되고, 이미 방문하여 dis 값이 주어진 곳이나 아기 상어가 있는 곳에 또 가면 안됨
				if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
				if(dis[ny][nx] != 0 || map[ny][nx] == 1) continue;
				
				dis[ny][nx] = dis[cur.y][cur.x] + 1;
				
				if(dis[ny][nx] > ans) ans = dis[ny][nx];
				
				q.add(new Pos(nx,ny));
			}
		}
		
		//dis 값이 가장 큰 값 출력
		System.out.println(ans);
	}

}
