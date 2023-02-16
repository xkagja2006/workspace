package com.ssafy.live09;

import java.util.Arrays;
import java.util.Scanner;

// nPn만 가능하다.
public class PerutationNPTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] inputs = new int[N];
		for (int i = 1; i <= N; i++)
			inputs[i - 1] = i;

		// 전처리 : 오름차순 정렬
		Arrays.sort(inputs);

		do {
			System.out.println(Arrays.toString(inputs));

		} while (np(inputs));
	}

	private static boolean np(int[] inputs) {

		int n = inputs.length;

		// step1. 뒤쪽부터 꼭대기를 찾는다. (꼭대기 바로 앞이 교환할 자리)
		int i = n - 1;
		while (i > 0 && inputs[i - 1] >= inputs[i])
			--i;
		if (i == 0)
			return false;

		// step2. 꼭대기 바로 앞(i-1)자리에 교환할 값을 뒤쪽부터 찾는다.
		int j = n - 1;
		while (inputs[i - 1] >= inputs[j])
			--j;

		// step3. 꼭대기 바로 앞(i-1)자리와 그 자리값보다 한단계 큰 자리(j) 수와 교환
		swap(inputs, i - 1, j);

		// step4. 꼭대기부터 맨 뒤까지 오름차순으로 정렬
		int k = n - 1;
		while (i < k) {
			swap(inputs, i++, k--);
		}
		return true;
	}

	private static void swap(int[] inputs, int i, int j) {
		int temp = inputs[i];
		inputs[i] = inputs[j];
		inputs[j] = temp;
	}

}
