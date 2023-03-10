package com.ssafy.day06.exception;

import java.util.Random;

class LottoNumberException extends RuntimeException{
	public LottoNumberException() {
		super("로또 번호는 1 - 45 사이어야 한다.");
	}
	public LottoNumberException(int num) {
		super("로또 번호는 1 - 45 사이어야 한다. : " + num);
	}
}
class LottoService{
	private static final int MAX_NUM = 50;
	public int makeNumber() throws LottoNumberException{
		Random r = new Random();
		int num = r.nextInt(45) + 1;
		if(num > 3) {
			throw new LottoNumberException(num);
		}
		return num;
	}
}
public class Test08 {
	public static void main(String[] args) {
		LottoService service = new LottoService();
		try {
			System.out.println(service.makeNumber());
		}catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
	}
}
