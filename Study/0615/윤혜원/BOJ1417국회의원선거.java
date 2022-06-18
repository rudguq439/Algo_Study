package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1417국회의원선거 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //후보 수 
		int da = Integer.parseInt(br.readLine()); //1번 찍는 사람 수 
		int[] arr = new int[n-1]; //각 후보 투표 수
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int min = 0; //매수해야될 사람
		if(n==1) { //후보가 혼자일때
			System.out.println("0");
			return;
		}
		while(true) {
			Arrays.sort(arr);
			boolean flag = true;
			int many = arr.length-1; //가장 투표가 많은 후보
			
			if(da <= arr[arr.length-1]) { //제일 투표수가 많은 후보자부터 매수함 
				da++;
				arr[many]--;
				min++;
				flag = false;
			}
			if(flag) {
				break;
			}
			System.out.println(min);
			br.close();
		}
	}

}
