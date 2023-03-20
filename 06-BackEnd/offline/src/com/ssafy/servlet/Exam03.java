package com.ssafy.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿으로 동작되기 위해서는? 
 * - Servlet 인터페이스 타입이 되어야 한다.
 *  1. Servlet
 *  2. GenericServlet
 *  3. HttpServlet 
 *  셋 중 하나를 상속받는다.
 * 
 * 사용자가 서블릿을 호출하기 위해 2가지 방법을 제시 
 *	 1. web.xml 
 *	 2. @WebServlet : /로 시작하는 경로로 작성한다.
 */
// http://localhost:8080/offline/servlet/exam03

// value는 배열로 올 수 있다. servlet이 여려개의 경로로 호출되게 할 수 있음.
// 단독으로 쓰이면 생략 가능하다. -> 1번과 2번이 동일하다.
//1. @WebServlet({"/servlet/exam03", "/s/exam04"})
//2. @WebServlet(value= {"/servlet/exam03", "/s/exam04"})

//@WebServlet(urlPatterns = {"/servlet/exam03", "/s/exam04"})

//name : 구분하기 위한 구분자
@WebServlet(name = "servlet.Exam03", value = "/servlet/exam03")
public class Exam03 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service called");
	}
	
}
