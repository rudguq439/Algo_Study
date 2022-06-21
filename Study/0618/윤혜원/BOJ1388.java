package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1388바닥장식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static char[][] map;
	static int cnt = 0;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == '-' || map[i][j] == '|') {
					cnt++;
					bfs(i, j);
				}
			}
		}
		System.out.println(cnt);
	}
	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(r, c));
		int index = map[r][c] == '-' ? 2 : 0;
		char check = map[r][c];
		map[r][c] = ';';

		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int i = index; i < index+2; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == ';') continue;
				if(map[nr][nc] == check) {
					map[nr][nc] = ';';
					q.offer(new Point(nr, nc));
				}
			}
		}
	}
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
}
