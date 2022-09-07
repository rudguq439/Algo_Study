import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	static final String[] NUMS = {
            "####.##.##.####",
            "..#..#..#..#..#",
            "###..#####..###",
            "###..####..####",
            "#.##.####..#..#",
            "####..###..####",
            "####..####.####",
            "###..#..#..#..#",
            "####.#####.####",
            "####.####..####"   
    };
	static String[] map = new String[5];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<5; i++) {
			map[i] = br.readLine();
		}
		HashSet<Double>[] hs = new HashSet[N];
		for(int i=0; i<N; i++) {
			hs[i] = new HashSet<>();
		}
		int strLen = 4 * N -1;
		int total = 1;
		int[] digitCount = new int[N];
		Arrays.fill(digitCount, 1);
		for(int i=0; i<5; i++) {
			for(int j=0; j<strLen; j+=4) {
				int index = j/4;
				for(int k=0; k<10; k++) {
					double value = Math.pow(10, N-1-index)*k;
					if(canNum(i, j, k)) {
						if(i==0) {
							hs[index].add(value);
						}
					}else {
						hs[index].remove(value);
					}
				}
				if(hs[index].size() == 0) {
					System.out.println("-1");
					return;
				}
				if(i==4) {
					total = total * hs[index].size();
					for(int k=0; k<N; k++) {
						if(k != index) {
							digitCount[k] = digitCount[k]*hs[index].size();
						}
					}
				}
			}
		}
		double sum = 0;
		for(int i=0; i<N; i++) {
			double multi = (double) digitCount[i] / total;
			sum += hs[i].stream().mapToDouble(x -> x).map(x -> x * multi).sum();
		}
		 System.out.println(sum);
	        br.close();
	}
	static boolean canNum(int row, int index ,int compareTo){
        for(int i=0; i<3; i++){
            if(map[row].charAt(index+i)!='.' && map[row].charAt(index+i)!=NUMS[compareTo].charAt(row*3+i)) return false;
        }
        return true;
    }

}
