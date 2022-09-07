package week3_0627;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ5525 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		char[] S = br.readLine().toCharArray();
		int[] chk = new int[M];
		int cnt = 0;
		
		for(int i = 1; i < M-1; i++) {
			if(S[i] == 'O' && S[i+1] == 'I') {
				chk[i+1] = chk[i-1] + 1;
				
				if(chk[i+1] >= N && S[i-2*N+1] == 'I') cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
//    O O I O I O I O I I O I I
//chk 0 0 1 0 2 0 3 0 4 0 0 1 0
//cnt     0   1   2   3     4	IOI
//cnt     0   0   1   2     2	IOIOI

//String S = br.readLine();	
//String P = "IOI";
//
//for(int n = 1; n < N; n++) {
//	P += "OI";
//}
//
//int pos = 0;
//int cnt = 0;
//
//while(true) {
//	pos = S.indexOf(P);
//	if(pos == -1) break;
//	
//	S = S.substring(pos+1, M);
//	M -= pos+1;
//	cnt++;
//}
//
//System.out.println(cnt);