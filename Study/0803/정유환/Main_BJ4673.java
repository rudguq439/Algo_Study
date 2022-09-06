package week8_0801;

public class Main_BJ4673 {

	public static void main(String[] args) {
		boolean[] constructor = new boolean[10001];
		
		for(int i = 1; i < 10001; i++) {
			int t = i;
			int res = i;
			
			while(t != 0) {
				res += t%10;
				t /= 10;
			}
			if(res <= 10000) constructor[res] = true;
		}
		
		for(int i = 1; i < 10001; i++) {
			if(constructor[i]) continue;
			System.out.println(i);
		}
	}

}
