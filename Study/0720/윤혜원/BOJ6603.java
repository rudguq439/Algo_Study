package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603로또 {
	static int k;
	static int[] arr;
	static boolean[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(st.equals("0")) {
				break;
			}
			k = Integer.parseInt(st.nextToken());
			arr = new int[k];
			selected = new boolean[k];
			for(int i=0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			System.out.println();
		}
	}
	public static void dfs(int depth, int start) {
		if(depth == 6) {
			for(int i=0; i<k; i++) {
				if(selected[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}
		for(int i=start; i<k; i++) {
			selected[i] = true;
			dfs(depth+1, i+1);
			selected[i] = false;
		}
	}

}
