import java.util.Scanner;

public class 모닝순조부 {
	static int N, R;
	static int[] numbers, inputs;
	static boolean[] selected; // 부분집합에서는 비트연산자를 통해 판별하니까 필요없다.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		inputs = new int[N];
		selected = new boolean[N];

		for (int i = 0; i < N; i++)
			inputs[i] = sc.nextInt();

		System.out.println("순열");
		perm(0);
		System.out.println("조합");
		combi(0, 0);
		System.out.println("부분집합 - 재귀");
		subset(0);
		System.out.println("부분집합 - 비트");
		subset();
	}

	private static void subset() {
		for (int i = 0; i < (1 << N); i++) {		//i는 경우의 수. j는 선택된 위치.
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) == 0) continue;
				System.out.print(inputs[j] + " ");
			}
			System.out.println();
		}
	}

	private static void subset(int cnt) { // 부분집합은 선택과 비선택.
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				if (!selected[i])
					continue;
				System.out.print(inputs[i] + " ");
			}
			System.out.println();
			return;
		}
		selected[cnt] = true;
		subset(cnt + 1);
		selected[cnt] = false;
		subset(cnt + 1);
	}

	private static void combi(int i, int j) {
		// TODO Auto-generated method stub

	}

	private static void perm(int i) {

	}
}
