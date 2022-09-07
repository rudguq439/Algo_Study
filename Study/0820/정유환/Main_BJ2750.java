package weeka10_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ2750 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		for(int i : arr) {
			System.out.println(i);
		}
	}

}
