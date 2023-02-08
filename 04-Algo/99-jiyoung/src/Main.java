
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
	static StringBuffer sb = new StringBuffer();
	public static void main(String args[]) throws Exception {

//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
<<<<<<< HEAD
		for (int i = 1; i <= 10; i++) {
			int cnt = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[100];
			for (int j = 0; j < 100; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			sb.append("#" + i + " ");
			flatten(arr, 0, cnt);
		}
	}

	private static void flatten(int[] arr, int n, int cnt) {
		Arrays.sort(arr);
		if((n == cnt) || (arr[99] - arr[0] <= 1)){
			sb.append(arr[99] - arr[0]);
			return;
		}
		arr[99]--;
		arr[0]++;
		
		flatten(arr, n+1, cnt);
=======
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int people = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < people; i++) {
			list.add(i + 1);
		}
		int idx = -1;
		String result = "<";
		while (!list.isEmpty()) {
			idx += num;
			idx = idx%list.size();
			result += list.get(idx) + ", ";
//			System.out.println(result);
			list.remove(idx);
			idx--;
		}
		result = result.substring(0, result.length() - 2);
		System.out.println(result + ">");
>>>>>>> 59236a801adc822cf7b3e9d629563f9561d93e46
	}
}