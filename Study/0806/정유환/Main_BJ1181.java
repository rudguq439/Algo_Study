package week8_0801;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_BJ1181 {
	
	private static class Word implements Comparable<Word>{
		String s;
		int len;
		
		public Word(String s, int len) {
			this.s = s;
			this.len = len;
		}
		
		@Override
		public int compareTo(Word o) {
			if(this.len == o.len) return this.s.compareTo(o.s);
			else return this.len > o.len ? 1 : -1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Word> list = new ArrayList<>();
		List<String> words = new ArrayList<>();
		
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			int len = s.length();
			Word w = new Word(s,len);
			
			if(!words.contains(s)) {
				list.add(w);
				words.add(s);
			}
		}
		Collections.sort(list);
		
		for(Word w : list) {
			System.out.println(w.s);
		}
	}

}
