package week3_0627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ20056 {
	
	private static class Fireball {
		int r, c, m, s, d;
		
		public Fireball(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	private static int[] dc = {0,1,1,1,0,-1,-1,-1};
	private static int[] dr = {-1,-1,0,1,1,1,0,-1};
	
	private static void move(List<Fireball>[][] map, List<Fireball> fireballs, int N) {
		for(Fireball fb : fireballs) {
			int nr = (fb.r + N + dr[fb.d] * (fb.s % N)) % N;
			int nc = (fb.c + N + dc[fb.d] * (fb.s % N)) % N;
			
			fb.c = nc;
			fb.r = nr;
			map[nr][nc].add(fb);
		}
	}
	
	private static void check(List<Fireball>[][] map, List<Fireball> fireballs, int N) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				//맵 상 fireball 제거 -> fireballs 에 정보 이미 저장 되어 있음
				if(map[i][j].size() == 1) map[i][j].clear();
				//겹치지 않음
				if(map[i][j].size() < 2) continue;
				
				//겹칠 경우
				int m = 0;
				int s = 0;
				int size = map[i][j].size();
				//합한게 짝수인지 홀수인지 확인하고 분산 방향 결정
				boolean even = map[i][j].get(0).d % 2 == 0 ? true : false;
				boolean odd = map[i][j].get(0).d % 2 == 1 ? true : false;
				
				for(Fireball fb : map[i][j]) {
					m += fb.m;
					s += fb.s;
					even &= fb.d % 2 == 0 ? true : false;
					odd &= fb.d % 2 == 1 ? true : false;
					
					fireballs.remove(fb);
				}
				map[i][j].clear();
				
				int nm = m/5;
				//질량 0 소멸
				if(nm == 0) continue;
				
				int ns = s/size;
				//모두 짝수거나 홀수면
				if(even|odd) {
					for(int f = 0; f < 8; f+=2) {
						fireballs.add(new Fireball(i,j,nm,ns,f));
					}
				}
				else {
					for(int f = 1; f < 8; f+=2) {
						fireballs.add(new Fireball(i,j,nm,ns,f));						
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Fireball> fireballs = new ArrayList<>();
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			
			//r행 c렬 m질량 s속력 d방향
			fireballs.add(new Fireball(
				Integer.parseInt(st.nextToken())-1,
				Integer.parseInt(st.nextToken())-1,
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())
			));
		}
		
		List<Fireball>[][] map = new ArrayList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<Fireball>();
			}
		}
		
		for(int k = 0; k < K; k++) {
			move(map, fireballs, N);
			check(map, fireballs, N);
		}
		
		int ans = 0;
		for(Fireball fb : fireballs) {
			ans += fb.m;
		}
		
		System.out.println(ans);
	}

}
