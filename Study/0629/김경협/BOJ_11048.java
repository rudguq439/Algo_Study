import java.util.*;
import java.io.*;

public class BOJ_11048 {
	
	static int N, M, map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve();
		System.out.println(map[N][M]);
	}
	
	static void solve() {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				int largest = Math.max(map[i-1][j], map[i][j-1]);
				largest = Math.max(largest, map[i-1][j-1]);
				
				map[i][j] += largest;
			}
		}
	}
}
