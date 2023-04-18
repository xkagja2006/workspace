package com.ssafy.hw;

import java.util.Random;

public class AdminUser implements User {

	@Override
	public void useApp() throws ApplicationException {
		System.out.println("애플리케이션을 관리합니다.");
		Random r  = new Random();
//		 예외 발생 코드
		 if(r.nextInt(2)==0) {
			 throw new ApplicationException();
		 }
	}

}
