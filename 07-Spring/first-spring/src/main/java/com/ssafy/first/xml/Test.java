package com.ssafy.first.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("xml/first-exam.xml");	// ClassPath부터 xml을 읽는다.
		String[] names = container.getBeanDefinitionNames();
		for(String name : names) {
			System.out.println(name);
		}
	}
}
