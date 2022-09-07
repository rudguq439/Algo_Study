package week8_0801;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main_BJ9012 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		List<String> res = new ArrayList<>();
		
		for(int t = 0; t < T; t++) {
			String s = br.readLine();
			
			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			int len = s.length();
			
			for(int i = 0; i < len; i++) {
				char c = s.charAt(i);
				
				if(c == '(') {
					stack.add(c);
				}
				else {
					if(stack.isEmpty()) {
						flag = false;
						break;
					}
					if(stack.peek() == '(') stack.pop();
					else {
						flag = false;
						break;
					}
				}
			}
			
			if(stack.isEmpty() && flag) res.add("YES");
			else res.add("NO");	
		}
		
		for(String s : res) {
			System.out.println(s);
		}
	}
}
