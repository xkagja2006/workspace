package com.ssafy.jdbc.user;

import java.util.Scanner;

public class UserUI {
	private UserDao userDao;
	private Scanner sc = new Scanner(System.in);

	public UserUI() {
		userDao = UserDaoImpl.getInstance();
	}

	public void service() {
		while(true) {
			int choice = menu();
			switch (choice) {
			case 1:
				join();
				break;
			case 2:
				break;
			case 3:
				break;
			case 0:
				break;
			}
		}
	}

	private void join() {
		//ssafy:싸피:1234:대전 싸피
		System.out.println("아이디:이름:패스워드:주소 순으로 입력");
		String[] infos = sc.nextLine().split(":");
		UserDto user = new UserDto();
		user.setId(infos[0]);
		user.setName(infos[1]);
		user.setPassword(infos[2]);
		user.setAddr(infos[3]);
		try {
			userDao.insertUser(user);
			System.out.println("사용자 등록 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("등록 처리시 문제 발생");
			e.printStackTrace();
		}
	}

	private int menu() {
		System.out.println("1. 등록");
		System.out.println("2. 수정");
		System.out.println("3. 삭제");
		System.out.println("0. 종료");
		System.out.println("메뉴 선택 : ");
		
		return Integer.parseInt(sc.nextLine());
	}
	
	
}
