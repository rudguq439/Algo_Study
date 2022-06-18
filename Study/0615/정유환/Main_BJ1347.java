import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ1347 {

	private static int[] dx = {0,-1,0,1};
	private static int[] dy = {-1,0,1,0};
	//남서북동
	
	private static int sx, sy;
	private static int cur_x, cur_y;
	
	private static void createMap(char[][] map) {
		//미로의 크기 범위 구하기
		int max_x = Integer.MIN_VALUE;
		int max_y = Integer.MIN_VALUE;
		int min_x = Integer.MAX_VALUE;
		int min_y = Integer.MAX_VALUE;
		
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(map[i][j] == '\0') continue;
				if(i > max_y) max_y = i;
				if(i < min_y) min_y = i;
				if(j > max_x) max_x = j;
				if(j < min_x) min_x = j;
			}
		}

		for(int i = max_y; i >= min_y; i--) {
			for(int j = min_x; j <= max_x; j++) {
				//이동한 방향이 아니면 #으로 처리
				if(map[i][j] == '\0') {
					System.out.print('#');
					continue;
				}
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int len = Integer.parseInt(br.readLine().trim());
		String movement = br.readLine().trim();

		//중심이 50,50인 표 
		char[][] map = new char[101][101];
		sx = 50;
		sy = 50;
		cur_x = sx;
		cur_y = sy;
		map[cur_y][cur_x] = '.'; 
		int d = 0;
		
		//방향 전환
		for(int i = 0; i < len; i++) {
			char order = movement.charAt(i);
			
			switch(order) {
				case 'R':
					//d = 0 -> 1
					//d = 1 -> 2
					//d = 2 -> 3
					//d = 3 -> 0
					d = (d+1) % 4;
					break;
				case 'L':
					//d = 0 -> 3
					//d = 1 -> 0
					//d = 2 -> 1
					//d = 3 -> 2
					d = (d+3) % 4;
					break;
				case 'F': //방향으로 한칸 이동
					cur_x = cur_x + dx[d];
					cur_y = cur_y + dy[d];
					
					map[cur_y][cur_x] = '.';
					break;
			}
		}
		
		//맵 출력
		createMap(map);
	}

}
