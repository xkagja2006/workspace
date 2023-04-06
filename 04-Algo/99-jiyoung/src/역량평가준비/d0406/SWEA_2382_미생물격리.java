package 역량평가준비.d0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2382_미생물격리 {
	static int M, K, N, No;
	static List<int[]> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			list = new ArrayList<int[]>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int[] micro = new int[5];
				micro[0] = Integer.parseInt(st.nextToken()); // 세로위치
				micro[1] = Integer.parseInt(st.nextToken()); // 가로위치
				micro[2] = Integer.parseInt(st.nextToken()); // 미생물 수
				micro[3] = Integer.parseInt(st.nextToken()); // 이동방향
				micro[4] = No++; // 키값
				list.add(micro);
			}
			for (int time = 0; time < M; time++) {
				// 1. 모든 미생물 좌표 재설정하기
				for (int i = 0; i < list.size(); i++) {
					int direct = list.get(i)[3];
					if (direct == 1) { // 상
						list.get(i)[0]--;
					} else if (direct == 2) { // 하
						list.get(i)[0]++;
					} else if (direct == 3) { // 좌
						list.get(i)[1]--;
					} else { // 우
						list.get(i)[1]++;
					}
				}
				// 2. 같은 좌표를 가지는 군집 있는지 확인
				for (int i = 0; i < list.size(); i++) {
					int x = list.get(i)[0];
					int y = list.get(i)[1];
					List<int[]> same = new ArrayList<>();
					same.add(list.get(i));
					for (int j = 0; j < list.size(); j++) {
						if (list.get(i)[4] != list.get(j)[4] && list.get(j)[0] == x && list.get(j)[1] == y) {
							// 같은 좌표를 넣는 리스트에 좌표, 미생물 수, 미생물리스트에서의 인덱스를 넣는다.
							same.add(list.get(j));
						}
					}
					// 동일한 좌표가 2개이상 있으면
					if (same.size() > 1) {
						int max = 0;
						int sum = 0;
						int index = -1;
						for (int j = 0; j < same.size(); j++) {
							sum += same.get(j)[2];
							if (max < same.get(j)[2]) {
								max = same.get(j)[2];
								index = same.get(j)[4];
							}
						}

						for (int j = 0; j < list.size(); j++) {
							if (list.get(j)[4] == index) {
								list.get(j)[2] = sum;
							}
						}
						
						// index가 아닌것 삭제하기
						for (int j = list.size()-1; j >= 0; j--) {
							for (int k = 0; k < same.size(); k++) {
								if (list.get(j)[4] != index && same.get(k)[4] == list.get(j)[4]) {
									list.remove(j);
								}
							}

						}
					}
				}

				// 3. 가장자리에 닿은 군집 있는지 확인
				for (int i = 0; i < list.size(); i++) {
					int x = list.get(i)[0];
					int y = list.get(i)[1];
					if (x == 0 || y == 0 || x == N - 1 || y == N - 1) {
						// 3-1. 방향 전환
						if (list.get(i)[3] == 1 || list.get(i)[3] == 3)
							list.get(i)[3] += 1;
						else
							list.get(i)[3] -= 1;
						// 3-2. 미생물 반 나누기
						list.get(i)[2] = list.get(i)[2] / 2;
					}
				}
				
			}
			// 4. 각 합 구하기
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i)[2];
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}
