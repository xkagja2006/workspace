package com.ssafy.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// MainController가 없어도 잘 되는 이유 : 기본으로 설정을 안해도 찾는다.
// index > main > home > 404 : 순서대로 찾고 다 없으면 404에러.
// 인터셉터에서 이를 설정할 수 있다. (WebMvcController 에서 설정해줌.)

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
}
