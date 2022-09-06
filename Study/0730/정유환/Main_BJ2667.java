package week7_0725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_BJ2667 {
	
	private static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {-1,1,0,0};
	
	private static List<Integer> bfs(char[][] map, int N) {
		List<Integer> result = new ArrayList<>();
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] || map[i][j] == '0') continue;
				
				q.add(new Pos(j,i));
				visited[i][j] = true;
				int cnt = 1;
				
				while(!q.isEmpty()) {
					Pos cur = q.poll();
										
					for(int d = 0; d < 4; d++) {
						int nx = cur.x + dx[d];
						int ny = cur.y + dy[d];
						
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(visited[ny][nx] || map[ny][nx] == '0') continue;
						
						q.add(new Pos(nx,ny));
						visited[ny][nx] = true;
						cnt++;
					}
				}
				
				result.add(cnt);
			}
		}
		
		Collections.sort(result);
		
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			
			for(int m = 0; m < N; m++) {
				map[n][m] = s.charAt(m);
			}
		}
		
		List<Integer> res = bfs(map,N);
		
		System.out.println(res.size());
		for(Integer i : res) {
			System.out.println(i);
		}
	}

}
