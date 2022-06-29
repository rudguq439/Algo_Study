import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	public static int n, m, map[][], dist[];
	public static final int INF = 0xfffffff;
	
	public static void main(String[] args) throws Exception {
		int i, j, start, dir, price;
		int objstart, objdir;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dist = new int[n];
		
		for(i=0;i<n;i++) {
			dist[i] = INF;
			for(j=0;j<n;j++)
				map[i][j] = INF;
		}
		String line[];
		for(i=0;i<m;i++) {
			line = br.readLine().split(" ");
			start = Integer.parseInt(line[0])-1;
			dir = Integer.parseInt(line[1])-1;
			price = Integer.parseInt(line[2]);
			if(map[start][dir]>price)
				map[start][dir] = price;
		}
		line = br.readLine().split(" ");
		objstart = Integer.parseInt(line[0])-1;
		objdir = Integer.parseInt(line[1])-1;
		
		dijk(objstart);
		bw.write(String.valueOf(dist[objdir]));
		br.close();
		bw.close();
	}
	public static void dijk(int start) {
		int i, j;
		
		PriorityQueue<Integer> pri = new PriorityQueue<>();
		pri.offer(start);
		map[start][start] = 0;
		dist[start] = 0;
		
		while(!pri.isEmpty()) {
			j = pri.poll();
			for(i=0;i<n;i++) {
				if(dist[i]>map[j][i]+dist[j]) {
					dist[i]=map[j][i]+dist[j];
					pri.offer(i);
				}
			}
		}
	}
}
