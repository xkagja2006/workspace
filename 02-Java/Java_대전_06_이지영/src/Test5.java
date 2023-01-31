import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().toString());
		String[] s = new String[n];
		String[] alph = { "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010" };
		int[] idx = new int[n];
		int x = 0;
		int answer = 0;
		for (int a = 0; a < n; a++) {
			String str = br.readLine().toString();
			// 입력받은 수를 6자리씩 끊어 배열에 저장
			for (int i = 0; i < n; i++) {
				s[i] = str.substring(6 * i, 6 * i + 6);
				if (s[i].equals(alph[0]))
					s[i] = "A";
				else if (s[i].equals(alph[1]))
					s[i] = "B";
				else if (s[i].equals(alph[2]))
					s[i] = "C";
				else if (s[i].equals(alph[3]))
					s[i] = "D";
				else if (s[i].equals(alph[4]))
					s[i] = "E";
				else if (s[i].equals(alph[5]))
					s[i] = "F";
				else if (s[i].equals(alph[6]))
					s[i] = "G";
				else if (s[i].equals(alph[7]))
					s[i] = "H";
				else {
					//일치하지 않을 때에는 각 자릿수를 비교해 다른것이 2개이상 발견될경우를 찾는다.
					for (int j = 0; j < 8; j++) {
						int not = 0;
						for(int k = 0; k < 6; k++) {
							if(s[i].charAt(k) != alph[j].charAt(k)) {
								not++;
							}
							if(not == 2) {
								break;
							}
						}
						//유사한 경우
						if(not == 1) {
							s[i] = Character.toString((char)(j+65));
							break;
						}
						//다른 경우
						if(not == 2) {
							idx[x] = i;
						}
					}
				}
			}
			System.out.println("인덱스번호 : " + idx[0]);
			System.out.println(Arrays.toString(s));

		}
	}

}