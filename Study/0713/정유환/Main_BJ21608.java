package week5_0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BJ21608 {
	
	private static class Student {
		int x, y;
		int[] friends;
		
		public Student(int x, int y, int[] friends) {
			this.x = x;
			this.y = y;
			this.friends = friends;
		}
	}
	
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {-1,1,0,0};
	
	private static int N;
	private static int[][] classroom, nearEmpty;
	private static Map<Integer, Student> seated;
	
	//인접한 빈 공간 갯수 초기화
	private static void initNearEmpty() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int cnt = 4;

				if(i == 0 || i == N-1) cnt--;
				if(j == 0 || j == N-1) cnt--;
				nearEmpty[i][j] = cnt;
			}
		}
	}
	
	//좋아하는 학생이 인접한 칸이 가장 많은 칸 찾기
	private static int[][] findNearFriend(int[] friends) {
		int[][] nearFriend = new int[N][N];
		
		for(int f : friends) {
			//친구가 자리에 앉았는지 확인, 해당 위치 주변 카운트 증가
			if(seated.containsKey(f)) {
				Student s = seated.get(f);
				
				for(int d = 0; d < 4; d++) {
					int nx = s.x + dx[d];
					int ny = s.y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if(classroom[ny][nx] != 0) continue;
					
					nearFriend[ny][nx]++;
				}
			}
		}
		
		return nearFriend;
	}
	
	//자리 찾기
	private static void findSeat(int no, int[] friends) {
		int[][] nearFriend = findNearFriend(friends);
		
		int cx = -1;
		int cy = -1;
		int maxNearEmpty = Integer.MIN_VALUE;
		int maxNearFriend = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				//이미 자리 앉은 위치는 패스
				if(classroom[i][j] != 0) continue;
				
				//좋아하는 학생 인접 카운트가 maxNearEmpty 값보다 크면 해당 위치에 배치
				if(maxNearFriend < nearFriend[i][j]) {
					cx = j;
					cy = i;
					maxNearFriend = nearFriend[i][j];
					maxNearEmpty = nearEmpty[i][j];
				}
				//좋아하는 학생 인접 카운트가 같으면 인접한 빈 공간이 많은 위치에 배치
				else if(maxNearFriend == nearFriend[i][j] && 
						maxNearEmpty < nearEmpty[i][j]) {
					cx = j;
					cy = i;
					maxNearEmpty = nearEmpty[i][j];
				}
				
			}
		}
		
		//배치해주고 seated에 저장
		classroom[cy][cx] = no;
		seated.put(no, new Student(cx,cy,friends));
		
		//자리에 앉아서 해당 위치에 인접한 위치에 저장된 빈 공간 갯수를 1 빼주기
		for(int d = 0; d < 4; d++) {
			int nx = cx + dx[d];
			int ny = cy + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(classroom[ny][nx] != 0) continue;
			
			nearEmpty[ny][nx]--;
		}
	}
	
	private static int calcSatisfy() {
		int total = 0;
		
		for(int i = 1; i <= N*N; i++) {
			Student s = seated.get(i);
			
			int cnt = 0;
			
			//친구와 인접한지 (거리 값 1) 확인
			for(int f : s.friends) {
				if(Math.abs(seated.get(f).x - s.x) + Math.abs(seated.get(f).y - s.y) == 1) {
					cnt++;
				}
			}
			
			if(cnt == 1) total += 1;
			else if(cnt == 2) total += 10;
			else if(cnt == 3) total += 100;
			else if(cnt == 4) total += 1000;
		}
		
		return total;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		classroom = new int[N][N];
		nearEmpty = new int[N][N];
		
		initNearEmpty();
		seated = new HashMap<>();
		
		for(int n2 = 0; n2 < N*N; n2++) {
			st = new StringTokenizer(br.readLine());
			int no = Integer.parseInt(st.nextToken());
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			int f3 = Integer.parseInt(st.nextToken());
			int f4 = Integer.parseInt(st.nextToken());
			
			findSeat(no, new int[] {f1,f2,f3,f4});
		}
		
		int point = calcSatisfy();
		
		System.out.println(point);
	}

}
