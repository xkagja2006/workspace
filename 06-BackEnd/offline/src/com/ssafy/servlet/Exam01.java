package com.ssafy.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * 서블릿으로 동작되기 위해서는? 
 * - Servlet 인터페이스 타입이 되어야 한다.
 *  1. Servlet
 *  2. GenericServlet
 *  3. HttlServlet 
 *  셋 중 하나를 상속받는다.
 * 
 * 사용자가 서블릿을 호출하기 위해 2가지 방법을 제시 
 *	 1. web.xml 
 *	 2. @WebServlet : /로 시작하는 경로로 작성한다.
 */
// http://localhost:8080/offline/servlet/exam01
@WebServlet("/servlet/exam01")
public class Exam01 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service 재정의된 메소드 호출");
	}

}
