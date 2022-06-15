import java.util.*;
import java.io.*;

public class BOJ_1063 {
	static int[] dr = {0,0,-1,1,1,1,-1,-1};
	static int[] dc = {1,-1,0,0,1,-1,1,-1};
	static int[] kingLoc, stoneLoc;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		kingLoc = new int[2];
		stoneLoc = new int[2];
		
		String tmp = st.nextToken();
		kingLoc[0] = tmp.charAt(1) -'0' - 1;
		kingLoc[1] = tmp.charAt(0) - 'A';
		
		tmp = st.nextToken();
		stoneLoc[0] = tmp.charAt(1) -'0' - 1;
		stoneLoc[1] = tmp.charAt(0) - 'A';
		
		int commandCnt = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < commandCnt; i++) {
			String command = br.readLine();
			
			if("R".equals(command)) {
				moveKing(0);
			} else if("L".equals(command)) {
				moveKing(1);
			} else if("B".equals(command)) {
				moveKing(2);
			} else if("T".equals(command)) {
				moveKing(3);
			} else if("RT".equals(command)) {
				moveKing(4);
			} else if("LT".equals(command)) {
				moveKing(5);
			} else if("RB".equals(command)) {
				moveKing(6);
			} else if("LB".equals(command)) {
				moveKing(7);
			}
									
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append((char)(kingLoc[1] + 'A')).append(kingLoc[0] + 1).append("\n")
		.append((char)(stoneLoc[1] + 'A')).append(stoneLoc[0] + 1);
		
		System.out.println(sb);
	}
	
	static void moveKing(int command) {
		int nextKingRow = kingLoc[0] + dr[command];
		int nextKingCol = kingLoc[1] + dc[command];
		
		if(isOutOfMap(nextKingRow, nextKingCol)) {
			return;
		} else if(nextKingRow == stoneLoc[0] && nextKingCol == stoneLoc[1]) {
			// 킹이 돌 위치를 침범했을 때, 돌도 같이 이동시키기
			int nextStoneRow = stoneLoc[0] + dr[command];
			int nextStoneCol = stoneLoc[1] + dc[command];
			
			if(isOutOfMap(nextStoneRow, nextStoneCol)) {
				// 돌이 맵 밖으로 나갈 때,
				return;
			}
			
			stoneLoc[0] = nextStoneRow;
			stoneLoc[1] = nextStoneCol;
		}

		kingLoc[0] = nextKingRow;
		kingLoc[1] = nextKingCol;
	}
	
	static boolean isOutOfMap(int r, int c) {
		return r < 0 || c < 0 || r >= 8 || c >= 8;
	}
	

}
