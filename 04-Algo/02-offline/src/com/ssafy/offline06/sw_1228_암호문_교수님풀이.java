package com.ssafy.offline06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class sw_1228_암호문_교수님풀이 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input1228.txt"));
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextLine();
			List<String> l = new LinkedList<>(Arrays.asList(sc.nextLine().split(" "))); // 한번에 입력받기!!
			sc.nextLine(); // 명령어의 길이 값. 버리기
			String[] cmd = sc.nextLine().split(" ");
			for (int k = 0; k < cmd.length;) {
				int loc = Integer.parseInt(cmd[++k]); // 삽입 위치
				int cnt = Integer.parseInt(cmd[++k]); // 삽입 암호 갯수
				for (int j = cnt; j > 0; j--) {
					l.add(loc, cmd[k + j]);
				}
				k += cnt + 1;
			}
			System.out.println("#" + t);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + l.get(i));
			}
			System.out.println();
		}

	}
}
