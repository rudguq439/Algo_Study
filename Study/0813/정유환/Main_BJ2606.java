package week9_0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ2606 {
	
	private static int bfs(List<List<Integer>> links, int N) {
		int cnt = 0;
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		q.add(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i : links.get(cur)) {
				if(visited[i]) continue;
				q.add(i);
				visited[i] = true;
				//바이러스 걸린 컴퓨터 추가
				cnt++;
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<List<Integer>> links = new ArrayList<>();
		for(int n = 0; n <= N; n++) {
			links.add(new ArrayList<>());
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			links.get(a).add(b);
			links.get(b).add(a);
		}
		
		int res = bfs(links,N);
		System.out.println(res);
	}

}
