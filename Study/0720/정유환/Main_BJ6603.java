package week6_0718;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ6603 {
	
	private static int K;
	private static int[] S;
	private static boolean[] selected;
	
	//조합 출력, 순서 상관 없음 (12 21 같은 것 취급)
	private static void comb(int depth, int start) {
		if(depth == 6) {
			StringBuilder sb = new StringBuilder();
			
			for(int j = 0; j < K; j++) {
				if(!selected[j]) continue;
				if(j != K) sb.append(S[j]+" ");
				else sb.append(S[j]);
			}
			
			System.out.println(sb);
			return;
		}
		
		for(int i = start; i < K; i++) {
			selected[i] = true;
			comb(depth+1,i+1);
			selected[i] = false;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			String input = br.readLine();
			if(input.charAt(0) == '0') break;
			
			st = new StringTokenizer(input);
			
			K = Integer.parseInt(st.nextToken());
			
			S = new int[K];
			
			for(int k = 0; k < K; k++) {
				S[k] = Integer.parseInt(st.nextToken());
			}
			
			selected = new boolean[K];
			
			comb(0,0);
			System.out.println();
		}
	}

}
