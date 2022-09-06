package week8_0801;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ16953 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int cnt = 0;	
		while(true) {
			if(B <= A) break;
			
			if(B % 2 == 0) {
				B /= 2;
				cnt++;
			}
			else if(B % 10 == 1) {
				B /= 10;
				cnt++;
			}
			else {
				break;
			}
		}
		
		if(B == A) System.out.println(cnt+1);
		else System.out.println(-1);
	}

}
