package com.ssafy.day07.sort;

import java.util.Arrays;
import java.util.Comparator;

public class test04 {
	public static void main(String[] args) {
		Data1 d1 = new Data1("더글로리", "송혜교", 2022);
		Data1 d2 = new Data1("나의아저씨", "아이유", 2015);
		Data1 d3 = new Data1("주몽", "송일국", 2006);
		Data1 d4 = new Data1("미스터선샤인", "김태리", 2019);

		Data1[] arr = { d1, d2, d3, d4 };

//		1번
//		Arrays.sort(arr, new DataComparator1());

//		2번		
//		Arrays.sort(arr, new Comparator<Data1>() {
//			@Override
//			public int compare(Data1 o1, Data1 o2) {
//				return o1.year - o2.year;
//			}
//		});

		System.out.println(Arrays.toString(arr));
	}
}

class Data1 {
	String title;
	String name;
	int year;

	public Data1(String title, String name, int year) {
		super();
		this.title = title;
		this.name = name;
		this.year = year;
	}

	@Override
	public String toString() {
		return String.format("%s-%s-%d", title, name, year);
	}
}

// 1번에 쓰임
//class DataComparator1 implements Comparator<Data1> {
//	@Override
//	public int compare(Data1 o1, Data1 o2) {
//		return o1.year - o2.year;
//	}
//}
