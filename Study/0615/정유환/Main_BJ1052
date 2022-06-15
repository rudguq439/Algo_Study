import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ1052 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//N이 K 이하면 물통을 추가할 필요가 없음
		if(N <= K) System.out.println(0);
		else {
			int bottle = 0;
			
			//2의 제곱근이 K의 최소 값 1을 만족하기에 현재 N 값이 2의 제곱근이 되도록 1개씩 추가하는 방식으로 루프 진행
			while(true) {
				int t = N;				
				int cnt = 0;
				
				//현재 사용 중인 최소 물병 갯수 구하기 : 같은 양의 물이 있는 물병을 하나로 합침
				while(t > 0) {
					if(t % 2 != 0) cnt++;
					t /= 2;
				}
				
				//현재 사용 중인 최소 물병 갯수가 K 이하일 때 루프 탈출
				if(cnt <= K) break;
				
				//물병을 1개 추가해주며 이에 따라 N 값도 증가
				N++;
				bottle++;
			}
			
			System.out.println(bottle);
		}
	}

}
