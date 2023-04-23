package com.ssafy.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.sample.model.User;
import com.ssafy.sample.model.service.UserSerivce;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserSerivce userService;

	public UserController(UserSerivce userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/login")
	public String login(HttpSession session, User user, RedirectAttributes ra ) throws Exception {
		
		User userInfo = userService.login(user);
		if(userInfo != null) {
			session.setAttribute("userInfo", userInfo);
		}
		else {
			ra.addFlashAttribute("msg", "님 아이디 틀림 ㅎㅎ.");
		}
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();

		return "redirect:/";
	}
}
