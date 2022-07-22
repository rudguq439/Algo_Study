package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ21608상어초등학교 {
	static int[][] classroom, nearEmptySeatCnt;
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Student{
		int x;
		int y;
		int[] flist;
		
		public Student(int x, int y, int[] flist) {
			this.x = x;
			this.y = y;
			this.flist = flist;
		}
	}
	
	static Map<Integer, Student> list = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int N2 = N*N;
		int ans = 0;
		classroom = new int[N][N];
		fillNearEmptySeat();
		
		for(int i=0; i<N2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			int s3 = Integer.parseInt(st.nextToken());
			int s4 = Integer.parseInt(st.nextToken());
			
			findSeat(num, new int[] {s1,s2,s3,s4});
		}
		
		// list에서 1번 학생부터 꺼내서 친한 친구들과의 거리를 잰다
		// 거리가 1이면 인접하므로 cnt를 1씩 증가시켜준다
		// 4명을 다돌아서 cnt값이 정해지면, 해당되는 만족도를 answer에 더해준다
		for(int i=1; i<=N2; i++) {
			Student student = list.get(i);
			int cnt = 0;
			for(int friend : student.flist) {
				if(Math.abs(list.get(friend).x -student.x) 
						+ Math.abs(list.get(friend).y - student.y) == 1) {
					cnt++;
				}
			}
			
			if(cnt==1) 
				ans+=1;
			else if(cnt==2) 
				ans+=10;
			else if(cnt==3) 
				ans+=100;
			else if(cnt==4) 
				ans+=1000;
		}
		
		System.out.println(ans);
		
	}

	private static void findSeat(int num, int[] friends) {
		// 친한친구 자리가 이미 선정 되었다면 친구와 인접한 곳의 점수를 높여 우선적으로 선택할 수 있게 체크하는 배열
		int[][] nearScore = new int[N][N]; //주변에 친한 친구가 많은 위치를 찾기 위한 배열
		//list에 등록된(이미 자리를 찾은) 친구들이 있는지 확인
		for(int friend : friends) {
			if(list.containsKey(friend)) {
				Student student = list.get(friend);
				int x = student.x;
				int y = student.y;
				
				//그 친구들의 4방 중 빈곳의 점수를 높인다
				for(int i=0; i<4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(nx>=0 && nx <N && ny >=0 && ny < N && classroom[nx][ny] == 0) {
						nearScore[nx][ny]++;
					}
				}
			}
		}
		
		int emptyCntMax = -1;
		int nearScoreMax = -1;
		int choiceX = -1;
		int choiceY = -1;
		
		// classroom은 교실, 배열의 한칸은 책상
		// (0,0)부터 탐색하면서 nearScoreMax(nearScore 중 점수가 높은 곳)를 1순위로, 
		// 그 다음은 emptyCntMax(nearEmptySeatCnt 중 점수가 높은 곳)를 2순위로 적당한 자리를 찾아나간다
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(classroom[i][j] != 0) continue;
				if(nearScoreMax < nearScore[i][j]) {
					choiceX = i;
					choiceY = j;
					nearScoreMax = nearScore[i][j];
					emptyCntMax = nearEmptySeatCnt[i][j];
				} else if(nearScoreMax == nearScore[i][j] && emptyCntMax < nearEmptySeatCnt[i][j]) {
					emptyCntMax = nearEmptySeatCnt[i][j];
					choiceX = i;
					choiceY = j;
				}
			}
		}
		
		classroom[choiceX][choiceY] = num;
		// 자리를 찾은 이후에는 list에 집어넣고
		list.put(num, new Student(choiceX,choiceY, friends));
		
		//선정된 자리의 nearEmptySeatCnt 4방을 1씩 낮춰준다
		for(int i=0; i<4; i++) {
			int nx = choiceX+dx[i];
			int ny = choiceY+dy[i];
			if(nx>=0 && nx <N && ny >=0 && ny < N && classroom[nx][ny] == 0) {
				nearEmptySeatCnt[nx][ny]--;
			}
		}
	}
	
	// 주변에 비어있는 자리가 얼마나 있는지를 저장
	private static void fillNearEmptySeat() {
		nearEmptySeatCnt = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int cnt = 4;
				if(i==0 || i==N-1) cnt--;
				if(j==0 || j==N-1) cnt--;
				nearEmptySeatCnt[i][j] = cnt;
			}
		}
	}
}
