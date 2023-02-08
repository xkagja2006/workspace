package com.ssafy.offline03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2798_블랙잭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int c = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int[] cards = new int[c];
		for(int i = 0; i < c; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		
		for(int i = 0; i < c-2; i++) {
			for(int j = i+1; j < c-1; j++) {
				for(int k = j+1; k < c; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					if(sum > goal) continue;
					if(sum >= max) max = sum;
				}
			}
		}
		System.out.println(max);
	}
}
