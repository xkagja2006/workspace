import java.util.Arrays;
import java.util.Scanner;

public class 연습 {
	static int N, R;
	static int[] numbers, inputs;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		inputs = new int[N];

		for (int i = 0; i < N; i++)
			inputs[i] = sc.nextInt();

		perm(0);
		combi(0, 0);

	}

	private static void combi(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			combi(cnt + 1, i + 1);
		}
	}

	private static void perm(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			numbers[cnt] = inputs[i];
			perm(cnt + 1);
			visited[i] = false;
		}

	}
}
