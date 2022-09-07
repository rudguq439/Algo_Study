package week3_0627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ11048 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+1];
		
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			
			for(int m = 1; m <= M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] candy = new int[N+1][M+1];
		
		//대각선보다 가로 세로로 가는게 1칸 추가되서 대각선으로 이동한 것과 같거나 더 크게 나옴
		//기준점 위의 캔디 값과 왼쪽의 캔디 값을 기준점과 더했을 때 큰 값을 저장
		for(int n = 1; n <= N; n++) {
			for(int m = 1; m <= M; m++) {
				candy[n][m] = Math.max(map[n][m]+candy[n-1][m], map[n][m]+candy[n][m-1]);
			}
		}
		
		System.out.println(candy[N][M]);
	}

}
