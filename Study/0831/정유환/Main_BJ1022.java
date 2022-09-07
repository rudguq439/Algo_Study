package weeka12_0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ1022 {
	
	private static int fill(int r, int c) {
		int n = Math.max(Math.abs(r),Math.abs(c));
		int min = (int)Math.pow(2*n-1, 2) + 1;
		
		//왼쪽 첫 값 + 왼쪽 중앙까지 값 0 1 2 -> n-1 + 행 위치 -
		if(c == n && r != n) return min + n-1 - r;
		//윗쪽 중앙 까지 값 2 5 8 -> 3n-1 + 열 위치 -
		if(r == -n) return min + 3*n-1 - c;
		//오른쪽 중앙 까지 값 4 9 14 -> 5n-1 + 행위치 +
		if(c == -n) return min + 5*n-1 + r;
		//아래쪽 중앙 까지 값 6 13 + 열위치 +
		return min + 7*n-1 + c;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[r2-r1+1][c2-c1+1];
		int max = 0;
		
		for(int i = r1; i <= r2; i++) {
			for(int j = c1; j <=c2; j++) {
				map[i-r1][j-c1] = fill(i,j);
				max = Math.max(max, map[i-r1][j-c1]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("%"+String.valueOf(max).length()+"d ");

		for(int i = 0; i <= r2-r1; i++) {
			for(int j = 0; j <= c2-c1; j++) {
				System.out.printf(sb.toString(),map[i][j]);
			}
			System.out.println();
		}
		
	}

}
//시작: 2 10 26 (2n-1)^2+1
//끝 9 25 49 (2n+1)^2
