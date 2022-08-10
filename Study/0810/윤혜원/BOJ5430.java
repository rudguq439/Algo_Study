package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOKJ5430AC {
	static int T;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			String ps = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");
			AC(ps, n, arr);
		}
		
	}
	static void AC(String ps, int n, String[] arr) {
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i=0; i<n; i++) {
			dq.offer(Integer.parseInt(arr[i]));
		}
		boolean reverse = true;
		
		for(int i=0; i<ps.length(); i++) {
			char p = ps.charAt(i);
			if(p == 'R') {
				reverse = !reverse;
			}else {
				if(dq.isEmpty()) {
					System.out.println("error");
					return;
				}
				if(reverse) {
					dq.pollFirst();
				}else {
					dq.pollLast();
				}
			}
		}
		System.out.print("[");
		while(!dq.isEmpty()) {
			if(reverse) {
				System.out.print(dq.poll());
			}else {
				System.out.print(dq.pollLast());
			}
			if(!dq.isEmpty()) System.out.print(",");
		}
		System.out.println("]");
	}

}
