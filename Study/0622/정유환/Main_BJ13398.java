import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ13398 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] l = new int[N];
		int[] r = new int[N];
		
		l[0] = arr[0];
		int ans = l[0];
		
		for(int i = 1; i < N; i++) {
			l[i] = Math.max(arr[i], l[i-1] + arr[i]);
			ans = Math.max(ans, l[i]);
		}
		
		r[N-1] = arr[N-1];
		for(int i = N-2; i >= 0; i--) {
			r[i] = Math.max(arr[i], r[i+1] + arr[i]);
		}

		for(int i = 1; i < N-1; i++) {
			ans = Math.max(ans, l[i-1] + r[i+1]);
		}
		
		System.out.println(ans);
	}

}
/*
https://yabmoons.tistory.com/617
*/
