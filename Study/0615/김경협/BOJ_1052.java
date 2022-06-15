import java.util.*;
import java.io.*;

public class BOJ_1052 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println(simulate(N,K));
				
	}
	
	static int simulate(int N, int K) {
		if(currBottle(N) <= K)	// 상점에서 안사도 되는 경우,
			return 0;
		
		// sumCnt는 이진수로 나타냈을 때 자릿수 변경(ex: 1001 to 1010)을 하기 위한 누적합을 말함
		// cnt는 자릿수에 따른 2의 제곱수를 계산
		int originN = N, sumCnt = 0, cnt = 1;
		
		// 이진수로 나타내면 1이 되는 부분에서 sumCnt를 더해주고 물병이 몇 개가 됐는지 계산
		while(N > 0) {
			int remainder = N % 2;
			N /= 2;
			
			if(remainder == 0) {
				
			} else if(remainder == 1) {
				if(currBottle(originN + (cnt - sumCnt)) <= K) {
					return cnt - sumCnt;
				}
				sumCnt += cnt;
			}
			
			cnt *= 2;
		}
		return 1;
	}
	
	// 필요한 물병 수 return
	static int currBottle(int bottle) {
		int cnt = 0;
		while(bottle > 0) {
			int remainder = bottle % 2;
			bottle /= 2;
			
			if(remainder == 1) {
				cnt++;
			}
		}
		return cnt;
	}
}
