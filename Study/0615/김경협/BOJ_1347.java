import java.util.*;
import java.io.*;

public class BOJ_1347 {
	static boolean[][] map;
	static int colMax, colMin, rowMax, rowMin, dir;
	static int[] currLoc;
	static int[] dr = {1,0,-1,0};	//하우상좌
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int len = Integer.parseInt(br.readLine());
		char[] commands = br.readLine().toCharArray();
		
		currLoc = new int[2]; // 현재 위치 저장
		colMax = colMin = rowMax = rowMin = currLoc[0] = currLoc[1] = 50;
		
		map = new boolean[101][101];
		map[50][50] = true;
		
		for(int i = 0; i < len; i++) {
			if(commands[i] == 'L') {
				dir = (dir + 1) % 4;
			} else if(commands[i] == 'R') {
				dir--;
				if(dir < 0) dir = 3;
			} else if(commands[i] == 'F') {
				currLoc[0] += dr[dir];
				currLoc[1] += dc[dir];
				map[currLoc[0]][currLoc[1]] = true;
				
				rowMin = Math.min(rowMin, currLoc[0]);
				rowMax = Math.max(rowMax, currLoc[0]);
				colMin = Math.min(colMin, currLoc[1]);
				colMax = Math.max(colMax, currLoc[1]);
			}
		}
		
		int rowSize = rowMax - rowMin + 1;
		int colSize = colMax - colMin + 1;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < rowSize; i++) {
			for(int j = 0; j < colSize; j++) {
				sb.append(map[rowMin + i][colMin + j] ? '.' : '#');
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
