package com.ssafy.ws.ws06_3;

public class BookTest {
	public static void main(String[] args) {
		Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "자바 기본 문법");
		Book b2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "자바 응용");
		Book b3 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "sw모델링");
		Magazine m1 = new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2022, 9);
		
		Book find = new Book();

		BookManager bm = new BookManager();
		bm.add(b1);
		bm.add(b2);
		bm.add(b3);
		bm.add(m1);

		// 전체도서조회
		Book[] arr = bm.getList(); // bm의 리스트가 이미 100으로 설정되어있음! 크기걱정은 안해도 된다
		System.out.println("**************************도서 전체 목록**************************");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] instanceof Magazine)
				System.out.println(arr[i].getIsbn() + "\t| " + arr[i].getAuthor() + "\t| " + arr[i].getTitle() + "\t| "
						+ arr[i].getAuthor() + "\t| " + arr[i].getPublisher() + "\t| " + arr[i].getPrice() + "\t| "
						+ arr[i].getDesc() + "\t| " + ((Magazine) arr[i]).getYear() + "\t| "
						+ ((Magazine) arr[i]).getMonth());
			else
				System.out.println(arr[i].getIsbn() + "\t| " + arr[i].getAuthor() + "\t| " + arr[i].getTitle() + "\t| "
						+ arr[i].getAuthor() + "\t| " + arr[i].getPublisher() + "\t| " + arr[i].getPrice() + "\t| "
						+ arr[i].getDesc());
		}

		// isbn도서검색
		find = bm.searchByIsbn("21424");
		System.out.println("**************************isbn 도서검색 : " + find.getIsbn() +"**************************");
		System.out.println(find.getIsbn() + "\t| " + find.getAuthor() + "\t| " + find.getTitle() + "\t| "
				+ find.getAuthor() + "\t| " + find.getPublisher() + "\t| " + find.getPrice() + "\t| " + find.getDesc());

		// 제목부분검색
		arr = bm.searchByTitle("Java");
		System.out.println("**************************도서 제목 검색 : " + "Java" +"**************************");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].getIsbn() + "\t| " + arr[i].getAuthor() + "\t| " + arr[i].getTitle() + "\t| "
					+ arr[i].getAuthor() + "\t| " + arr[i].getPublisher() + "\t| " + arr[i].getPrice() + "\t| "
					+ arr[i].getDesc());
		}
		// 도서삭제
		bm.remove("21424");
		System.out.println("**************************도서삭제 : " + "21424" +"**************************");

		//일반도서조회
		arr = bm.getBooks();
		System.out.println("**************************일반도서조회**************************");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].getIsbn() + "\t| " + arr[i].getAuthor() + "\t| " + arr[i].getTitle() + "\t| "
					+ arr[i].getAuthor() + "\t| " + arr[i].getPublisher() + "\t| " + arr[i].getPrice() + "\t| "
					+ arr[i].getDesc());
		}
		
		//잡지조회
		System.out.println("**************************잡지조회**************************");
		Magazine[] arrM = bm.getMagazines();
		for (int i = 0; i < arrM.length; i++) {
			System.out.println(arrM[i].getIsbn() + "\t| " + arrM[i].getAuthor() + "\t| " + arrM[i].getTitle() + "\t| "
					+ arrM[i].getAuthor() + "\t| " + arrM[i].getPublisher() + "\t| " + arrM[i].getPrice() + "\t| "
					+ arrM[i].getDesc() + "\t| " + ((Magazine) arrM[i]).getYear() + "\t| "
					+ ((Magazine) arrM[i]).getMonth());
		}
		
		
		// 전체가격조회
		System.out.println("도서 가격 총합 : " + bm.getTotalPrice());
		
		// 전체가격평균조회
		System.out.println("도서 가격 평균 : " + bm.getPriceAvg());

	}
}
