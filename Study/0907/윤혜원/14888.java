
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int num[];
	static int op[] = new int[4];
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(num[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
	public static void dfs(int a, int cnt) {
		if(cnt == N) {
			max = Math.max(max, a);
			min = Math.min(min, a);
			return;
		}
		for(int i=0; i<4; i++) {
			if(op[i] > 0) {
				op[i]--;
				
				if(i == 0) 
					dfs(a+num[cnt], cnt+1);
				else if(i == 1) 
					dfs(a-num[cnt], cnt+1);
				else if(i == 2)
					dfs(a*num[cnt], cnt+1);
				else if(i == 3)
					dfs(a/num[cnt], cnt+1);
				
				op[i]++;
			}
		}
	}

}
