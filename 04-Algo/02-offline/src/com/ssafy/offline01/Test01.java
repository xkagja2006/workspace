/*
 * 기저조건 : 재귀를 멈추는 조건
 * 
 * 자기자신을 호출하는 함수
 * 재귀와 반복은 서로 변환이 가능하다.
 * 재귀함수는 콜스택이 계속 쌓이게 된다.
 * 
 */

package com.ssafy.offline01;

public class Test01 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("a");
		Thread.sleep(100);
		main(null);
	}
}
