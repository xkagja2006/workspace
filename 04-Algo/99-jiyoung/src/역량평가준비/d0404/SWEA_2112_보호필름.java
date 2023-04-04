package 역량평가준비.d0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {
	static int N, M, K, R, ans;
	static int[] medicine, number;
	static int[] input;
	static int[][] map;
	static List<int[]> list;
	static List<int[]> ablist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			input = new int[N];
			for (int i = 0; i < N; i++) {
				input[i] = i;
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			R = 0;
			ans = 0;
			if (!test(map) || K != 1) {
				outer: while (true) {
					R++;
					if (R > K)
						break;

					medicine = new int[R];
					list = new ArrayList<int[]>();
					ablist = new ArrayList<int[]>();
					combi(0, 0);
					bitmask();

					for (int i = 0; i < list.size(); i++) {
						// list : 약의 위치를 넣은 리스트
						medicine = list.get(i);

						// 어떤 종류 약품을 넣을지 정함
						for (int c = 0; c < ablist.size(); c++) {
							for (int r = 0; r < R; r++) {
								// ablist : medicine배열과 1대1매핑으로 어떤 약품을 쓸지 알려줌
								// addMedi : medicine 위치에 ablist 약품을 사용한다.
								// 사용한 결과를 반환한다.
								// test : 맵을 받아서 시험에 통과할 수 있는지 확인.
								boolean result = test(addMedi(medicine, ablist.get(c)));
								if (result == true) {
									ans = R;
									break outer;
								}
							}
						}
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	private static boolean test(int[][] arr) {
		for (int m = 0; m < M; m++) {
			int cnt = 1;
			int max = 0;
			for (int n = 1; n < N; n++) {
				if (arr[n][m] == arr[n - 1][m]) {
					cnt++;
					max = Math.max(max, cnt);
					if(max >= K) continue;
				} else {
					cnt = 1;
				}
			}
			if (max < K)
				return false;
		}
		return true;
	}

	private static int[][] addMedi(int[] medi, int[] ab) {
		int[][] newmap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newmap[i][j] = map[i][j];
			}
		}
		// medi의 n번째 원소에 해당하는 행의 열값들을 ab의 n번째 원소로 만든다.
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < M; j++) {
				newmap[medi[i]][j] = ab[i];
			}
		}
		return newmap;
	}

	private static void combi(int cnt, int start) {
		if (cnt == R) {
			number = new int[R];
			number = medicine.clone();
			list.add(number);
			return;
		}
		for (int i = start; i < N; i++) {
			medicine[cnt] = input[i];
			combi(cnt + 1, i + 1);
		}
	}

	private static void bitmask() {
		for (int i = 0; i < (1 << R); i++) {
			String c = String.format("%0" + R + "d", Integer.parseInt(Integer.toBinaryString(i)));
			char[] arr = c.toCharArray();
			int[] arr2 = new int[R];
			for (int j = 0; j < R; j++) {
				arr2[j] = arr[j] - '0';
			}
			ablist.add(arr2);
		}
	}
}
