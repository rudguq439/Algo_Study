package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ4358생태학 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		int count = 0;
		HashMap<String, Integer> hs = new HashMap<String, Integer>();
		while(true) {
			hs.put(st, hs.getOrDefault(st, 0)+1);
			count++;
			
			st = br.readLine();
			if(st == null || st.length() == 0) {
				break;
			}
		}
		Object[] keyarr = hs.keySet().toArray();
		Arrays.sort(keyarr);
		for(int i=0; i<keyarr.length; i++) {
			int value = hs.get(keyarr[i]);
			double per = ((double)value / (double)count)*100;
			System.out.printf("%s %.4f \n", keyarr[i], per);
		}
	}

}
