package 역량평가준비.d0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 계단찾기 함수 실행
 * bfs돌려서 계단에 도착하면 그때까지 걸린시간과 0(계단위의 시간) 가지고 큐에 들어감.
 * bfs안돌려도 될거같다
 * 모든 사람들이 큐에 들어가면 계단걷기 함수 실행
 * 자기에 해당하는 시간에 들어갈 수 있고, 들어가면 사람수 + 1
 * 못들어가면(사람수 == 3) 해당 사람 시간 이상의 시간인 사람 싹 다 자기시간 + 1
 *  
 */

public class SWEA_2383_점심식사시간 {
	static int N;
	static List<int[]> persons;
	static List<int[]> stairs;
	static Queue<int[]> walk;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			persons = new ArrayList<>();
			stairs = new ArrayList<>();
			walk = new ArrayDeque<int[]>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (num == 1) {
						persons.add(new int[] { i, j, Integer.MAX_VALUE, 0 , 0});
					} else if (num != 0) {
						stairs.add(new int[] { i, j });
					}
				}
			}
			// 각 사람들마다 계단에 이르는 시간 조사하기
			for (int i = 0; i < persons.size(); i++) {
				for (int j = 0; j < stairs.size(); j++) {
					int x = Math.abs(persons.get(i)[0] - stairs.get(j)[0]);
					int y = Math.abs(persons.get(i)[1] - stairs.get(j)[1]);
					persons.get(i)[2] = Math.min(persons.get(i)[2], x + y);
				}
			}

			// 계단 내려가기
			int time = 0;
			int walking = 0;
			while (true) {
				System.out.println(time + "분-------");
				for (int i = 0; i < persons.size(); i++) {
					// 계단 내려가기 시작하는 경우
					if (persons.get(i)[2] == time) {
						if (walking < 3) {
							walking++;
							persons.get(i)[4] = 1;
						}
					}
					// 계단을 내려가고 있는경우
					if (persons.get(i)[2] > time && persons.get(i)[4] == 1) {
						persons.get(i)[3] = time - persons.get(i)[3];
//						if(persons.get(i)[3] == K)
					}
				}
			}
		}
	}
}
