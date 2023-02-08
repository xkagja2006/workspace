import java.util.Arrays;
import java.util.Scanner;

public class 아침순열조합 {
	static int N, R;
	static int[] inputs, numbers;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		inputs = new int[N];
		numbers = new int[R];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++)
			inputs[i] = sc.nextInt();
		
		System.out.println("순열");
		perm(0);
		System.out.println("조합");
		combi(0, 0);
	}

	private static void combi(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			combi(cnt+1, i+1);
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