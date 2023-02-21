package com.ssafy.offline12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sw_1873_상호의배틀필드 {
	static String[][] map;
	static int H, W, C;
	static String[] cmd;
	static int r, c;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input1873.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			H = sc.nextInt();
			W = sc.nextInt();
			map = new String[H][W];

			for (int i = 0; i < H; i++)
				map[i] = sc.next().split("");

			int C = sc.nextInt();
			cmd = new String[C];
			cmd = sc.next().split("");

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j].equals("<") || map[i][j].equals(">") || map[i][j].equals("^")
							|| map[i][j].equals("v")) {
						c = i;
						r = j;
					}
				}
			}

			for (int i = 0; i < C; i++) {
				if (cmd[i].equals("U")) {
					up();
				} else if (cmd[i].equals("D")) {
					down();
				} else if (cmd[i].equals("L")) {
					left();
				} else if (cmd[i].equals("R")) {
					right();
				} else if (cmd[i].equals("S")) {
					shoot();
				}
			}
			System.out.print("#" + t + " ");
			for (String[] str : map) {
				for (String s : str)
					System.out.print(s + "");
				System.out.println();
			}
		}
	}

	private static void shoot() {
		if (map[c][r].equals(">")) {
			if (r + 1 < W) {
				int i = 0;
				while (true) {
					int rr = r + 1 + i++;
					if (rr == W)
						break;
					if (map[c][rr].equals("*")) {
						map[c][rr] = ".";
						break;
					}
					if (map[c][rr].equals("#"))
						break;
				}
			}
			return;
		}
		if (map[c][r].equals("<")) {
			if (r - 1 >= 0) {
				int i = 0;
				while (true) {
					int rr = r - 1 - i++;
					if (rr == -1)
						break;
					if (map[c][rr].equals("*")) {
						map[c][rr] = ".";
						break;
					} else if (map[c][rr].equals("#"))
						break;
					else
						continue;
				}
			}
			return;
		}
		if (map[c][r].equals("^")) {
			if (c - 1 >= 0) {
				int i = 0;
				while (true) {
					int cc = c - 1 - i++;
					if (cc == -1)
						break;
					if (map[cc][r].equals("*")) {
						map[cc][r] = ".";
						break;
					} else if (map[cc][r].equals("#"))
						break;
					else
						continue;
				}
			}
			return;
		}
		if (map[c][r].equals("v")) {
			if (c + 1 < H) {
				int i = 0;
				while (true) {
					int cc = c + ++i;
					if (cc == H)
						break;
					if (map[cc][r].equals("*")) {
						map[cc][r] = ".";
						break;
					} else if (map[cc][r].equals("#"))
						break;
					else
						continue;
				}
			}
			return;
		}
	}

	private static void right() {
		map[c][r] = ">";
		int newR = r + 1;
		if (newR < W && map[c][newR].equals(".")) {
			map[c][r] = ".";
			map[c][newR] = ">";
			r = newR;
		}
	}

	private static void left() {
		map[c][r] = "<";
		int newR = r - 1;
		if (newR >= 0 && map[c][newR].equals(".")) {
			map[c][r] = ".";
			map[c][newR] = "<";
			r = newR;
		}
	}

	private static void down() {
		map[c][r] = "v";
		int newC = c + 1;
		if (newC < H && map[newC][r].equals(".")) {
			map[c][r] = ".";
			map[newC][r] = "v";
			c = newC;
		}
	}

	private static void up() {
		map[c][r] = "^";
		int newC = c - 1;
		if (newC >= 0 && map[newC][r].equals(".")) {
			map[c][r] = ".";
			map[newC][r] = "^";
			c = newC;
		}
	}
}
