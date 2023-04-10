package 역량평가준비.d0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * 1. 해당 이닝의 순서 순열로 구해서 셋에 넣기(값 중복 방지 위해)
 * 2. 3번 out될때까지 돌림.
 * 3. 야구장 배열에 사람들을 넣는다.
 * 4. 3번 아웃되면 1번부터 반복.
 */
public class BOJ_17281_야구 {
	static int[] select;
	static int[] input;
	static boolean[] visited;
	static Set<String> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] answer = new int[T];
		int[] person = new int[T]; // 특정 이닝에서 마지막으로 친 사람
		int result = 0;
		person[0] = -1;
		// 모든 이닝에서 같은 순서로 해야하기때문에 순열을 여기에서 돌려야한다.
		
		for (int t = 0; t < T; t++) {
			input = new int[9];
			select = new int[9];
			visited = new boolean[9];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			set = new HashSet<>();

			// 1. 순열로 주자의 순서를 구함.
			perm(0);

//			for (String a : set) {
//				System.out.println(a);
//			}

			// 모든 경우의 수를 다 해봐야 함
			Iterator<String> iter = set.iterator();
			int iningScore = 0; // 이번 이닝의 최고점수
			int num = -1; // 이번 이닝에서 마지막으로 친 사람의 번호

			System.out.println("이번 이닝 시작 번호 : " + ((person[t] + 1) % 9));

			while (iter.hasNext()) {
				String o = iter.next();
				int[] order = new int[9];
				for (int i = 0; i < 9; i++) {
					order[i] = o.charAt(i) - '0';
				}
				int idx = (person[t] + 1) % 9; // 시작 인덱스는 이전에 마지막으로 친 사람 다음 사람
				int score = 0;
				int out = 0;
				int[] field = new int[4];

				System.out.println(Arrays.toString(order));
				// 아웃될때까지 게임 실시
				while (true) {
					// 아웃당했을때 최고점수 갱신하면 num에 방금 친 idx넣기
					if (out == 3) {
						System.out.println("----------아웃");
						if (score >= iningScore) {
							iningScore = score;
							num = ((idx - 1) % 9);
						}
						Arrays.fill(field, 0);
						break;
					}
					System.out.println("현재 치는 사람 : " + (idx % 9));
					int hit = order[idx % 9];
					if (hit == 0) {
						out++;
						System.out.println("아웃");
					} else if (hit == 4) {
//						System.out.println("홈런 : " + hit);
						score++;
						for (int i = 3; i >= 0; i--) {
							if (field[i] == 1) {
								score++;
								field[i] = 0;
							}
						}
					} else {
//						System.out.println("이동 : " + hit);
						// i번째에 사람이 있으면 i + hit만큼 이동함
						// i + hit만큼 이동한게 4 이상이면 점수 +1하고 i번째 원소 0으로 초기화
						for (int i = 3; i >= 0; i--) {
							if (field[i] == 1) {
								if (i + hit >= 4) {
									score++;
								} else {
									field[i + hit] = 1;
								}
								field[i] = 0;
							}
						}
						field[hit - 1] = 1;
					}
					idx++;
				}
			}
			answer[t] = iningScore;
			if (t + 1 < T)
				person[t + 1] = num;
			System.out.println("최고점수 : " + answer[t] + "마지막으로 친 사람 : " + num);
			result += answer[t];
		}
		System.out.println(result);
	}

	private static void perm(int cnt) {
		if (cnt == 9) {
			String a = "";
			for (int x : select) {
				a += x;
			}
			set.add(a);
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (!visited[i]) {
				if (cnt == 3) {
					visited[0] = true;
					select[cnt] = input[0];
					perm(cnt + 1);
					visited[0] = false;

				} else {
					visited[i] = true;
					select[cnt] = input[i];
					perm(cnt + 1);
					visited[i] = false;
				}
			}
		}
	}
}
