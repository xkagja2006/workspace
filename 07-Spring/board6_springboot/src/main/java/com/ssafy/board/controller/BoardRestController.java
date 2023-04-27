package com.ssafy.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.Comment;
import com.ssafy.board.model.service.BoardService;

@RestController
@RequestMapping("/comment")
public class BoardRestController {
	private BoardService boardService;

	public BoardRestController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}
	
	@GetMapping("{articleNo}")
	public List<Comment> writeComment(@PathVariable int articleNo){
		return boardService.listComment(articleNo);
	}
	
	@PostMapping
	public List<Comment> writeComment(@RequestBody Comment comment){
		boardService.writeComment(comment);
		return boardService.listComment(comment.getArticleNo());
	}
	
	@DeleteMapping("{articleNo}/{commentNo}")
	public List<Comment> deleteComment(@PathVariable int articleNo, @PathVariable int commentNo){
		boardService.deleteComment(commentNo);
		return boardService.listComment(articleNo);
	}
}
