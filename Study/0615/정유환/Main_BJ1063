import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ1063 {

	private static int kx, ky, sx, sy;
	private static int[] dx = {0,0,-1,1,-1,1,-1,1};
	private static int[] dy = {1,-1,0,0,1,1,-1,-1};
	
	private static void checkConditions(int d) {
		int tkx = kx + dx[d];
		int tky = ky + dy[d];
		int tsx = sx + dx[d];
		int tsy = sy + dy[d];
		
		//이동 위치가 범위에 벗어나는지
		if(tkx < 1 || tkx > 8 || tky < 1 || tky > 8) return;

		//이동 위치가 돌 위치
		if(tkx == sx && tky == sy) {
			if(tsx < 1 || tsx > 8 || tsy < 1 || tsy > 8) return;
			
			sx = tsx;
			sy = tsy;
		}
		kx = tkx;
		ky = tky;
	}
	
	private static void movement(String move) {
		int d = -1;
		
		//방향에 따른 방향 값 설정
		switch(move) {
			case "R":
				d = 3; break;
			case "L":
				d = 2; break;
			case "B":
				d = 1; break;
			case "T":
				d = 0; break;
			case "RT":
				d = 5; break;
			case "LT":
				d = 4; break;
			case "RB":
				d = 7; break;
			case "LB":
				d = 6; break;
		}
		if(d == -1) return;
		checkConditions(d);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		//체스 위치를 int로 변환
		String king = st.nextToken();
		kx = king.charAt(0) - 'A' + 1;
		ky = king.charAt(1) - '0';
		
		String stone = st.nextToken();
		sx = stone.charAt(0) - 'A' + 1;
		sy = stone.charAt(1) - '0';
		
		int N = Integer.parseInt(st.nextToken());

		for(int n = 0; n < N; n++) {
			String move = br.readLine();
			//이동 수행
			movement(move);
		}
		
		char rkx = (char)(kx - 1 + 'A');
		char rky = (char)(ky + '0');
		char rsx = (char)(sx - 1 + 'A');
		char rsy = (char)(sy + '0');
		
		System.out.println(rkx+""+rky);
		System.out.println(rsx+""+rsy);
	}

}
