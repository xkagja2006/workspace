package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String str = br.readLine();
		long a = 0;
		final long M = 1234567891;

		for (int i = 0; i < T; i++) {
			long n = (long) ((str.charAt(i) - 96) * Math.pow(31, i));
			a += n % M;
		}
		System.out.println(a % M);
	}
}
