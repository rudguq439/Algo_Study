package week4_0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ15685 {
	
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,-1,0,1};
	private static boolean[][] map = new boolean[101][101];
	
	private static void dragonCurve(int x, int y, int d, int g) {
		List<Integer> list = new ArrayList<>();
		list.add(d);
		
		//→, → + ↑, →↑ + ←↑, →↑←↑ + ←↓←↑ 뒤에서 부터 반시계 돌린걸 정순으로 저장
		//세대를 횟수로
		for(int i = 1; i <= g; i++) {
			for(int j = list.size()-1; j >= 0; j--) {
				//0 -> 1, 1 -> 2, 2 -> 3, 3 -> 0
				list.add((list.get(j) + 1) % 4);
			}
		}
		
		map[y][x] = true;
		
		for(Integer dir : list) {
			x += dx[dir];
			y += dy[dir];
			map[y][x] = true;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			dragonCurve(x,y,d,g);
		}
		
		int ans = 0;
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) ans++;
			}
		}
		
		System.out.println(ans);
	}

}
