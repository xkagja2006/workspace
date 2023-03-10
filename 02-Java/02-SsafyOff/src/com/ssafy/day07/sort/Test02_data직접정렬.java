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

public class Test02_data직접정렬 {
	static class Data {
		int num;

		Data(int num) {
			this.num = num;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Data [num=" + num + "]";
		}
	}

	public static void main(String[] args) {
		Data d1 = new Data(4);
		Data d2 = new Data(2);
		Data d3 = new Data(8);
		Data d4 = new Data(6);
		Data d5 = new Data(9);
		Data[] data = { d1, d2, d3, d4, d5 };
		System.out.println("정렬 전 : " + Arrays.toString(data));

		for (int i = 0; i < data.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < data.length; j++) {
//				if (data[minIdx] <= data[j]) continue;
				if (data[minIdx].num > data[j].num)
					minIdx = j;
			}
			if (i == minIdx)
				continue; // 위치 변경할 필요 없음(더 작은 수 못찾아서 minIdx가 똑같음)

			Data temp = data[minIdx];
			data[minIdx] = data[i];
			data[i] = temp;
			System.out.printf("위치변경(%d,%d) : %s%n", i, minIdx, Arrays.toString(data));
		}
	}
}
