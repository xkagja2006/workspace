package com.ssafy.day0328;

import java.util.ArrayList;
import java.util.List;

class Apt {
	int top;

	public Apt(int top) {
		this.top = top;
	}
}

public class problem1 {
	// 노랑 : 1, 파랑 : 0
	public static void main(String[] args) {
		List<Apt> list = new ArrayList<Apt>();
		list.add(new Apt(1));
		list.add(new Apt(0));
		int floor = 8;
		int now = 2;

		while (now <= 8) {
			int index = list.size();
			for (int i = 0; i < index; i++) {
				Apt apt = list.get(i);
				if (apt.top == 1)
					list.add(new Apt(0));
				if (apt.top == 0)
					apt.top = 1;
			}
			System.out.println(list.size());
			now++;
		}

	}
}
