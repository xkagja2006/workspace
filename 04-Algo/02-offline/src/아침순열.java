import java.util.Arrays;
import java.util.Scanner;

public class 아침순열 {
	static int N, R;
	static boolean[] visited;
	static int[] numbers, inputs;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		inputs = new int[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++)
			inputs[i] = sc.nextInt();
		
		Arrays.sort(inputs);
		perm(0);

	}

	private static void perm(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])	continue;
			visited[i] = true;
			numbers[cnt] = inputs[i];
			perm(cnt+1);
			visited[i] = false;
		}
	}
}