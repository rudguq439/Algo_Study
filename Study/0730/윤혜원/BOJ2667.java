package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2667단지번호붙이기 {
	static int N;
	static int[][] arr;
	static int[] apt;
	static boolean[][] v;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		v = new boolean[N][N];
		apt = new int[N];
		
		for(int i=0; i<N; i++) {
			String st = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(st.charAt(j)));
				if(arr[i][j] == 0) {
					v[i][j] = true;
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 1 && v[i][j] == false) {
					count++;
					dfs(i, j);
				}
			}
		}
		Arrays.sort(apt);
		System.out.println(count);
		for(int i=0; i<apt.length; i++) {
			if(apt[i] != 0)
				System.out.println(apt[i]);
		}
	}
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void dfs(int x, int y) {
		v[x][y] = true;
		apt[count]++;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
			if(arr[nx][ny] == 1 && v[nx][ny] == false) {
				dfs(nx, ny);
			}
		}
		
	}

}
