package 역량평가준비.d0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥 {
	static int N, D, K, C, ans, result;
	static int arr[], menu[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		menu = new int[D + 1];
		boolean plus = false;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < K; i++) {
			if (menu[arr[i % N]] == 0)
				ans++;
			menu[arr[i % N]]++;
		}

		// 쿠폰 사용확인
		if (plus == true && menu[C] != 0) {
			plus = false;
			ans--;
		}
		if (menu[C] == 0 && plus == false) {
			plus = true;
			ans++;
		}
		result = Math.max(result, ans);
		
		for (int n = 1; n < N; n++) {
			menu[arr[n-1]]--;
			if (menu[arr[n-1]] == 0)
				ans--;

			if (menu[arr[(n+K-1) % N]] == 0)
				ans++;
			menu[arr[(n+K-1) % N]]++;

			// 쿠폰 사용확인
			if (plus == true && menu[C] != 0) {
				plus = false;
				ans--;
			}
			if (menu[C] == 0 && plus == false) {
				plus = true;
				ans++;
			}
			result = Math.max(result, ans);
		}
		System.out.println(result);
	}
}
