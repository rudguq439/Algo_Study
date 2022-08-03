package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14719빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken()); //세로 길이
		int W = Integer.parseInt(st.nextToken()); //가로 길이
		
		int arr[] = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		for (int i = 1; i < W - 1; i++) {
			int left = 0;
			int right = 0;
			//왼쪽
			for (int j = 0; j < i; j++) {
				left = Math.max(arr[j], left);
			}
			//오른쪽
			for (int j = i + 1; j < W; j++) {
				right = Math.max(arr[j], right);
			}
			System.out.println("left  "+left);
			System.out.println("right  "+right);
			if (arr[i] < left && arr[i] < right) {
				count += Math.min(left, right) - arr[i];
				System.out.println("count "+count);
			}
		}
		System.out.println(count);
	}

}
