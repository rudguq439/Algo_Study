package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874스택수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int num = 1;
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=1; i<=n; i++) {
			stack.push(i);
			sb.append("+").append("\n");
			while(!stack.empty()) {
				if(stack.peek() == arr[num]) {
					stack.pop();
					sb.append("-").append("\n");
					num++;
				}else {
					break;
				}
			}
		}
		if(stack.empty()) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
	}

}
