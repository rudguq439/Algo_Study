package week6_0718;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ15649 {

	private static int N, M;
	private static boolean[] visited;
	private static int[] selected;
	
	//순열 출력
	private static void perm(int depth) {
		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			
			for(int s : selected) {
				sb.append(s+" ");
			}
			
			System.out.println(sb);

			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			selected[depth] = i + 1;
			perm(depth+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		selected = new int[M];
		
		perm(0);
	}
	
}
