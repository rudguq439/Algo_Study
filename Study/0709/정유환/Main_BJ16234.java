package week4_0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ16234 {
	
	private static class Country {
		int r;
		int c;
		
		public Country(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	private static int[] dc = {0,0,-1,1};
	private static int[] dr = {-1,1,0,0};
	private static int N, L, R;
	
	//인접 국가 인구 차 비교
	private static void bfs(int[][] map, List<Country> list, boolean[][] visited, int r, int c) {
		Queue<Country> q = new LinkedList<>();
		q.add(new Country(r,c));
		list.add(new Country(r,c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Country cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(visited[nr][nc]) continue;
				
				//조건 차이가 L 이상 R 이하
				int diff = Math.abs(map[cur.r][cur.c] - map[nr][nc]);
				if( diff >= L && diff <= R) {
					q.add(new Country(nr,nc));
					list.add(new Country(nr,nc));
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	private static void move(int[][] map, List<Country> list) {
		int sum = 0;
		
		for(Country c : list) {
			sum += map[c.r][c.c]; 
		}
		
		int avg = sum/list.size();
		
		for(Country c : list) {
			map[c.r][c.c] = avg;
		}
	}
	
	private static int checkBorder(int[][] map) {
		int day = 0;
		List<Country> list = new ArrayList<>();
		boolean[][] visited = new boolean[N][N];
		
		while(true) {
			boolean done = true;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(visited[i][j]) continue;
					
					bfs(map,list,visited,i,j);
					if(list.size() > 1) {
						move(map, list);
						done = false;
					}
					//인구 이동하는 국가 리스트 초기화
					list.clear();
				}
			}
			
			//모든 국가가 더 이상 인구 이동이 안될 경우
			if(done) break;
			day++;
			
			//방문 리스트 비우기
			for(int n = 0; n < N; n++) {
				Arrays.fill(visited[n], false);
			}
		}
		
		return day;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = checkBorder(map);
		
		System.out.println(ans);
	}

}
