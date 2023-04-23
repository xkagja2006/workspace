package com.ssafy.sample.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.sample.model.Board;
import com.ssafy.sample.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	private BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("list")
	public String list(Model model) throws Exception {
		List<Board> list = boardService.list();
		model.addAttribute("list", list);
		return "list";
	}

	@GetMapping("detail")
	public String detail(int no, Model model) throws Exception {
		Board board = boardService.detail(no);
		model.addAttribute("board", board);
		return "detail";
	}

	@GetMapping("delete")
	public String delete(int no) throws Exception {
		boardService.delete(no);
		return "redirect:/board/list";
	}

	@GetMapping("write")
	public String writeForm() throws Exception {
		return "write";
	}

	@PostMapping("write")
	public String write(Board board) throws Exception {
		boardService.write(board);
		return "redirect:list";
	}

	@GetMapping("multi-delete")
	public String multiDelete(@RequestParam(name="no") List<Integer> noList) throws Exception {
		boardService.multiDelete(noList);
		return "redirect:list";
	}
}
