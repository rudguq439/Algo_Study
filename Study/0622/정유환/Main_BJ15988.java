package week2_0620;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ15988 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		long[] d = new long[1000001];
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		
		for(int i = 4; i <= 1000000; i++) {
			d[i] = (d[i-1] + d[i-2] + d[i-3]) % 1000000009;
		}
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(d[n]);
		}
	}

}
/*
F[A] = B => 숫자 A에서 1,2,3을 사용해 A를 만들 수 있는 경우의 수 B
F[1] -> 1 = 1
F[2] -> 1+1 2 = 2
F[3] -> 1+1+1 1+2 2+1 3 = 4
F[4] ->
'1'+3 => F[1]+3 : F[1]에 3만 더하면 된다
'1+1'+2 '2'+2 => F[2]+2 : F[2]에 2만 더하면 된다
'1+1+1'+1 '1+2'+1 '2+1'+1 '3'+1 => F[3]+1 : F[3]에 1만 더하면 된다
= 7

==> F[4] = F[3] + F[2] + F[1]
*/
