package com.ssafy.todomvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.todomvc.model.Todo;
import com.ssafy.todomvc.model.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {
	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

//	@RequestMapping("/todo/list")	// GET, POST모두 가능하다
//	@RequestMapping(value="/todo/list", method = RequestMethod.GET)	// GET방식만 가능하게 처리
//	@GetMapping("/todo/list")
	@GetMapping("list")
	public String listTodo(Model model) throws Exception {
		List<Todo> list = todoService.listTodo();
		model.addAttribute("list", list);
		return "todo/index";
	}
	@GetMapping("delete")
	public String deleteTodo(int no) throws Exception {
		todoService.deleteTodo(no);
		return "redirect:list";
	}
	
	@PostMapping("regist")
	public String registTodo(Todo todo) throws Exception {
		System.out.println("Todo : " + todo.getContent());
		todoService.registTodo(todo);
		return "redirect:list";	// / 가 없으면 맨 뒷부분을 변경하는것!!!!!!!!!!!
	}
	
}
