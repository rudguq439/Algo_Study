package week4_0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_BJ11559 {

	private static class Puyo {
		int x;
		int y;
		
		public Puyo(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {-1,1,0,0};
	
	private static void bfs(char[][] field, List<Puyo> list, boolean[][] visited, int x, int y) {
		Queue<Puyo> q = new LinkedList<>();
		q.add(new Puyo(x,y));
		list.add(new Puyo(x,y));
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			Puyo cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
				if(visited[ny][nx] || field[ny][nx] == '.') continue;
				if(field[ny][nx] != field[y][x]) continue;
				
				q.add(new Puyo(nx,ny));
				list.add(new Puyo(nx,ny));
				visited[ny][nx] = true;
			}
		}
	}
	
	private static void pop(char[][] field, List<Puyo> list) {
		for(Puyo p : list) {
			field[p.y][p.x] = '.';
		}
	}
	
	private static void fall(char[][] field) {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i < 6; i++) {
			//뿌요 위치 저장
			for(int j = 0; j < 12; j++) {
				if(field[i][j] == '.') continue;
				
				q.add(j);
			}
			
			int cnt = 0;
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				//같은 위치는 바꿀 필요 없음
				if(cur == cnt) {
					cnt++;
					continue;
				}
				
				field[i][cnt] = field[i][cur];
				field[i][cur] = '.';
				cnt++;

			}
			
//			for(int x = 0; x < 6; x++) {
//				System.out.println(Arrays.toString(field[x]));
//			}
//			System.out.println();
		}
	}
	
	private static int checkChain(char[][] field) {
		int chain = 0;
		
		List<Puyo> list = new ArrayList<>();
		boolean[][] visited = new boolean[6][12];
		
		while(true) {
			boolean done = true;
			
			for(int i = 0; i < 6; i++) {
				if(field[i][0] == '.') continue;
				
				for(int j = 0; j < 12; j++) {
					if(visited[i][j] || field[i][j] == '.') continue;
					
					bfs(field,list,visited,j,i);
					if(list.size() > 3) {
						pop(field, list);
						done = false;
					}
					//체인 뿌요 리스트 제거
					list.clear();
				}
			}
			//연쇄 끝나면
			fall(field);
			
			//더 이상 터질 뿌요가 없을 경우
			if(done) break;
			chain++;
			
			//뿌요 확인 초기화
			for(int i = 0; i < 6; i++) {
				Arrays.fill(visited[i], false);
			}
		}
		
		return chain;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] input = new char[12][6];
		char[][] field = new char[6][12];
		
		for(int i = 11; i >= 0; i--) {
			input[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 12; j++) {
				field[i][j] = input[j][i];
			}
		}
		
		int ans = checkChain(field);
		
		System.out.println(ans);
	}

}
