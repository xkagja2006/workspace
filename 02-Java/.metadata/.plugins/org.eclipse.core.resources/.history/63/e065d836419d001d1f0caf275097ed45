package com.ssafy.day07.sort;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Parent01 {
	void call(String msg);
}

@FunctionalInterface
interface Parent02 {
	int call();
}

public class Test05_Lamda {
	static void test(Parent01 p) {
		p.call("hello");
	}

	static void test2(Parent02 p) {
		System.out.println(p.call());
	}

	public static void main(String[] args) {
		test2(() -> 30);

		// 익명클래스 안씀
		Parent01 p = new Parent01() {
			@Override
			public void call(String msg) {
				System.out.println(msg + "}}");
			}
		};
		test(p);

		// 익명클래스
		test(new Parent01() {
			@Override
			public void call(String msg) {
				System.out.println(msg + ">>");
			}
		});

		// 람다식으로 변환
		test(msg -> System.out.println(msg + "))"));
		// test는 parent01을 매개변수로 받음.-> 생략
		// Parent01에는 call메소드밖에 없음 -> 생략
		// call메소드는 String타입을 매개변수로 받음 -> 생략
		// 매개변수가 msg로 한개뿐임 -> ()생략. 2개이상이거나 없으면 ()써야함
		// 실행문장이 한문장임 -> {}생략.
		// 실행문장이 한문장이고 return문인경우 return키워드를 제거해야 함.

		List<String> list = Arrays.asList("a", "aa", "aaa");
		list.stream().forEach(v -> System.out.println(v));
		list.stream().forEach(System.out::println);

	}
}
