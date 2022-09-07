package week9_0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ1874 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int s = 0;
		while(N > 0) {
			int v = Integer.parseInt(br.readLine());
			
			if(v > s) {
				for(int i = s+1; i <= v; i++) {
					stack.push(i);
					sb.append("+\n");
				}
				s = v;
			}
			//스택에 값을 추가하지 않았을 때 맨 위 값이 v와 같아야 뺀다
			else if(stack.peek() != v) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append("-\n");
			N--;
		}
		
		System.out.println(sb);
	}

}
