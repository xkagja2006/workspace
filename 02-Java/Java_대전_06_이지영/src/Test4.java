
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) throws FileNotFoundException {
		// Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("Test4.txt"));
		// 여기에 작성하세요
		int T = in.nextInt();
		for (int a = 0; a < T; a++) {
			int student = in.nextInt();
			int score[] = new int[student];
			int sum = 0;
			double avg = 0.0;
			// 점수 배열에 값 입력
			for (int i = 0; i < student; i++) {
				score[i] = in.nextInt();
				sum += score[i];
			}
			avg = sum / (double) student;

			// 평균 미만인 경우의 수 구하기
			int fail = 0;
			for (int i = 0; i < student; i++) {
				if (score[i] < avg)
					fail++;
			}
			//비율 계산 후 출력
			float percent = fail / (float) student * 100;
			System.out.printf("#%d %.3f", a+1, percent);
			System.out.println("%");
		}

	}
}
