package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15988123더하기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()); // 테케
		long[] d = new long[1_000_001]; //범위때문에 long
		
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		//d[4] = 1 + 2 + 4 = 7
		//점화식 d[i] = d[i-1] + d[i-2] + d[i-3]
		
		for(int i=4; i<= 1_000_000; i++) {
			d[i] = (d[i-1] + d[i-2] + d[i-3]) % 1_000_000_009;
		}
		while(tc > 0) { //테케만큼 돌림
			int n = Integer.parseInt(br.readLine());
			System.out.println(d[n]);
			tc--;
		}
	}

}
