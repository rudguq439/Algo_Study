package weeka11_0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ13460 {
	
	private static class Ball {
		int rx,ry,bx,by,cnt;
		
		public Ball(int rx, int ry, int bx, int by, int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}
	
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {-1,1,0,0};
	private static int N,M;
	private static char[][] board;
	private static int min = Integer.MAX_VALUE;
	
	private static void moveBoard(Ball rb) {
		Queue<Ball> q = new LinkedList<>();
		boolean[][][][] visited = new boolean[N][M][N][M];
		
		q.add(rb);
		visited[rb.ry][rb.rx][rb.by][rb.bx] = true;
		
		while(!q.isEmpty()) {
			Ball cur = q.poll();
						
			if(cur.cnt > 10) {
				continue;
			}
			
			for(int d = 0; d < 4; d++) {
				boolean redin = false;
				boolean bluein = false;

				int nrx = cur.rx;
				int nry = cur.ry;
				int nbx = cur.bx;
				int nby = cur.by;
				
				//red 이동
				while(board[nry+dy[d]][nrx+dx[d]] != '#') {
					nrx += dx[d];
					nry += dy[d];
					
					if(board[nry][nrx] == 'O') {
						redin = true;
						break;
					}
				}
				
				//blue 이동
				while(board[nby+dy[d]][nbx+dx[d]] != '#') {
					nbx += dx[d];
					nby += dy[d];
					
					if(board[nby][nbx] == 'O') {
						bluein = true;
						break;
					}
				}
				
				//blue만 들어가거나 red만 들어간 경우 남은 가능성 확인
				if(bluein) continue;
				if(redin && !bluein) {
					min = min > cur.cnt+1 ? cur.cnt+1 : min;
					continue;
				}
				
				//같은 위치면 방향, red blue 위치에 따라 이동 값 하나 빼주기
				if(nrx == nbx && nry == nby) {
					if(d == 0) {
						if(cur.ry > cur.by) nry -= dy[d];
						else nby -= dy[d];
					}
					else if(d == 1) {
						if(cur.ry > cur.by) nby -= dy[d];
						else nry -= dy[d];
					}
					else if(d == 2) {
						if(cur.rx > cur.bx) nrx -= dx[d];
						else nbx -= dx[d];
					}
					else {
						if(cur.rx > cur.bx) nbx -= dx[d];
						else nrx -= dx[d];
					}
				}
				
				if(visited[nry][nrx][nby][nbx]) continue;
				
				q.add(new Ball(nrx, nry, nbx, nby, cur.cnt+1));
				visited[nry][nrx][nby][nbx] = true;
			}
		}
		
		//마지막 이동까지 도달 못했으므로 -1
		if(min == Integer.MAX_VALUE) min = -1;
		if(min > 10) min = -1;
		return;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		Ball rb = new Ball(0,0,0,0,0);
		
		for(int n = 0; n < N; n++) {
			char[] carr = br.readLine().toCharArray();
			
			for(int m = 0; m < M; m++) {
				if(carr[m] == 'R' ) {
					rb.rx = m;
					rb.ry = n;
					board[n][m] = '.';
				}
				else if(carr[m] == 'B') {
					rb.bx = m;
					rb.by = n;
					board[n][m] = '.';
				}
				board[n][m] = carr[m];
			}
		}
		
		moveBoard(rb);
		
		System.out.println(min);
	}

}
/*
7 7
#######
#.###R#
##....#
#..#.##
##.#OB#
##....#
#######
하죄하우하우상

8 8
########
#BR.#.O#
###.#..#
#...#..#
#.###..#
#..#..##
##...#.#
########
*/
