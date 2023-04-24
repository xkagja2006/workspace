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

import com.ssafy.board.model.ProductDto;
import com.ssafy.board.model.service.BoardService;

@Controller
@RequestMapping("product")
public class BoardController {
	private final BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("list")
	public String list(Model model) throws Exception {
		List<ProductDto> products = boardService.list();
		model.addAttribute("products", products);
		return "list";
	}

	@GetMapping("registForm")
	public String registForm(RedirectAttributes ra, HttpSession session) throws Exception {
		if (session.getAttribute("userInfo") == null) {
			ra.addFlashAttribute("msg", "로그인이 필요합니다");
			return "redirect:/";
		}
		return "regist";
	}

	@PostMapping("regist")
	public String regist(@ModelAttribute ProductDto product, RedirectAttributes ra) throws Exception {
		if (product.getPrice().equals("") || product.getPrice() == null) {
			return "error";
		} else {
			boardService.regist(product);
			ra.addFlashAttribute("msg", "등록에 성공하였습니다.");
			return "redirect:list";
		}
	}
}
