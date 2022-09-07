import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		
		int alen = a.length();
		int blen = b.length();
		
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<=blen-alen; i++) {
			int count = 0;
			for(int j=0; j<alen; j++) {
				char achar = a.charAt(j);
				char bchar = b.charAt(j + i);
				if(achar != bchar) 
					count++;
			}
			min = Math.min(min, count);
		}
		System.out.println(min);
	}	

}
