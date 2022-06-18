import java.util.*;
import java.io.*;

public class BOJ_1244 {
	static int N;
	static boolean status[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 스위치의 개수 N
		N = Integer.parseInt(br.readLine());
		status = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			status[i] = "1".equals(st.nextToken()) ? true : false;
		}
		
		// 학생들의 수
		int command = Integer.parseInt(br.readLine());
		for(int i = 0; i < command; i++) {
			st = new StringTokenizer(br.readLine());
			
			if("1".equals(st.nextToken())) {
				// 남자
				man(Integer.parseInt(st.nextToken()));
			} else {
				// 여자
				woman(Integer.parseInt(st.nextToken()));
			}
		}
		
		printSwitch();
		
	}
	
	static void man(int switchIdx) {
		for(int i = 0; i < N; i++) {
			if((i + 1) % switchIdx == 0) {
				status[i] = !status[i];
			}
		}
	}
	
	static void woman(int switchIdx) {
		switchIdx--; // 0번째 인덱스도 포함해주기
		status[switchIdx] = !status[switchIdx];
		for(int i = 1; switchIdx - i >= 0 && switchIdx + i < N; i++) {
			if(status[switchIdx - i] == status[switchIdx + i]) {
				status[switchIdx - i] = !status[switchIdx - i];
				status[switchIdx + i] = !status[switchIdx + i];
			} else {
				break;
			}
		}
	}
	
	static void printSwitch() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0, cnt = 0; i < N; i++, cnt++) {
			sb.append(status[i] ? 1 : 0);
			
			if(cnt == 19) {
				cnt = -1;
				sb.append("\n");
			} else if(i != N - 1){
				sb.append(" ");
			}
		}
		
		System.out.println(sb);
	}
}


