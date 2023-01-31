package com.ssafy.day06.exception;

//컴파일시 체크되는 예외
class MyException extends Exception {

}

//실행시에 체크되는 예되
class MyRuntimeException extends RuntimeException {

}

//FileNotFoundException
// nullPointerException
public class Test02 {
	public static void main(String[] args) {
		try {
			throw new MyException();
			
		} catch (MyException e) {
			// TODO: handle exception
		}	
		
	}
}
