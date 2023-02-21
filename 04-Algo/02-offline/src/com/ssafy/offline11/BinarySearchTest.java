package com.ssafy.offline11;

import java.util.Arrays;

public class BinarySearchTest {
	static int[] data = { 7, 1, 2, 10, 78, 33, 9, 15 };

	public static void main(String[] args) {
		Arrays.sort(data);
		System.out.println(Arrays.toString(data));
		System.out.println(call(10));
		System.out.println(call(9));
		System.out.println(call(12));
		
		System.out.println(call2(10, 0, data.length-1));
		System.out.println(call2(9, 0, data.length-1));
		System.out.println(call2(12, 0, data.length-1));

		
		// 못찾은 경우의 음수값의 의미 : 만약, 값을 삽입한다면 어는 위치에 들어가야할지 제공.
		// 이때 인덱스는 1부터 시작(0때문에.)                                                      
		System.out.println(call3(10));
		System.out.println(call3(9));
		System.out.println(call3(12));	// -6 : 들어간다면 6번째로 들어간다.
		System.out.println(call3(0));	//-1
		System.out.println(call3(4));	//-3
	}

	private static int call3(int find) {
		return Arrays.binarySearch(data, find);
	}

	private static int call(int find) {
		int min = 0, max = data.length - 1, mid;
		while (min <= max) {
			mid = (min + max) / 2;
			if (data[mid] == find)
				return mid;
			if (data[mid] < find)
				min = mid + 1;
			else
				max = mid - 1;
		}
		return -1;
	}

	private static int call2(int find, int min, int max) {
		if (min > max)
			return -1;

		int mid = (min + max) / 2;

		if (data[mid] == find)
			return mid;
		if (data[mid] < find)
			return call2(find, mid + 1, max);
		else
			return call2(find, min, mid-1);
	}
}
