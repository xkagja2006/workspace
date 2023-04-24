package com.ssafy.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.board.model.AttendanceDto;
import com.ssafy.board.model.ProductDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.member.model.MemberDto;

@Controller
@RequestMapping("product")
public class BoardController {
	private final BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("list")
	public String list(Model model,  HttpSession session) throws Exception {
		System.out.println(session.getAttribute("userInfo"));
		if(session.getAttribute("position").toString().equals("true")) {	//  관리자
		}
		List<AttendanceDto> attendances = boardService.list();
		model.addAttribute("attendances", attendances);
		return "list";
	}

	@GetMapping("registForm")
	public String registForm(RedirectAttributes ra, HttpSession session) throws Exception {
//		if (session.getAttribute("userInfo") == null) {
//			ra.addFlashAttribute("msg", "로그인이 필요합니다");
//			return "redirect:/";
//		}
		return "regist";
	}
	@GetMapping("detail")
	public String detail(Model model,String ano ,HttpSession session) throws Exception {
		System.out.println(ano);
		AttendanceDto attendance = boardService.detail(ano);
		MemberDto member = boardService.findMember(attendance.getUserid());
		model.addAttribute("attendance", attendance);
		model.addAttribute("member", member);
		return "detail";
	}
	@GetMapping("deleteDetail")
	public String deleteDetail(Model model,String ano ,HttpSession session) throws Exception {
//		boardService.deleteDetail(ano);
		return "list";
	}

	@PostMapping("regist")
	public String regist(@ModelAttribute AttendanceDto attendance, RedirectAttributes ra) throws Exception {
		System.out.println(attendance.getAno() + " " + attendance.getUserid() + " " + attendance.getIssuedate() + " " + attendance.getIssue());
		boardService.regist(attendance);
		String msg = attendance.getUserid() + "출결 이슈 등록 완료";
		ra.addFlashAttribute("msg", msg);
		return "redirect:registForm";
	}
}
