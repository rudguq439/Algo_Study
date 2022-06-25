import java.util.*;
import java.io.*;

public class BOJ_4963 {
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};
	static int w, h;
	static boolean map[][], visited[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			map = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = st.nextToken().equals("1") ? true : false;
				}
			}
			sb.append(simulate()).append("\n");
		}
		
		System.out.println(sb);

	}
	
	static int simulate() {
		int cnt = 0;
		visited = new boolean[h][w];
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(visited[i][j]) continue;
				if(map[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	static void dfs(int i, int j) {
		visited[i][j] = true;
		
		for(int k = 0; k < 8; k++) {
			int nextRow = i + dr[k];
			int nextCol = j + dc[k];
			
			if(isOutOfMap(nextRow, nextCol)) continue;
			if(visited[nextRow][nextCol]) continue;
			if(!map[nextRow][nextCol]) continue;
			
			dfs(nextRow, nextCol);
		}
	}
	
	static boolean isOutOfMap(int r, int c) {
		return r < 0 || c < 0 || r >= h || c >= w;
	}

}
