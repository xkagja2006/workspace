package com.ssafy.day06.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test06 {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("Test4.txt");
			br = new BufferedReader(fr);
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
