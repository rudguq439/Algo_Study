package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ11478서로다른부분문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		char[] ch = st.toCharArray();
		HashSet<String> hs = new HashSet<String>();
		
		String tmp = "";
		for(int i=0; i<st.length(); i++) {
			tmp = "";
			for(int j=i; j<st.length(); j++) {
				tmp += ch[j];
				hs.add(tmp);
			}
		}
		System.out.println(hs.size());
	}

}
