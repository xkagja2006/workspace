package com.ssafy.g_collection.exception;

public class SimpleException {
    public static void main(String[] args) {
        int[] intArray = { 10 };
        try {
        	System.out.println(intArray[2]);
        }catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
        	System.out.println("예외 처리 완료" + e.getMessage());
        	e.printStackTrace();
		}
        System.out.println("프로그램 종료합니다.");
    }
}
