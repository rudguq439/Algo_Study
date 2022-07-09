package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14891톱니바퀴 {
	static int N, K, L;
	static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[4][8];
		StringTokenizer st;
		for(int i=0; i<4; i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1; // 톱니바퀴 번호
			int dir = Integer.parseInt(st.nextToken()); // 방향
			check(num, dir);
			rotation(num, dir);
		}
		int ans = 0;
		if(arr[0][0] == 1) ans++;
		if(arr[1][0] == 1) ans+=2;
		if(arr[2][0] == 1) ans+=4;
		if(arr[3][0] == 1) ans+=8;
		System.out.println(ans);
		
		br.close();
	}
	// 양 옆의 극이 반대극인지 같은 극인지 확인
	public static void check(int num, int dir) {
		//왼쪽
		checkL(num-1, -dir);
		
		//오른쪽
		checkR(num+1, -dir);
	}
	public static void checkL(int num, int dir) {
		//범위 나가면 탐색 멈춤
		if(num<0) 
			return;
		//같은 극이면 탐색 멈춤
		if(arr[num][2] == arr[num+1][6]) 
			return;
		//다른극일때 재귀로 계속 검사
		checkL(num-1, -dir);
		rotation(num, dir);
		
	}
	public static void checkR(int num, int dir) {
		if(num>3)
			return;
		if(arr[num][6] == arr[num-1][2])
			return;
		checkR(num+1, -dir);
		
		rotation(num, dir);
	}
	public static void rotation(int num, int dir) {
		//시계방향
		if(dir == 1) {
			int tmp = arr[num][7];
			for(int i=7; i>0; i--) {
				arr[num][i] = arr[num][i-1];
			}
			arr[num][0] = tmp;
		}
		//반시계방향
		if(dir == -1) {
			int tmp = arr[num][0];
			for(int i=0; i<7; i++) {
				arr[num][i] = arr[num][i+1];
			}
			arr[num][7] = tmp;
		}
	}
}
