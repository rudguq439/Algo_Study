package week7_0725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ14719 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		boolean[][] blocks = new boolean[H][W];
		
		st = new StringTokenizer(br.readLine());
		
		for(int w = 0; w < W; w++) {
			int b = Integer.parseInt(st.nextToken());
			
			for(int h = 0; h < b; h++) {
				blocks[h][w] = true;
			}
		}
		
		int cnt = 0;
		
		for(int h = 0; h < H; h++) {
			int tmp = 0;
			boolean flag = false;
			
			for(int w = 0; w < W; w++) {
				//처음 벽이 나온 뒤 부터 계산
				if(blocks[h][w]) flag = true;
				if(flag) {
					//다시 벽이 나오면 지금까지 카운트 한 값이 고인 물 양
					if(blocks[h][w]) {
						cnt += tmp;
						tmp = 0;
					}
					else tmp++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
