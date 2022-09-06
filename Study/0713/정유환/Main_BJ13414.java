package week5_0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main_BJ13414 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		LinkedHashSet<String> list = new LinkedHashSet<>();
		
		for(int l = 0; l < L; l++) {
			String s = br.readLine();
			if(list.contains(s)) {
				list.remove(s);
			}
			list.add(s);
		}
		
		for(String s : list) {
			if(K <= 0) break;
			System.out.println(s);
			K--;
		}
	}

}
//https://www.grepiu.com/post/9
