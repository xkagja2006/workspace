package com.ssafy.offline14;
import java.util.Scanner;

public class Algo1_대전_06반_이지영 {
	static boolean[][] map = new boolean[100][100]; // 천을 만듦. false로 초기화.
	static int C, R, ans; // C, R : 스카프의 가로세로 길이. ans : 최종 답(둘레)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Scanner로 입력받음
		int T = sc.nextInt(); // 스카프의 개수 입력
		for (int t = 0; t < T; t++) { // 스카프의 개수만큼 반복
			// 스카프의 크기 구하기
			C = sc.nextInt(); // 스카프의 한 변의 길이
			R = sc.nextInt(); // 스카프의 다른 한 변의 길이
			for (int i = C; i < C + 10; i++) { // 스카프는 길이가 10인 정사각형이다.
				for (int j = R; j < R + 10; j++) { // 가로세로 각각 10만큼 반복한다.
					if (map[i][j]) // 스카프를 이미 올린 천의 위치라면
						continue; // 바로 넘어간다.
					map[i][j] = true; // 스카프를 올리지 않은 위치라면 올렸다는 표시를 한다.
				}
			}
		}
		/*
		 * 천에 스카프를 잘 올렸는지 확인 for (int i = 0; i < 100; i++) { for (int j = 0; j < 100;
		 * j++) { if (!map[i][j]) System.out.print("." + " "); else System.out.print("O"
		 * + " "); } System.out.println(); }
		 */

		// 천의 모든 영역마다 스카프의 가장자리인지 확인한다.
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				// 천의 좌표값을 매개변수로 갖는 함수를 호출한다.
				isEdge(i, j);
			}
		}
		System.out.println(ans); // 최종 답을 출력한다.
	}

	static int[] dx = { -1, 1, 0, 0 }; // 사방탐색을 위한 좌표를 행 열 각각 설정한다.
	static int[] dy = { 0, 0, -1, 1 };

	private static void isEdge(int x, int y) {
		if (map[x][y]) { // 현재 좌표가 스카프에 덮였으면(true이면) 둘레를 측정한다.
			for (int i = 0; i < 4; i++) { // 사방탐색을 시작한다.
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 매개변수로 받은 위치가 스카프인지 확인한다.
				if (map[x][y] = true) {
					if (nx == 100 || ny == 100 || nx == -1 || ny == -1) { // 스카프가 천의 가장자리에 딱맞는 경우를 처리해준다.
						ans++;
					} 
					// 검은색 스카프가 흰색 천 밖으로 나가는 경우는 없으므로 탐색하는 위치가 천인지 아닌지만 확인하면 된다.
					else if (!map[nx][ny]) 	// 탐색하는 위치가 천인지 확인한다.
						ans++;	// 천이 맞다면 가장자리가 맞다는 뜻. 최종 답에 1울 더한다.
				}
			}
		}
	}
}
