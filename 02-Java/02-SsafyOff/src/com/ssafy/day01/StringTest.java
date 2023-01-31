package com.ssafy.day01;

import java.util.Arrays;

public class StringTest {
	/**
	 * 자바의 문자열 관련 API 클래스
	 * 
	 * 불변 String 자기가 가지고있는 값 변경 못함
	 * 
	 * 가변 StringBuffer StringBuilder
	 */
	static void exam01() {
		String str1 = "a";
		StringBuffer str2 = new StringBuffer("a");
		StringBuilder str3 = new StringBuilder("a");

		System.out.println(str1.concat("b"));
		System.out.println(str2.append("b"));
		System.out.println(str3.append("b"));

		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);

		String str4 = "a";
		String str5 = "a";
		String str6 = new String("a");
		System.out.println(str4 == str5);
		System.out.println(str5 == str6);
		System.out.println(str5.equals(str6));

	}

	static class MyString {
		String data;

		MyString(String data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
//		exam01();
//		exam02();
//		exam03();
//		String result = exam04("H12234234233i");
		String s = "3 2 3 1 2 3";
		String arr[] = s.split(" ");
		System.out.println(Arrays.toString(arr));
		
		s = "http://www.naver.com";
		System.out.println(s.startsWith("http://"));
		
		s = "flower.jpg";
		System.out.println(s.endsWith(".jpg"));
		
		String contextPath = "/myserver";
		s = "/myserver/login?id=a&pass=b";
		System.out.println(s.substring(contextPath.length(),s.length()));
		
	}

	private static String exam04(String a) {
		a = a.replaceAll("[0-9]", "");
		return a;
	}

	private static void exam03() {
		String s = "Hello";
		char ch = s.charAt(0);
		System.out.println(ch);

		System.out.println(s.length());
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}

		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		s = "Hello";
		if (s.equals("hello")) {
			System.out.println("equals는 대소문자 비교");
		}
		if (s.equalsIgnoreCase("hello")) {
			System.out.println("equalsIgnoreCase는 대소문자 무시");
		}

		s = s.toUpperCase();
		System.out.println(s);
		s = s.toLowerCase();
		System.out.println(s);

		s = "Hello Java";
		int idx = s.indexOf("a");
		System.out.println(s.indexOf("llo"));
		System.out.println(s.indexOf("a", idx + 1));

		idx = s.lastIndexOf("a");

		boolean find = s.contains("llo");

		// 문자열로 만들기 +, valueOf
		String data = "" + 100;
		data += String.valueOf(3);
		System.out.println(data);

		data = "    h  e ll o   ";
		data = data.trim();
		data = data.replace(" ", "");
		System.out.println(data);

	}

	private static void exam02() {
		String s1 = "a";
		// s 시간 측정 :
		long s = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			s1 += i;
		}
		// e 시간 측정 :
		long e = System.currentTimeMillis();
		System.out.println("String 걸린 시간 : " + (e - s) / 1000d);

		// 동기화 처리된 클래스
		StringBuffer s2 = new StringBuffer("a");
		// s 시간 측정 :
		s = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			s2.append(i);
		}
		// e 시간 측정 :
		e = System.currentTimeMillis();
		System.out.println("StringBuffer 걸린 시간 : " + (e - s) / 1000d);

		// 비동기화 처리된 클래스
		StringBuilder s3 = new StringBuilder("a");
		// s 시간 측정 :
		s = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			s3.append(i);
		}
		// e 시간 측정 :
		e = System.currentTimeMillis();
		System.out.println("StringBuilder 걸린 시간 : " + (e - s) / 1000d);

	}

}
