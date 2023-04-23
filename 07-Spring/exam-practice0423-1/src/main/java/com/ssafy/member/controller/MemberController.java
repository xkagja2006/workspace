package com.ssafy.member.controller;

import java.lang.System.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.cj.Session;
import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {

	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@PostMapping("login")
	public String login(HttpSession session, String userId, String userPassword, RedirectAttributes ra)
			throws Exception {
		MemberDto member = memberService.login(userId, userPassword);
		if (member != null) {
			session.setAttribute("userInfo", member);
		} else {
			session.setAttribute("userInfo", null);
			ra.addFlashAttribute("msg" , "아이디와 비밀번호를 확인해 주세요");
		}
		return "redirect:/";
	}
}
