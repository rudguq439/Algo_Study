package week6_0718;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ2504 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = s.length();
		
		int ans = 0;
		int temp = 1;
		boolean flag = false;
		
		Stack<Character> stack = new Stack<>();

		for(int i = 0; i < len; i++) {
			char c = s.charAt(i);
			
			if(c == '(') {
				stack.add(c);
				temp *= 2;
			}
			else if(c == '[') {
				stack.add(c);
				temp *= 3;
			}
			else {
				if(c == ')') {
					if(stack.empty() || stack.peek() != '(') {
						flag = true;
						break;
					}
					if(s.charAt(i-1) == '(') ans += temp;
					
					stack.pop();
					temp /= 2;
				}
				else if(c == ']') {
					if(stack.empty() || stack.peek() != '[') {
						flag = true;
						break;
					}
					if(s.charAt(i-1) == '[') ans += temp;
					
					stack.pop();
					temp /= 3;
				}
			}
		}
		
		if(flag || !stack.empty()) {
			System.out.println(0);
		}
		else {
			System.out.println(ans);
		}
	}
}

//(()[[]])([]) => 2*(2+3*3)+2*3 => 2*2 + 2*3*3 + 2*3