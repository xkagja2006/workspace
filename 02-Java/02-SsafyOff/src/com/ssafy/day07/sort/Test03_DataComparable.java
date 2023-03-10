package com.ssafy.day07.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test03_DataComparable {
	static class Data implements Comparable<Data>{
//		static class Data {
		String name;
		int age;

		Data(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name + " , " + age;
		}
		
		/*
		 * 0 : 자리바꿈 없음
		 * 음수 : 비교대상 앞으로 이동(더 작음)
		 * 양수 : 비교대상 뒤로 이동(더 큼)
		 */
		@Override
		public int compareTo(Data o) {
//			return (this.age - o.age);	//나이순으로 오름차순 정렬
			return (-1)*(this.name.compareTo(o.name));	//이름순으로 내림차순 정렬
		}
	}

	public static void main(String[] args) {
		// "a" < "b"
		// "abcd" < "ac"
		System.out.println("b".compareTo("b")); // 0
		System.out.println("b".compareTo("c")); // -1
		System.out.println("cc".compareTo("cbc")); // 1
		System.out.println("b".compareTo("가")); // -43934

		Data d1 = new Data("손흥민", 30);
		Data d2 = new Data("이병헌", 48);
		Data d3 = new Data("이민정", 44);
		Data d4 = new Data("기안84", 35);

		Data[] arr = { d1, d2, d3, d4 };
		Arrays.sort(arr);
		Arrays.sort(arr, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr));
		
		List<Data> list = Arrays.asList(d1, d2, d3, d4);
		Collections.sort(list);
		System.out.println(list);
	}
}
