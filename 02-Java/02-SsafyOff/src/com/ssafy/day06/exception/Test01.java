package com.ssafy.day06.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(1 / 0); // runtimeException

		// Unhandled exception type FileNotFoundException
		// checked exception(runtimeException계열이 아닌 것)
		// 반드시 에외처리를 해야만 한다.
		Scanner sc = new Scanner(new File("a.txt"));
	}
}
