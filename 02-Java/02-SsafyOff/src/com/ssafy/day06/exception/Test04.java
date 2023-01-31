package com.ssafy.day06.exception;

class 물건사라짐Exception extends Exception {
	public 물건사라짐Exception(String msg) {
		super(msg);
	}
}

class 사장 {
	public void 영업시작() {
		알바 alba = new 알바();
		try {
			alba.일하다();
		} catch (Exception e) {
			System.out.println("에러상황 정리함");
		}
	}
}

class 알바 {
	public void 일하다() throws Exception{
		try {
			throw new Exception();
		}catch(Exception e){
			System.out.println("알바 예외상황 정리");		//여기까지만 쓰면 호출한 곳에서는 에러상황을 알 수 없다.
			
			// 발생한 예외정보를 처리하고나서 해당 에러를 호출한곳에 전달하기위해 에러를 던진다.
			// 큰 예외를 작은 예외로 던져주기 위해 아래와 같이 한다.
			// 던진걸 받는 쪽에서 해당 예외 객체가 존재한다면  throw e; 로 쓰면 된다.
			throw new 물건사라짐Exception("물건사라짐 : " + e.getMessage());	
		}
	}
}

public class Test04 {
	public static void main(String[] args) {
		사장 boss = new 사장();
		boss.영업시작();

	}

}
