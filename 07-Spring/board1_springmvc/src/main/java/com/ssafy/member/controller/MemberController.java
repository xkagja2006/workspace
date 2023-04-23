package com.ssafy.member.controller;

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
	public String login(@RequestParam("userid") String userId, @RequestParam("userpwd") String userPwd, Model model,
			HttpSession session) throws Exception {
		MemberDto memberDto = memberService.loginMember(userId, userPwd);
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
