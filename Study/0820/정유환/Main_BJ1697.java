package weeka10_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ1697 {
	
	private static int bfs(int N, int K) {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		int[] visited = new int[100001];
		visited[N] = 1;
		
		while(!q.isEmpty()) {
			int n = q.poll();
			
			if(n == K) return visited[n]-1;
			if(n-1 >= 0 && visited[n-1] == 0) {
				visited[n-1] = visited[n] + 1;
				q.add(n-1);
			}
			if(n+1 <= 100000 && visited[n+1] == 0) {
				visited[n+1] = visited[n] + 1;
				q.add(n+1);
			}
			if(2*n <= 100000 && visited[2*n] == 0) {
				visited[2*n] = visited[n] + 1;
				q.add(2*n);
			}
		}
		
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int cnt = bfs(N,K);
		System.out.println(cnt);
	}

}
