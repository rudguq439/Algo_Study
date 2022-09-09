package 스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15684사다리조작 {
	static int n, m, h, answer;
	static int[][] map;
	static boolean finish = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h+1][n+1];
		
		for(int i=0; i<m; i++) {
			int x, y;
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			map[x][y] = 1; // 오른쪽에 사다리 있음
			map[x][y+1] = 2; // 왼쪽에 사다리 있음
		}
		
		for(int i=0; i<=3; i++) {
			answer = i;
			dfs(1, 0);
			if(finish)
				break;
		}
		System.out.println((finish) ? answer : -1);
	}
	public static void dfs(int x, int count) {
		if(finish)
			return;
		if(answer == count) {
			if(check()) {
				finish = true;
				return;
			}
		}
		//높이 depth를 1부터 h까지
		for(int i=x; i<h+1; i++) {
			//1번부터 마지막 전 세로선까지
			for(int j=1; j<n; j++) {
				if(map[i][j] == 0)
			}
		}
		
	}

}
