package week6_0718;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ15683 {
	
	private static class CCTV {
		int type;
		int x, y;
		
		public CCTV(int type, int x, int y) {
			this.type = type;
			this.x = x;
			this.y = y;
		}
	}
	
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {-1,1,0,0};
	
	private static int N, M;
	private static List<CCTV> cctvs;
	private static int min;
	
	private static int[][] copyMap(int[][] map) {
		int[][] temp = new int[N][M];
		
		for(int n = 0; n < N; n++) {
			temp[n] = Arrays.copyOf(map[n], M);
		}
		
		return temp;
	}
	
	private static void fillSight(int[][] map, int d, int nx, int ny) {
		while(nx >= 0 && nx < M && ny >= 0 && ny < N && map[ny][nx] != 6) {
			map[ny][nx] = 7;
			
			nx += dx[d];
			ny += dy[d];
		}
	}
	
	private static void removeBlind(int[][] map, int depth) {
		if(depth == cctvs.size()) {
			int cnt = 0;
			
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					if(map[n][m] == 0) cnt++;
				}
			}
			
			min = min > cnt ? cnt : min;
			return;
		}
		
		int type = cctvs.get(depth).type;
		int x = cctvs.get(depth).x;
		int y = cctvs.get(depth).y;
		
		switch(type) {
			case 1: //0,1,2,3
				for(int d = 0; d < 4; d++) {
					int[][] temp = copyMap(map);
					fillSight(temp, d, x+dx[d], y+dy[d]);
					
					removeBlind(temp, depth+1);
				}
				break;
				
			case 2: //01,23
				for(int d = 0; d < 2; d++) {
					int[][] temp = copyMap(map);
					fillSight(temp, 2*d, x+dx[2*d], y+dy[2*d]);
					fillSight(temp, 2*d+1, x+dx[2*d+1], y+dy[2*d+1]);
					
					removeBlind(temp, depth+1);
				}
				break;
				
			case 3: //03,13,12,02 -> 02,03,12,13
				for(int d = 0; d < 2; d++) {
					int[][] temp = copyMap(map);
					fillSight(temp, d, x+dx[d], y+dy[d]);
					
					for(int dd = 2; dd < 4; dd++) {
						int[][] temp2 = copyMap(temp);
						fillSight(temp2, dd, x+dx[dd], y+dy[dd]);
						
						removeBlind(temp2, depth+1);
					}
				}
				break;
				
			case 4: //023, 013, 123, 012 -> 123,023,013,012
				for(int d = 0; d < 4; d++) {
					int[][] temp = copyMap(map);
					
					for(int dd = 0; dd < 4; dd++) {
						if(dd != d) fillSight(temp, dd, x+dx[dd], y+dy[dd]);
					}
					
					removeBlind(temp,depth+1);
				}
				break;
				
			case 5: //0123
				for(int d = 0; d < 4; d++) {
					fillSight(map, d, x+dx[d], y+dy[d]);
				}
				
				removeBlind(map, depth+1);
				break;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		cctvs = new ArrayList<>();
		min = Integer.MAX_VALUE;
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			for(int m = 0; m < M; m++) {
				int type = Integer.parseInt(st.nextToken());
				map[n][m] = type;
				
				if(type != 0 && type != 6) {
					cctvs.add(new CCTV(type,m,n));
				}
			}
		}
		
		removeBlind(map, 0);
		System.out.println(min);
	}

}
