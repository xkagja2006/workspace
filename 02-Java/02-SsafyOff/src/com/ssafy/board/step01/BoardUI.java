/*
 * 접근제한자 - class, 변수, 메서드에 붙일 수 있음.
 * 
 * public : 누구나 사용가능
 * protected : 
 * default(아무것도 적지 않았을 때) : 같은 패키지 안에서만 사용
 * private : 외부 노출 안됨 -> class에는 붙이지 않음. 붙이는 경우 - 변수개념으로 클래스를 사용할 때(클래스 안의 클래스).
 * 
 */
package com.ssafy.board.step01;

import java.util.Arrays;
import java.util.Scanner;

//class 정의 앞에는 default, public만 사용
//클래스는 같은 패키지, 다른패키지에서 사용할것인지만 구분.
//public 클래스를 사용하면 다른패키지 안에서도 사용가능. 하지만 해당 클래스를 import해야함.
//String, System 등은 import하지않아도 사용 가능하다.(Java.lang 하위 클래스)
public class BoardUI {
	Scanner sc = new Scanner(System.in); // static이 없으니깐 인스턴스 변수.

	Board[] list = new Board[2]; // Board를 담는 배열을 만든다.
	int pos = 0; // 배열의 크기와 입력될 위치

	void start() {
		System.out.println("게시판 관리 프로그램 V1");
		outer: while (true) {
			switch (menu()) {
			case 1:
				list();
				break;
			case 2:
				write();
				break;
			case 0:
				quit();
				return;
			}
		}
	}

	private void quit() {
		System.out.println("종료메뉴선택");
	}

	private void write() {
		// 배열의 크기가 꽉 찬 상태라면 배열의 크기를 늘려주자.
		if (list.length == pos) {
			list = Arrays.copyOf(list, pos * 2);
			// Board[] temp = new Board[pos*2];

			// System.arraycopy(list, 0, temp, 0, pos);
//			for(int i = 0; i < pos; i++) {
//				temp[i] = list[i];
//			}
			// list = temp;
		}
		System.out.print("글쓴이 : ");
		String writer = sc.nextLine();
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String content = sc.nextLine();

		Board b = new Board(writer, title, content); // write()가 끝나면 b가 없어진다.-> 베열에 넣어준다
		b.no = Sequence.nextVal();
		list[pos++] = b;
//		b.writer = writer;
//		b.title = title;
//		b.content = content;
		System.out.println("등록되었습니다.");
	}

	private void list() {
		System.out.println("-----------------------");
		System.out.println("글번호\t제목\t글쓴이");
		System.out.println("-----------------------");
		if (pos == 0)
			System.out.println("등록된 게시글 없음");
		for(int i = pos - 1; i >= 0; i--) {	//최신글부터 정렬하기
			Board b = list[i];
			System.out.println(b.no + "\t" + b.title +"\t"  +b.writer);			
		}
		System.out.println("-----------------------");
	}

	// menu ui는 같은 패키지 안에서만 쓰일거라 private
	private int menu() { // static이 없으니깐 인스턴스 메소드 -> 인스턴스 변수 접근 가능
//		Scanner sc = new Scanner(System.in);	//새로운 메뉴를 선택할때마다 새로운 객체 생성 -> 데이터 낭비, 등록사용할때 문제 됨 =>멤버변수로 만들어야함
		System.out.println("-----------------------");
		System.out.println("1. 목록");
		System.out.println("2. 등록");
		System.out.println("0. 종료");
		System.out.println("-----------------------");
		System.out.print("메뉴(번호) : ");
		return Integer.parseInt(sc.nextLine());
	}

}
