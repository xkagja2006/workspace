/*
 * 선택정렬
 * 가장 작은 데이터를 찾아서 맨앞의 데이터와 체인지
 * 3 5 2 9 6
 * 
 * 1단계
 * 2 5 3 9 6
 * 
 * 2단계
 * 2 3 5 9 6
 * 
 * 3단계
 * 2 3 5 9 6
 * 
 * 4단계
 * 2 3 5 6 9
 * 
 */
package com.ssafy.day07.sort;

import static java.lang.Math.min;

import java.util.Arrays;

public class Test01_int직접정렬 {
	public static void main(String[] args) {
		int[] data = { 4, 2, 8, 6, 9 };
		System.out.println("정렬 전 : " + Arrays.toString(data));

		for (int i = 0; i < data.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < data.length; j++) {
//				if (data[minIdx] <= data[j]) continue;
				if (data[minIdx] > data[j]) minIdx = j;
			}
			if (i == minIdx) continue;		//위치 변경할 필요 없음(더 작은 수 못찾아서 minIdx가 똑같음)
			
			int temp = data[minIdx];
			data[minIdx] = data[i];
			data[i] = temp;
			System.out.printf("위치변경(%d,%d) : %s%n",i,minIdx,Arrays.toString(data));
		}
	}
}
