package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500테트로미노 {
	static int N, M;
	static int[][] arr;
	static boolean[][] visited;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = true;
				dfs(i, j, arr[i][j], 1);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
	}
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void dfs(int x, int y, int sum, int count) {
		if(count == 4) {
			max = Math.max(max, sum);
			return;
		}
		for(int i=0; i<4; i++) {
			int curX = x + dx[i];
			int curY = y + dy[i];
			
			if(curX<0 || curX>=N || curY<0 || curY>=M) 
				continue;
			//방문 안했으면
			if(!visited[curX][curY]) {
				if(count == 2) {
					visited[curX][curY] = true;
					dfs(x, y, sum+arr[curX][curY], count+1);
					visited[curX][curY] = false;
				}
				visited[curX][curY] = true;
				dfs(curX, curY, sum+arr[curX][curY], count+1);
				visited[curX][curY] = false;
			}
		}
	}
}
