package com.ssafy.offline04;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class test {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 선언
		StringBuilder sb = new StringBuilder();
		sb.append('3'-48);
		sb.append(2);
//		bw.write(sb.toString());
//		bw.close();
		System.out.println(isPrime(131));
		System.out.println(7/2);
	}

	private static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
