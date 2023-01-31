package com.ssafy.ws.ws05_3;

import java.util.Arrays;

public class BookManager {
	private final int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size = 0;

	public void add(Book book) {
		// 최대 책 수에 도달하지 않았으면 책 추가
		if (size < MAX_SIZE) {
			books[size++] = book;
		}
		// 최대 책 수에 도달했으면 추가 안함
		else {
			System.out.println("책의 수가 100권을 넘어 더이상 추가할 수 없습니다.");
		}
	}

	public void remove(String isbn) {
		System.out.println("***********************도서삭제 : " + isbn + "********************");
		// isbn일치하는 책 삭제 -> 배열 마지막 책을 일치하는 인덱스로 가져와서 배열에 빈 공간이 없게 한다.
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				books[i] = books[size - 1];
				books[size - 1] = null;
				size--;
				break;
			}
		}
	}

	public Book[] getList() {
		System.out.println("***********************도서목록********************");
		return Arrays.copyOf(books, size);
	}

	public Book searchByIsbn(String isbn) {
		System.out.println("***********************도서조회 : " + isbn + "********************");
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}

}
