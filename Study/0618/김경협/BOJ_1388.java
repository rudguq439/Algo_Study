import java.util.*;
import java.io.*;

public class BOJ_1388 {
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		boolean visited[][] = new boolean[N][M];
		char map[][] = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				map[i][j] = input[j];
			}
		}
		
		
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j]) continue;
				visited[i][j] = true;
				
				if(map[i][j] == '-') {
					int nextCol = j + 1;
					
					while(!isOutOfMap(i, nextCol)) {
						if(map[i][nextCol] == '-') {
							visited[i][nextCol] = true;
							nextCol += 1;
						} else {
							break;
						}
					}
					
				} else if(map[i][j] == '|') {
					int nextRow = i + 1;
					
					while(!isOutOfMap(nextRow, j)) {
						if(map[nextRow][j] == '|') {
							visited[nextRow][j] = true;
							nextRow += 1;
						} else {
							break;
						}
					}
				}
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	
	static boolean isOutOfMap(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= M;
	}

}
