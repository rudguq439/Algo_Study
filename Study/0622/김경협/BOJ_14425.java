import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_14425 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		
		for(int i = 0; i < N; i++)
			set.add(br.readLine());
		
		
		int cnt = 0;
		for(int i = 0; i < M; i++)
			if(set.contains(br.readLine()))
				cnt++;
		
		System.out.println(cnt);

	}

}
