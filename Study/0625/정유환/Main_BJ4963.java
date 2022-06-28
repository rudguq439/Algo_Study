package week2_0620;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ4963 {
	
	//위치 저장 class 구조체
	private static class Pos {
		private int x;
		private int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	//가로 세로 대각선 이동
	private static int[] dx = {0,1,1,1,0,-1,-1,-1};
	private static int[] dy = {-1,-1,0,1,1,1,0,-1};
	
	//BFS로 섬 갯수 세기
	private static int bfs(int[][] map, int h, int w) {
		int cnt = 0;
		
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[h][w];
		
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(map[i][j] == 0) continue;
				if(visited[i][j]) continue;
				
				q.add(new Pos(j,i));
				visited[i][j] = true;
				
				while(!q.isEmpty()) {
					Pos cur = q.poll();
					
					for(int d = 0; d < 8; d++) {
						int nx = cur.x + dx[d];
						int ny = cur.y + dy[d];
						
						if(nx < 0 || nx >= w || ny < 0 || ny >= h) continue;
						if(map[ny][nx] == 0) continue;
						if(visited[ny][nx]) continue;
						
						q.add(new Pos(nx,ny));
						visited[ny][nx] = true;
					}
				}
				
				cnt++;
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		List<Integer> ans = new ArrayList<>();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			int[][] map = new int[h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans.add(bfs(map,h,w));
		}
		
		//출력
		for(int a : ans) {
			System.out.println(a);
		}
	}

}
