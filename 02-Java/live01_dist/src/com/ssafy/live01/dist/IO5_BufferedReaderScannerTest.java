package com.ssafy.live01.dist;

import java.io.*;
import java.util.*;

/**
 * 
 * @author THKim
 *
 */
public class IO5_BufferedReaderScannerTest {

	static String path = ".\\src\\com\\ssafy\\live01\\dist\\input.txt";
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream(path));
//		Scanner sc = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		

		long start = System.nanoTime();
//		int TC = sc.nextInt();
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
//			int N = sc.nextInt();
			int N = Integer.parseInt(in.readLine());
			int sum = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
//					sum += sc.nextInt();
					sum += Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
		long end = System.nanoTime();
		System.out.println((end - start) / 1_000_000_000.0 + "s");
	} 

	
}
