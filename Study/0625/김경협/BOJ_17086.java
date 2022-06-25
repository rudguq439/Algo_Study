import java.util.*;
import java.io.*;

public class BOJ_17086 {
	static int map[][], N, M;
	static int dr[] = {-1,-1,-1,0,1,1,1,0};
	static int dc[] = {-1,0,1,1,1,0,-1,-1};	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(simulate());
		

	}
	
	static int simulate() {
		boolean[][] visited = new boolean[N][M];
		int cnt = 0;
		boolean isZeroExist = false;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) visited[i][j] = true;
			}
		}
		
		
		while(!isZeroExist) {
			cnt++;
			isZeroExist = true;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == cnt) {
						for(int k = 0; k < 8; k++) {
							int nextRow = i + dr[k];
							int nextCol = j + dc[k];
							
							if(isOutOfMap(nextRow, nextCol)) continue;
							if(visited[nextRow][nextCol]) continue;
							
							if(isZeroExist)
								isZeroExist = false;
							
							map[nextRow][nextCol] = cnt + 1;
							visited[nextRow][nextCol] = true;	
						}
					}
				}
			}
			
		}
		
		return cnt - 1;
	}
	
	static boolean isOutOfMap(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= M;
	}
	
}


