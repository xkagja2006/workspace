package com.ssafy.day05.box;

interface Drink{}

class Sprite implements Drink{}

interface Burger{}
class Hamburger implements Burger{}

class BurgerSet<D, B> implements Drink, Burger{}

class MixBox<T extends Drink & Burger>{}	//두 타입을 동시에 가져야 한다.


public class Box05Test {
	public static void main(String[] args) {
//		MixBox<Hamburger> box = new MixBox<>();	//Drink & Burger타입이 아니다.
//		MixBox<Sprite> box = new MixBox<>();	//Drink & Burger타입이 아니다.
		MixBox<BurgerSet> box = new MixBox<>();		//Generic파라미터로 정의되어 있는 상태!
		MixBox<BurgerSet<Sprite, Hamburger>> box1 = new MixBox<>();		//Drink & Burger 클래스를 동시에 가지고 있는 파라미터를 정의해야 한다!
		
	}
}
