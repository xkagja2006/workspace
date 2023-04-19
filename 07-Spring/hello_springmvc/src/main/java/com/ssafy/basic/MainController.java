package com.ssafy.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

//	@RequestMapping(value="/hello", method = RequestMethod.GET)
	@GetMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("basic/result");
		mav.addObject("msg", "안녕하세요~!~!!~~!!!");
		return mav;
	}

	@GetMapping("/single")
	public String single() {
		return "single";
	}

	@PostMapping("/single")
	public String single(String userid, String username, int area, Model model) {
		String msg = username + "(" + userid + ")님의 지역 : " + area;
		System.out.println(msg);
		model.addAttribute("msg", msg);
		return "basic/result";
	}

	@GetMapping("/multi")
	public String multi() {
		return "multi";
	}

	@PostMapping("/multi")
	public String multi(ParamDto paramDto, ModelMap modelMap) {
		modelMap.addAttribute("msg", paramDto);
		return "basic/result";
	}
}
