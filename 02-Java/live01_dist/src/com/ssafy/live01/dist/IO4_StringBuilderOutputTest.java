package com.ssafy.live01.dist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * 
 * @author THKim
 *
 */
public class IO4_StringBuilderOutputTest {

	static String path = ".\\src\\com\\ssafy\\live01\\dist\\input.txt";
	public static void main(String[] args) throws IOException {
		
		int TC = 10;
		
		FileWriter out = new FileWriter(path);
		StringBuilder sb = new StringBuilder();
		long start = System.nanoTime();
		sb.append(TC+"\n");
		
		Random r = new Random();
		for (int tc = 0; tc < TC; tc++) {
			int N = 10;
			sb.append(N+"\n");

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(r.nextInt(10)+" ");
				}
				sb.append("\n");
			}
		}
		out.write(sb.toString());
		out.flush();
		long end = System.nanoTime();
		System.out.println((end-start)/1_000_000_000.0+"s!");
		out.close();
	}
 
}
