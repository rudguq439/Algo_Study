package week4_0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ3190 {
	
	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {-1,0,1,0};
	private static int dir = 1;
	
	private static int move(int[][] map, Map<Integer,String> move, int N, int K) {
		int sec = 0;
		//뱀 위치 저장
		Queue<Integer> q = new LinkedList<>();
		q.add(1001);
		
		int x = 1;
		int y = 1;
		
		while(true) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			sec++;
			
			if(nx < 1 || nx > N || ny < 1 || ny > N) break;
			if(q.contains(ny*1000 + nx)) break;
			
			if(map[ny][nx] == 1) {
				//사과를 먹으면 해당 자리 0으로 변경
				map[ny][nx] = 0;
				//뱀머리 이동, 꼬리는 유지
				q.add(ny*1000+nx);
			}
			else {
				//뱀머리 이동
				q.add(ny*1000+nx);
				//꼬리 이동
				q.poll();
			}
			
			//방향 전환
			if(move.containsKey(sec)) {
				String d = move.get(sec);
				//0 > 3, 1 > 0, 2 > 1, 3 > 2
				if("L".equals(d)) dir = (dir+3) % 4;
				//0 > 1, 1 > 2, 2 > 3, 3 > 0				
				else dir = (dir+1) % 4;
			}
			
			x = nx;
			y = ny;
		}
		
		return sec;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N+1][N+1];
		StringTokenizer st;
		
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}
		
		int L = Integer.parseInt(br.readLine());
		Map<Integer,String> move = new HashMap<>();
		
		for(int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			move.put(m, d);
		}
		
		int ans = move(map,move,N,K);
		
		System.out.println(ans);
	}

}
