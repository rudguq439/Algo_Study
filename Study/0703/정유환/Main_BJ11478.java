package week3_0627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_BJ11478 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		HashSet<String> set = new HashSet<>();
		
		String name = "";
		
		for(int i = 0; i < S.length(); i++) {
			name = "";
			for(int j = i; j < S.length(); j++) {
				name += S.substring(j,j+1);
				set.add(name);
			}
		}
		/*
		ababc
		a ab aba abab ababc
		b ba bab babc
		~a~ ~ab~ abc
		~b~ bc
		c
		*/
		
		System.out.println(set.size());
	}

}
