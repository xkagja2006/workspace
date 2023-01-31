package com.ssafy.day06.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

class MyClose implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("MyClose - close()호출됨");
	}

}

// AutoCloseable 구현 클래스
public class Test07 {
	public static void main(String[] args) {
		try (// The resource type MyClose does not implement java.lang.AutoCloseable
				MyClose mc = new MyClose();) {
			System.out.println("try시작");
			System.out.println(1/0);
			System.out.println("try종료");
		} catch (Exception e) {
			System.out.println("예외발생");
		}
		System.out.println("try블럭 밖");

		/*
		 * try (FileReader fr = new FileReader("Test4.txt"); BufferedReader br = new
		 * BufferedReader(fr);) { while (true) { String line = br.readLine(); if (line
		 * == null) break; System.out.println(line); } } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
	}
}