package 역량평가준비.d0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기2 {
	static List<int[]> list;
	static int[][] map;
	static String ans;
	static int N, M, endX, endY;
	static Queue<int[]> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans = "sad";
			list = new ArrayList<>();
			q = new ArrayDeque<int[]>();
			int Store = Integer.parseInt(br.readLine());
			StringTokenizer st;
			int minX = 32768;
			int maxX = -32768;
			int minY = 32768;
			int maxY = -32768;
			for (int i = 0; i < Store + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				maxX = Math.max(maxX, x);
				maxY = Math.max(maxY, y);
				minX = Math.min(minX, x);
				minY = Math.min(minY, y);
				int[] arr = new int[] { x, y };
				list.add(arr);
			}
//			System.out.println((maxX - minX) + " " + (maxY - minY));
//			System.out.println("min : " + minX + " " + minY);
			for (int i = 0; i < list.size(); i++) {
				list.get(i)[0] -= minX;
				list.get(i)[1] -= minY;
			}

//			for(int[] a : list) {
//				System.out.println(Arrays.toString(a));
//			}
			N = maxX - minX + 1;
			M = maxY - minY + 1;
			map = new int[N][M];

			for (int i = 0; i < list.size(); i++) {
				// 집
				if (i == 0)
					map[list.get(i)[0]][list.get(i)[1]] = 1;
				// 락페
				else if (i == list.size() - 1) {
					map[list.get(i)[0]][list.get(i)[1]] = 5;
					endX = list.get(i)[0];
					endY = list.get(i)[1];
				}
				// 편의점
				else
					map[list.get(i)[0]][list.get(i)[1]] = 3;
			}

//			System.out.println(Arrays.deepToString(map));

			// 1000미터를 갈 수 있음
			// 집에서 가까운 편의점까지 거리 구하기 -> 1000 이내면 또 그다음으로 가까운 편의점 구하기... 락페까지
			
			System.out.println(ans);
		}
	}

}
