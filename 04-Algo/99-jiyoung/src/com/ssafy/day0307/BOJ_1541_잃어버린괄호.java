package com.ssafy.day0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1541

// 현재 빼는 중인지 더하는 중인지 설정하기.
// 빼기를 만나면 무조건 괄호열기. -> 빼는 중으로 바꾸기.
// 빼는 중인데 더하기를 만나면 빼기. 빼기를 만나면 더하는 중으로 바꾼다. 

public class BOJ_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ch = br.readLine().toCharArray();

		System.out.println(Arrays.toString(ch));

		int ans = 0;
		int num = 0;
		for (int i = 0; i < ch.length; i++) {
			int cur = ch[i] - '0';
			if (cur >= 0 && cur <= 9) {

			}
		}
	}
}
