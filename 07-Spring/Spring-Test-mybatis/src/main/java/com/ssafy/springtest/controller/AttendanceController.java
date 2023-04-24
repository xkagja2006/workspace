package com.ssafy.springtest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.springtest.model.Attendance;
import com.ssafy.springtest.model.User;
import com.ssafy.springtest.model.service.AttendanceService;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
	private final AttendanceService attendanceService;
	public AttendanceController(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}
	
	@GetMapping("regist")
	public String regist() {
		return "regist";
	}
	
	@GetMapping("list")
	public String list(HttpSession session, Model model) throws Exception {
		User user = (User)session.getAttribute("userInfo");
		model.addAttribute("list", attendanceService.list(user));
		return "list";  
	}
	
	@GetMapping("multi-delete")
	public String multiDelete(@RequestParam(name = "ano") List<String> anoList) throws Exception {
		attendanceService.multiDelete(anoList);
		return "redirect:list";  
	}
	
	@GetMapping("detail")
	public String detail(String ano, Model model) throws Exception {
		Attendance attendance = attendanceService.detail(ano);
		model.addAttribute("attendance", attendance);
		return "detail";
	}
	
	@PostMapping("regist")
	public String regist(Attendance attendance, RedirectAttributes attrs) throws Exception {
		try {
			attendanceService.regist(attendance);
			attrs.addFlashAttribute("resultCode", "1"); // 성공
		} catch (Exception e) {
			attrs.addFlashAttribute("resultCode", "0"); // 실패
		}
		return "redirect:regist";  
	}
}



