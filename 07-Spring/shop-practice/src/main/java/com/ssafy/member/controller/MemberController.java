package com.ssafy.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@GetMapping("login")
	public String login() {
		return "user/login";
	}

	// 실제 로그인
	@PostMapping("/login")
	public String login(String userId, @RequestParam("password") String userPwd, RedirectAttributes model,
			HttpSession session) throws Exception {
		MemberDto memberDto = memberService.loginMember(userId, userPwd);
		if (memberDto != null) {
			session.setAttribute("userInfo", memberDto);
			return "redirect:/";
		} else {
			model.addFlashAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
			
			return "redirect:/";
		}
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
