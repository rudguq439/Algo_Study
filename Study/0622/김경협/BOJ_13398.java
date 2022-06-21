import java.util.*;
import java.io.*;

public class BOJ_13398 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] inputs = new int[N];
		
		for(int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] undeleted = new int[N], deleted = new int[N];
		
		// 초기값 세팅
		undeleted[0] = deleted[0] = inputs[0];
	
		int largest = inputs[0];
		for(int i = 1; i < N; i++) {
			// undeleted[i] = MAX(undeleted[i-1] + 현재값, 현재값)
			undeleted[i] = Math.max(undeleted[i-1] + inputs[i], inputs[i]);
			// deleted[i] = MAX(deleted[i-1] + inputs[i], undeleted[i - 1])
			// MAX(이전에 삭제를 시행한 경우 현재 값은 삭제 안해도 되기에 inputs 합한 값,
			// 		현재 값을 삭제해야 하는 경우)
			deleted[i] = Math.max(deleted[i-1] + inputs[i], undeleted[i-1]);
			largest = Math.max(largest, Math.max(undeleted[i], deleted[i]));	// 삭제 해도 되고, 안해도 되기 때문에 3개를 비교해준다.
		}
		
		System.out.println(largest);
	}

}
