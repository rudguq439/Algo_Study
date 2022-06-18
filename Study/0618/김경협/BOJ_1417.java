import java.util.*;
import java.io.*;

public class BOJ_1417 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] votes = new int[N];
		
		for(int i = 0; i < N; i++) {
			votes[i] = Integer.parseInt(br.readLine());
		}
		
		int largestIdx = findLargestIdx(votes, N), cnt = 0;
		
		while(largestIdx != 0) {
			cnt++;
			votes[largestIdx]--;
			votes[0]++;
			
			largestIdx = findLargestIdx(votes, N);
		}
		
		System.out.println(cnt);
	}
	
	static int findLargestIdx(int[] votes, int N) {
		int largestIdx = 0;
		for(int i = 1; i < N; i++) {
			if(votes[i] >= votes[largestIdx]) {
				largestIdx = i;
			}
		}
		return largestIdx;
	}
}
