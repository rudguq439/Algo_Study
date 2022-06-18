package week1_0613;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ1244 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//스위치 배열 생성
		int SN = Integer.parseInt(br.readLine().trim());
		int[] switches = new int[SN+1];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		for(int i = 1; i <= SN; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		//학생 확인
		int PN = Integer.parseInt(br.readLine().trim());
		int gender = 0;
		int idx = 0;
		
		for(int i = 0; i < PN; i++) {
			st = new StringTokenizer(br.readLine().trim());
			gender = Integer.parseInt(st.nextToken());
			idx = Integer.parseInt(st.nextToken());
			
			//남자
			if(gender == 1) {
				for(int j = idx; j <= SN; j+=idx) {
					switches[j] = switches[j] == 0 ? 1 : 0;
				}
			}
			//여자
			else {
				for(int j = 1; idx-j > 0 && idx+j <= SN; j++) {
					if(switches[idx-j] == switches[idx+j]) {
						switches[idx-j] = switches[idx-j] == 0 ? 1 : 0;
						switches[idx+j] = switches[idx+j] == 0 ? 1 : 0;
					}
					else break;
				}
				switches[idx] = switches[idx] == 0 ? 1 : 0;
			}
			
		}
		
		for(int i = 1; i <= SN; i++) {
			System.out.print(switches[i] +" ");
			if(i % 20 == 0) System.out.println();
		}
	}

}
