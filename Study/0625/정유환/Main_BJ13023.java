package week2_0620;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ13023 {
	
	private static boolean exist = false;
	
	//이어지는 관계 = 깊이로 검색
	private static void dfs(ArrayList<ArrayList<Integer>> rel, boolean[] visited, int start, int cnt) {
		if(cnt == 5) {
			exist = true;
			return;
		}
		
		//처음 들어갈 때 visited true로
		visited[start] = true;
		
		for(int r : rel.get(start)) {
			if(!visited[r]) {
				dfs(rel, visited, r, cnt+1);
			}
			
			if(exist) return;
		}
		
		//만약 조건에 만족하지 않아 뒤로 돌아갈 땐 visited false
		visited[start] = false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> rel = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			rel.add(new ArrayList<>());
		}
		
		//관계 arraylist화 양방향
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			rel.get(a).add(b);
			rel.get(b).add(a);
		}
		
		boolean[] visited = new boolean[N];
	
		//5연속 관계 있는지 확인
		for(int i = 0; i < N; i++) {
			Arrays.fill(visited, false);
			dfs(rel, visited, i, 1);
			
			if(exist) break;
		}
		
		System.out.println(exist ? 1 : 0);

	}

}
