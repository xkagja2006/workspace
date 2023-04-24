package com.ssafy.springtest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.springtest.model.User;
import com.ssafy.springtest.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("login")
	public String login(User user, HttpSession session) throws Exception {
		User userInfo = userService.login(user);
		if (userInfo != null) {
			session.setAttribute("userInfo", userInfo);
		}
		return "redirect:/attendance/regist";
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
