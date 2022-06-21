package week1_0613;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ1388 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char [][] floor = new char[N][M];
		boolean [][] checked = new boolean[N][M];
		int cnt = 0;
		
		//바닥 배열 생성
		for(int i = N-1; i >= 0; i--) {
			String line = br.readLine().trim();
			
			for(int j = 0; j < M; j++) {
				floor[i][j] = line.charAt(j);
			}
		}
		
		//읽기 시작
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(checked[i][j]) continue;
				
				//'-'일 경우 가로 확인
				if(floor[i][j] == '-') {
					for(int idx = j; idx < M; idx++) {
						if(floor[i][idx] == '-') {
							checked[i][idx] = true;						
						}
						else break;
					}
					cnt++;
				}
				//'|'일 경우 세로 확인
				else {
					for(int idx = i; idx < N; idx++) {
						if(floor[idx][j] == '|') {
							checked[idx][j] = true;
						}
						else break;
					}
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
