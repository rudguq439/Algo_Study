import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ1417 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		int dasom = Integer.parseInt(br.readLine().trim());
		
		//다솜이 혼자면 당선
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		int[] candidates = new int[N-1];
		
		//후보 투표수 배열 생성
		for(int i = 0; i < N-1; i++) {
			candidates[i] = Integer.parseInt(br.readLine().trim());
		}

		int cnt = 0;
		boolean lose = true;
		
		while(lose) {
			//아래 과정을 수행하지 않으면 당선
			lose = false;
			
			//후보 투표수 배열 정령해서 마지막이 당선 후보 투표수
			Arrays.sort(candidates);
			int win = candidates.length-1;
			
			if(dasom <= candidates[win]) {
				dasom++;
				candidates[win]--;
				cnt++;
				lose = true;
			}
		}
		
		//최솟값 출력
		System.out.println(cnt);
	}

}
