package com.ssafy.board.step01;

class Sequence {
	private static int no = 1;	//다른곳에서 사용할 수 없다!

	static int nextVal() {		//글쓴이, 내용 처럼 객체별로 독립적으로 사용하지 않고 모든 객체들이 공용으로 사용하기 때문에 클래스메소드로 만들어준다.
		return no++;
	}
	
}
