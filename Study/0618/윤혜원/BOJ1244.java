package 스터디;

/*
1은 on 0은 off
남학생 : 번호가 받은 수의 배수면 스위치 바꿈
ex) 3을 받았으면 3번, 6번의 상태를 바꿈
여학생 : 받은 번호를 중심으로 좌우가 대칭이면서 제일 많은 스위치를 포함하는 구간의 상태를 바꿈

*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준1244스위치켜고끄기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sn = Integer.parseInt(br.readLine()); //스위치 개수
		int[] switches = new int[sn];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<sn; i++) { //스위치 받아오기
			switches[i] = Integer.parseInt(st.nextToken()); //01010001
		}
		
		int snum = Integer.parseInt(br.readLine()); //학생 수 2
		for(int i=0; i<snum; i++) {
			st = new StringTokenizer(br.readLine());
			int gen = Integer.parseInt(st.nextToken()); //1
			int num = Integer.parseInt(st.nextToken()); //3
			if(gen == 1) { //남자라면
				for(int j = 0; j < sn; j++) {
					if((j+1) % num == 0) { //배수확인
						switches[j] = switches[j] == 0 ? 1 : 0;
					}
				}
			}else if(gen == 2) { //여자라면
				//좌우대칭
				int LS = num-1;
				switches[LS] = switches[LS] == 0 ? 1 : 0;
				for(int j=0; j<sn/2; j++) {
					if(LS+j >= sn || LS-j < 0) { //범위 지정
						break;
					}
					if(switches[LS-j] == switches[LS+j]) { //앞뒤가 같으면
						switches[LS -j] = switches[LS -j] == 0 ? 1 : 0; //앞쪽변경
						switches[LS +j] = switches[LS +j] == 0 ? 1 : 0; //뒤쪽변경
					}
					else
						break;
				}
			}
		}
		for(int i=0; i<sn; i++) {
			System.out.print(switches[i] + " ");
			if((i+1) % 20 == 0)
				System.out.println();
		}

	}
}
