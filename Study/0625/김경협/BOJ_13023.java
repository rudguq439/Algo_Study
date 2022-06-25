import java.util.*;
import java.io.*;

public class BOJ_13023 {
	static int N, M;
	static boolean visited[], isABCDE;
	static ArrayList<Integer> relation[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		relation = new ArrayList[N];
		
		for(int i = 0; i < N; i++)
			relation[i] = new ArrayList<Integer>();
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			relation[a].add(b);
			relation[b].add(a);
		}
		
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i, 1);
			visited[i] = false;
			
			if(isABCDE) break;
		}
		System.out.println(isABCDE ? 1 : 0);
	}
	
	static void dfs(int idx, int depth) {
		if(depth >= 5) {
			isABCDE = true;
			return;
		}
		
		if(isABCDE) return;
		
		for(int i = 0; i < relation[idx].size(); i++) {
			int friend = relation[idx].get(i);
			
			if(visited[friend]) continue;
			
			visited[friend] = true;
			dfs(friend, depth + 1);
			visited[friend] = false;
		}
	}

}
