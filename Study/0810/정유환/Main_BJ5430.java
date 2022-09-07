package week9_0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BJ5430 {
	
	private static boolean exec(LinkedList<Integer> list, String P) {
		boolean res = true;
		boolean rev = false;
		
		int plen = P.length();
		for(int i = 0; i < plen; i++) {
			char order = P.charAt(i);
			
			if(order == 'R') rev = !rev;
			else {
				if(list.size() == 0) {
					res = false;
					break;
				}
				//반대로 돌렸을 경우 뒤를 빼면 된다
				if(rev) list.pollLast();
				else list.pollFirst();
			}
		}
		
		if(rev) {
			Collections.reverse(list);
		}
		
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			String P = br.readLine();
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(),"[],");
			LinkedList<Integer> list = new LinkedList<>();
			
			for(int n = 0; n < N; n++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			if(exec(list,P)) {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				for(int i : list) {
					sb.append(i+",");
				}
				//값이 없을 때 앞 [ 지우는 것 방지
				if(sb.length() != 1) sb.deleteCharAt(sb.length()-1);
				sb.append("]");
				
				System.out.println(sb);
			}
			else System.out.println("error");
		}
	}

}
