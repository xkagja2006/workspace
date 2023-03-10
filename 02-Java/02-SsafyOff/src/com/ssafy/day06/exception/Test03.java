/*
 * try
 * catch
 * finally
 * throws
 * throw
 * +
 * 사용자 정의 예외(extends 예외클래스)
 */
package com.ssafy.day06.exception;

import java.io.FileReader;
import java.io.FileNotFoundException; // 자식클래스
import java.io.IOException; // 부모클래스

public class Test03 {
	public static void main(String[] args) {
		try {
			// 예외 발생할만한 코드를 묶는다.
			FileReader fr = new FileReader("a.txt");
			int ch = fr.read();

			System.out.println(1 / 0);
			String msg = null;
			System.out.println(msg.length());

		} catch (NullPointerException | ArithmeticException e) {
			e.printStackTrace();
		}
//		catch (FileNotFoundException e) { // 자식클래스를 먼저 써야한다!
//			// try블럭에서 발생한 예외중에서 처리할 예외를 선언
//			e.printStackTrace();
//		} 
		catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
		} finally {
			// 예외발생여부와 상관없이 무조건 실행할 코드
		}
	}
}
