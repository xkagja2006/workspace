import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toString();
		int idx = 0;
		int[] n = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		String[] s = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" };
		if (str.equals("1")) {
			for (int i = 1; i <= 4; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.printf(n[idx++] + " ");
				}
				System.out.println("");
			}
		}
		if (str.equals("a")) {
			for (int i = 1; i <= 5; i++) {
				for (int j = 0; j < 5-i; j++) {
					System.out.printf(" " + " ");
				}
				for (int j = 5-i+1; j <= 5; j++) {
					System.out.printf(s[idx++] + " ");
				}
				System.out.println("");
			}
		}
	}
}
