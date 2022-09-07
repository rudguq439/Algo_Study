package week4_0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ14891 {
	
	private static int K;

	private static void check(int[][] wheels, int[] d, int num, int dir) {
		d[num-1] = dir;
		//좌측 회전 방향 확인
		for(int i = num-1; i > 0; i--) {
			if(wheels[i][6] != wheels[i-1][2]) {
				d[i-1] = -d[i];
			}
			else break;
		}
		//우측 회전 방향 확인
		for(int i = num-1 ; i < 3; i++) {
			if(wheels[i][2] != wheels[i+1][6]) {
				d[i+1] = -d[i];
			}
			else break;
		}
	}
	
	private static void spin(int[][] wheels, int[] d) {
		int t = 0;
		
		for(int i = 0; i < 4; i++) {
			// 7123456
			if(d[i] == 1) {
				t = wheels[i][7];
				for(int j = 7; j > 0; j--) {
					wheels[i][j] = wheels[i][j-1];
				}
				wheels[i][0] = t;
			}
			// 2345671
			else if(d[i] == -1) {
				t = wheels[i][0];
				for(int j = 0; j < 7; j++) {
					wheels[i][j] = wheels[i][j+1];
				}
				wheels[i][7] = t;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int[][] wheels = new int[4][8];
		
		for(int i = 0; i < 4; i++) {
			String s = br.readLine();
			
			for(int j = 0; j < 8; j++) {
				wheels[i][j] = s.charAt(j)-'0';
			}
		}
		
		K = Integer.parseInt(br.readLine());
		int[][] spin = new int[K][2];
		
		StringTokenizer st;
		int[] d = new int[4];
		
		for(int k = 0; k < K; k++) {
			Arrays.fill(d, 0);
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			check(wheels, d, num, dir);
			spin(wheels, d);
		}
		
		int total = 0;
		
		if(wheels[0][0] == 1) total += 1;
		if(wheels[1][0] == 1) total += 2;
		if(wheels[2][0] == 1) total += 4;
		if(wheels[3][0] == 1) total += 8;
		
		System.out.println(total);
	}

}
