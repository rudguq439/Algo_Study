package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ14425문자열집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //문자열의 개수
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> hs = new HashSet<>();
		int count = 0;
		
		for(int i=0; i<N; i++) {
			hs.add(br.readLine());
		}
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			if(hs.contains(str)) {
				count++;
			}
		}
		System.out.println(count);
		
		br.close();
	}
}
