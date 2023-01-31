package com.ssafy.ws.ws05_3;

public class BookTest {
	public static void main(String[] args) {
		Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "자바 기본 문법");
		Book b2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "자바 응용");
		Book b3 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "sw모델링");
		Book find = new Book();
		
		BookManager bm = new BookManager();
		bm.add(b1);
		bm.add(b2);
		bm.add(b3);
		
		//도서조회
		//getList함수의 반환형이 void가 아니라 배열인 이유는 리턴값을 통해 메인함수에서 후처리를 해야한다는 뜻! getList함수를 다른 곳에서도 호출 할 수 있기 때문
		Book[] arr = bm.getList();		//bm의 리스트가 이미 100으로 설정되어있음! 크기걱정은 안해도 된다
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].getIsbn() + "\t| " + arr[i].getAuthor() + "\t| " + arr[i].getTitle() + "\t| " + arr[i].getAuthor() + "\t| " + arr[i].getPublisher() + "\t| " + arr[i].getPrice() + "\t| " + arr[i].getDesc());
		}
		
		//도서조회
		find = bm.searchByIsbn("21424");
		System.out.println(find.getIsbn() + "\t| " + find.getAuthor() + "\t| " + find.getTitle() + "\t| " + find.getAuthor() + "\t| " + find.getPublisher() + "\t| " + find.getPrice() + "\t| " + find.getDesc());
		
		//도서삭제
		bm.remove("21424");
		
		//도서조회
		arr = bm.getList();
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].getIsbn() + "\t| " + arr[i].getAuthor() + "\t| " + arr[i].getTitle() + "\t| " + arr[i].getAuthor() + "\t| " + arr[i].getPublisher() + "\t| " + arr[i].getPrice() + "\t| " + arr[i].getDesc());
		}
	}
}
