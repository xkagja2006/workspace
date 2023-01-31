package com.ssafy.ws.ws06_3;

import java.util.Arrays;

public class BookManager {
	private final int MAX_SIZE = 100;
	//Book 배열은 Magazine 객체를 요소로 가질 수 있다!!
	private Book[] books = new Book[MAX_SIZE];
	private int size = 0;
	
	public void add(Book book) {
		if(size < MAX_SIZE) {
			books[size++] = book;
		}else {
			System.out.println("100권을 초과하여 추가할 수 없습니다.");
		}
	}
	
	//도서삭제
	public void remove(String isbn) {
		for(int i = 0; i < size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				books[i] = books[size-1];
				size--;
				break;
			}
		}
	}
	
	//전체도서조회
	public Book[] getList() {
		return Arrays.copyOf(books, size);
	}
	
	//isbn도서검색
	public Book searchByIsbn(String isbn) {
		Book b = new Book();
		for(int i = 0; i < size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				b = books[i];
			}
		}
		return b;
	}
	
	//제목부분검색
	public Book[] searchByTitle(String title) {
		Book[] books2 = new Book[size];
		int len = 0;
		for(int i = 0; i < size; i++) {
			if(books[i].getTitle().contains(title)) {
				books2[i] = books[i];
				len++;
			}
		}
		return Arrays.copyOf(books2, len);
	}
	
	//잡지조회
	public Magazine[] getMagazines() {	//instanceof 사용하기!
		Book[] books2 = new Magazine[size];
		int len = 0;
		for(int i = 0; i < size; i++) {
			if(books[i] instanceof Magazine) {
				books2[len] = books[i];
				len++;
			}
		}
		return (Magazine[]) Arrays.copyOf(books2, len);
	}
	
	//일반도서조회
	public Book[] getBooks() {
		Book[] books2 = new Book[size];
		int len = 0;
		for(int i = 0; i < size; i++) {
			if(!(books[i] instanceof Magazine)) {
				books2[len] = books[i];
				len++;
			}
		}
		return Arrays.copyOf(books2, len);
	}
	
	//전체가격조회
	public int getTotalPrice() {
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += books[i].getPrice();
		}
		return sum;
	}
	
	//전체가격평균조회
	public double getPriceAvg() {
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += books[i].getPrice();
		}
		return sum/size;
	}
}
