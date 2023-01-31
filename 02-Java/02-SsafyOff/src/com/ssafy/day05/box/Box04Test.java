package com.ssafy.day05.box;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Map<String, String>
class Box04<K, V> {		// 여러개의 타입매개변수 선언
	private K key;
	private V value;

	Box04(K key, V value){
		this.key = key;
		this.value = value;
	}
}

public class Box04Test {
	public static void main(String[] args) {
		Box04<Integer, String> box = new Box04<Integer, String>(1,"b");
	
//		1.7버전 부터 <>연산자를 이용해서 타입파라미터를 생략 할 수 있게 지원한다.
		Box04<Integer, Integer> box2 = new Box04<>(1,2);
		
		List<Integer> list = new ArrayList<>();
		
//		Iterator ite = list.iterator();		// 타입 파라미터를 주지 않았다. 
		Iterator<Integer> ite = list.iterator();		
		
	}
}
