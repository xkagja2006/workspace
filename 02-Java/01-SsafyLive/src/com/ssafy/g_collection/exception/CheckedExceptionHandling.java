package com.ssafy.g_collection.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckedExceptionHandling {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // TODO: 다음에서 발생하는 예외를 처리해보자.
    	try {
    		Class.forName("asdf");
    		new FileInputStream("a.txt");
    		DriverManager.getConnection("ss");
    	}catch (ClassNotFoundException e) {
			// TODO: handle exception
    		System.out.println(e.getMessage());
    		e.printStackTrace();
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch ( SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
        // END:
        System.out.println("프로그램 정상 종료");

    }
}
