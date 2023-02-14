package com.ssafy.offline07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<int[]> towers = new Stack<>();
		for (int i = 0; i < cnt; i++) {
			int in = Integer.parseInt(st.nextToken());
			int[] temp = new int[] { i, in };
			
			if (towers.isEmpty()) {
				towers.push(temp);
				sb.append(0 + " ");
			} else {
				System.out.println(temp[1] + " " + towers.peek()[1]);
				while (true) {
					int[] next = towers.peek();
					if (next[1] >= temp[1]) {
						System.out.println("뒤에가 더 낮음" + next[0] );
						sb.append(next[0]+1 + " ");
						towers.push(temp);
						break;
					} else {
						System.out.println("더 높음");
						towers.pop();
					}
					if(towers.isEmpty()) { 
						sb.append(next[0] + " ");
						towers.push(temp);
						break;
					}
				}
			}
		}

		bw.write(sb.toString());
		bw.close();
	}
}
