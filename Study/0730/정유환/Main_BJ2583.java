package week7_0725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ2583 {
	
	private static int[] dn = {0,0,-1,1};
	private static int[] dm = {-1,1,0,0};
	
	private static void setZone(boolean[][] map, int x1, int y1, int x2, int y2) {
		for(int y = y1; y < y2; y++) {
			for(int x = x1; x < x2; x++) {
				map[y][x] = true;
			}
		}
	}
	
	//빈 칸 크기 bfs로 구하기
	private static List<Integer> findEmpty(boolean[][] map, int M, int N) {
		List<Integer> empty = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();
		
		for(int m = 0; m < M; m++) {
			for(int n = 0; n < N; n++) {
				if(map[m][n] == true) continue;
				
				int[] start = {n,m};
				q.add(start);
				map[m][n] = true;
				int cnt = 1;
								
				while(!q.isEmpty()) {
					int[] cur = q.poll();
					
					for(int d = 0; d < 4; d++) {
						int nn = cur[0] + dn[d];
						int nm = cur[1] + dm[d];
						
						if(nn < 0 || nn >= N || nm < 0 || nm >= M || map[nm][nn]) continue;
						
						int[] npos = {nn, nm};
						q.add(npos);
						map[nm][nn] = true;
						cnt++;
					}
				}
				
				empty.add(cnt);
			}
		}
		
		return empty;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[M][N];
		
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			setZone(map,x1,y1,x2,y2);
		}
		
		List<Integer> empty = findEmpty(map, M, N);
		System.out.println(empty.size());
		Collections.sort(empty);
		
		for(Integer size : empty) {
			System.out.print(size+" ");
		}
		System.out.println();
	}

}
