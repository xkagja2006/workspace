package com.ssafy.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminUser adminUser = context.getBean("adminUser", AdminUser.class);
		GeneralUser generalUser = context.getBean("generalUser", GeneralUser.class);
		AdminUser a = new AdminUser();
		
		System.out.println("**********1. GeneralUser");
		generalUser.useApp();
		System.out.println("**********2. AdminUser");
		try {
			adminUser.useApp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
