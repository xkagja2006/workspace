package com.ssafy.member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {
	private MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	// 단순 페이지 이동
	@GetMapping("join")
	public String join() {
		return "user/join";
	}

	// 단순 페이지 이동
	@GetMapping("login")
	public String login() {
		return "user/login";
	}

	// 실제 로그인
	@PostMapping("login")
	public String login(HttpServletResponse response, @RequestParam("userid") String userId, @RequestParam("userpwd") String userPwd, Model model,
			HttpSession session) throws Exception {
		MemberDto memberDto = memberService.loginMember(userId, userPwd);
		
//		Cookie cookie = new Cookie("username", username);
//	    cookie.setMaxAge(24 * 60 * 60); // 쿠키의 유효기간을 설정 (초 단위, 여기서는 24시간)
//	    response.addCookie(cookie);
		
//		cookie 설정 
//		String idsave = request.getParameter("saveid");
//		if("ok".equals(idsave)) { //아이디 저장을 체크 했다면.
//			Cookie cookie = new Cookie("ssafy_id", userId);
//			cookie.setPath(request.getContextPath());
//			cookie.setMaxAge(60 * 60 * 24 * 365 * 40); //40년간 저장.
//			response.addCookie(cookie);
//		} else { //아이디 저장을 해제 했다면.
//			Cookie cookies[] = request.getCookies();
//			if(cookies != null) {
//				for(Cookie cookie : cookies) {
//					if("ssafy_id".equals(cookie.getName())) {
//						cookie.setMaxAge(0);
//						response.addCookie(cookie);
//						break;
//					}
//				}
//			}
//		}
		
		if (memberDto != null) {
			session.setAttribute("userinfo", memberDto);
			return "redirect:/";
		} else {
			model.addAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
			return "user/login";
		}
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
