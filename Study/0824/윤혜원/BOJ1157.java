import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] alpha = new int[26];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c >= 65 && c <= 90) {
				alpha[c-65]++;
			}else {
				alpha[c-97]++;
			}
		}
		int max = -1;
		char ch = ' ';
		
		for(int i=0; i<alpha.length; i++) {
			if(alpha[i] > max) {
				max = alpha[i];
				ch = (char)(i+65);
			}else if(alpha[i] == max) {
				ch = '?';
			}
		}
		System.out.println(ch);
	}

}
