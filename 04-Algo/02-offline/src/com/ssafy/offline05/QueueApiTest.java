package com.ssafy.offline05;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueApiTest {
	static class Student implements Comparable<Student>{
		String name;
		int age;
		public Student(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		
		
		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + "]";
		}


		@Override
		public int compareTo(Student o) {
			return this.age - o.age;	//나이순 정렬
		}
	}
	
	public static void main(String[] args) {
		Queue<Student> q3 = new PriorityQueue<>();
		q3.offer(new Student("정경호, 전도연", 80));
		q3.offer(new Student("윤성빈, 김강민", 78));
		q3.offer(new Student("송혜교, 유재석", 99));
		
		System.out.println(q3.poll());
		System.out.println(q3.poll());
		System.out.println(q3.poll());
		
		
		Queue<String> q2 = new PriorityQueue<>();
		q2.offer("멀티스캔들");
		q2.offer("피지컬 100");
		q2.offer("더글로리2");
		
		System.out.println(q2.poll());
		System.out.println(q2.poll());
		System.out.println(q2.poll());
		
		
		
		Queue<String> q1 = new LinkedList<>();
		System.out.println(q1.isEmpty() + " : " + q1.size());
		q1.offer("큐 연습");
		q1.offer("스택 연습");
		
		System.out.println(q1.poll());	//데이터 꺼내고 반환
		System.out.println(q1.isEmpty() + " : " + q1.size());
		System.out.println(q1.peek());	
		System.out.println(q1.isEmpty() + " : " + q1.size());
	}
}
