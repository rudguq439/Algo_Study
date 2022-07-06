package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
	public static int N, M;
	public static int[][] arr;
	public static int cnt = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		robot(r, c, d);
		System.out.println(cnt);
		
		br.close();
	}
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	public static void robot(int row, int col, int dir) {
		arr[row][col] = 2; //현재 위치 청소
		
		for(int i=0; i<4; i++) {
			//북 0 동 1 남 2 서 3
			dir = (dir + 3) % 4; //왼쪽으로 방향 돌려줘서 왼쪽부터 탐색
			int nx = row + dx[dir];
			int ny = col + dy[dir];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0) {
				cnt++;
				robot(nx, ny, dir);
				
				return;
			}
		}
		
		// 4방향 청소되어있거나 3방향이 벽일때 후진
		int back = (dir + 2) % 4;
		int bx = row + dx[back];
		int by = col + dy[back];
		
		if(bx >= 0 && bx < N && by >= 0 && by < M && arr[bx][by] != 1) {
			robot(bx, by, dir); //방향 유지하면서 후진
		}
	}
}
