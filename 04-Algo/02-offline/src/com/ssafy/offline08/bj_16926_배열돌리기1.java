package com.ssafy.offline08;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

public class bj_16926_배열돌리기1 {
	static int R, C, rotateCnt;
	static int[][] map;
	static Scanner sc = new Scanner("4 4 2\r\n" +
			"1 2 3 4 \r\n" +
			"5 6 7 8  \r\n" +
			"9 10 11 12 \r\n" +
			"13 14 15 16");
	
	public static void main(String[] args) {
		
		R = sc.nextInt();
		C = sc.nextInt();
		rotateCnt = sc.nextInt();
		
		inputMap();
		
		for(int cnt = 1; cnt <= rotateCnt; cnt++) rotateMap();

		printMap();

	}
	
	private static void inputMap() {
		map = new int[R][C];
		for(int r = 0; r < R; r++) for(int c = 0; c < C; c++) map[r][c] = sc.nextInt();
	}
	
	private static void printMap() {
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		
	}
	
	//방향
	
	private static void rotateMap() {
		
		int[] dx = { 0, 1, 0 , -1};
		int[] dy = { 1, 0, -1, 0};
		
		//몇번을 돌릴지 찾기위해서! (내가한코드에도 있다! 이건 왤케 짧지..?)
		int loopCnt = Math.min(R, C) / 2;
		
		for(int cnt = 0; cnt < loopCnt; ++cnt) {
			
			int tmp = map[cnt][cnt];
			
			//처음값
			int x = cnt;
			int y = cnt;
			
			//4방향으로 방향을 돌림 
			for(int d = 0; d < 4; d++) {
				//얼만큼 돌릴지 모르니깐 무한루프!
				while(true) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < cnt || ny < cnt || nx >= R - cnt || ny >= C - cnt) break; 
					
					//값을 변경하기위해
					map[x][y] = map[nx][ny];
					
				
					x = nx; //좌표값이 계속 이동하게됨!
					y = ny;
				}
				
			}
			// 로직이 끝난다음 
			map[cnt + 1][cnt] = tmp;
		}
		
		
	}
	
}
