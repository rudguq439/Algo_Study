package weeka10_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ14500 {
	
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {-1,1,0,0};
	private static int[][] map;
	private static boolean[][] visited;
	private static int N,M;
	private static int max = Integer.MIN_VALUE;
	
	//ㅗ를 제외하고는 dfs 4번하는 것과 같다
	private static void dfs(int x, int y, int sum, int depth) {
		if(depth == 4) {
			max = max < sum ? sum : max;
			
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
			if(visited[ny][nx]) continue;
			
			//ㅗ모양 테트리스를 체크하기 위해 제자리에서 (nx,ny) 자리 빼고 진행
			if(depth == 2) {
				visited[ny][nx] = true;
				dfs(x,y,sum+map[ny][nx],depth+1);
				visited[ny][nx] = false;
			}
			
			visited[ny][nx] = true;
			dfs(nx,ny,sum+map[ny][nx],depth+1);
			visited[ny][nx] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				visited[n][m] = true;
				dfs(m,n,map[n][m],1);
				visited[n][m] = false;
			}
		}
		
		System.out.println(max);
	}
}

