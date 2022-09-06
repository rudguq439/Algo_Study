package week7_0725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ2174 {
	
	private static class Robot {
		int x;
		int y;
		int d;
		
		public Robot(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	//N E S W
	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {1,0,-1,0};
	private static int A, B;
	private static Robot[] robots;
	private static int[][] map;
	
	private static boolean move(int no, char order, int cnt) {
		
		switch(order) {
			case 'L':
				//4번 돌면 원상복귀
				cnt %= 4;
				//0->3, 1->0, 2->1, 3->2
				for(int d = 0; d < cnt; d++) {
					robots[no].d = (robots[no].d + 3) % 4;
				}
				break;
				
			case 'R':
				cnt %= 4;
				//0->1, 1->2, 2->3, 3->0
				for(int d = 0; d < cnt; d++) {
					robots[no].d = (robots[no].d + 1) % 4;
				}
				break;
				
			case 'F':
				int d = robots[no].d;
				int nx = robots[no].x;
				int ny = robots[no].y;
				
				map[ny][nx] = 0;
				for(int i = 0; i < cnt; i++) {
					nx += dx[d];
					ny += dy[d];
					
					if(nx < 1 || nx > A || ny < 1 || ny > B) {
						System.out.println("Robot "+ no +" crashes into the wall");
						return true;
					}
					if(map[ny][nx] != 0) {
						System.out.println("Robot "+ no +" crashes into robot "+ map[ny][nx]);
						return true;
					}
				}
				map[ny][nx] = no;
				robots[no].x = nx;
				robots[no].y = ny;
				
				break;
		}
		
		
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		robots = new Robot[N+1];
		map = new int[B+1][A+1];
		
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			int dir = 0;
			if(d == 'N') dir = 0;
			else if(d == 'E') dir = 1;
			else if(d == 'S') dir = 2;
			else dir = 3;
			
			robots[n] = new Robot(x,y,dir);
			map[y][x] = n;
		}
		
		boolean flag = false;
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int no = Integer.parseInt(st.nextToken());
			char order = st.nextToken().charAt(0);
			int cnt = Integer.parseInt(st.nextToken());
			
			flag = move(no,order,cnt);
			if(flag) break;
		}
		
		if(!flag) System.out.println("OK");
	}

}
