package weeka10_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ14499 {
	
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static int[] dice = new int[7];
	
	private static void changeDice(int d) {
		int[] temp = dice.clone();
		//d = 1:동 2:서 3:북 4:남
		//dice = 1:top 6:bot
		switch(d) {
			case 1:
				dice[1] = temp[4];
				dice[4] = temp[6];
				dice[6] = temp[3];
				dice[3] = temp[1];
				break;
			case 2:
				dice[1] = temp[3];
				dice[3] = temp[6];
				dice[6] = temp[4];
				dice[4] = temp[1];
				break;
			case 3:
				dice[1] = temp[5];
				dice[5] = temp[6];
				dice[6] = temp[2];
				dice[2] = temp[1];
				break;
			case 4:
				dice[1] = temp[2];
				dice[5] = temp[1];
				dice[6] = temp[5];
				dice[2] = temp[6];
				break;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//(r,c)의 r는 세로 c는 가로 x,y의 x가 세로 y는 가로
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int k = 0; k < K; k++) {
			int d = Integer.parseInt(st.nextToken());
			
			int nx = x + dx[d-1];
			int ny = y + dy[d-1];
			
			if(nx >= 0 && nx < M && ny >= 0 && ny < N) {
				changeDice(d);
				
				if(map[ny][nx] == 0) {
					map[ny][nx] = dice[6];
				}
				else {
					dice[6] = map[ny][nx];
					map[ny][nx] = 0;
				}
				
				x = nx;
				y = ny;
				System.out.println(dice[1]);
			}
		}		
	}

}
