package com.ssafy.live03;

import java.util.Arrays;
import java.util.Scanner;

//입력으로 주사위던지기 모드를 받는다.(1,2,3,4)
//던지는 주사위 수도 입력받는다. (1 <= N <= 10)
public class Ex_DiceTest {

	static int N; // 던지는 주사위 수
	static int[] numbers; // 각각의 주사위의 눈
	static int totalCnt;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mode = sc.nextInt();
		N = sc.nextInt();

		numbers = new int[N];

		switch (mode) {
		case 1: // 중복순열
			dice1(0);
			break;
		case 2: // 순열
			isSelected = new boolean[7];
			dice2(0);
			break;
		case 3:	//중복조합
			dice3(0,1);
			break;
		case 4:	//조합
			dice4(0,1);
			break;
		}
		System.out.println("총 경우의 수 : " + totalCnt);
	}

	private static void dice1(int cnt) { // cnt : 기존까지 던져진 주사위 수 ==> 현재 주사위의 수를 기록하기 위한 인덱스로 사용

		if (cnt == N) { // 던져진 주사위가 목표수가 되었다면 더이상 던질 주사위 없음
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}

		// 주사위의 눈은 1-6의 경우가 있음
		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			// 다음 주사위던지러 가기
			dice1(cnt + 1);
		}
	}

	private static void dice2(int cnt) { // cnt : 기존까지 던져진 주사위 수 ==> 현재 주사위의 수를 기록하기 위한 인덱스로 사용

		if (cnt == N) { // 던져진 주사위가 목표수가 되었다면 더이상 던질 주사위 없음
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}

		// 주사위의 눈은 1-6의 경우가 있음
		for (int i = 1; i <= 6; i++) {
			// 중복체크
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			numbers[cnt] = i;
			// 다음 주사위던지러 가기
			dice2(cnt + 1);
			isSelected[i] = false;
		}
	}

	private static void dice3(int cnt, int start) { // cnt : 기존까지 던져진 주사위 수, start : 현 주사위의 눈의 시작
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt + 1, i);
		}
	}
	
	private static void dice4(int cnt, int start) { // cnt : 기존까지 던져진 주사위 수, start : 현 주사위의 눈의 시작
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}

		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt + 1, i + 1);
		}
	}
}
