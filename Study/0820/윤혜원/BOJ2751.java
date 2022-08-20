package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697숨바꼭질 {
	static int visited[] = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(N==K) {
			System.out.println("0");
			return;
		}
		bfs(N, K);
		System.out.println(visited[K]);
	}
	public static void bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		
		visited[n] = 0;
		q.offer(n);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			if(visited[k]!=0) break;
			if(x-1>=0 && visited[x-1] == 0) {
				visited[x-1] = visited[x]+1;
				q.offer(x-1);
			}
			if(x+1<visited.length && visited[x+1] == 0) {
				visited[x+1] = visited[x]+1;
				q.offer(x+1);
			}
			if(x*2<visited.length && visited[x*2] == 0) {
				visited[x*2] = visited[x]+1;
				q.offer(x*2);
			}
		}
	}

}
