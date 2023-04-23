package com.ssafy.sample.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.cj.Session;
import com.ssafy.sample.model.Product;
import com.ssafy.sample.model.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/list")
	public String list(Model model) throws Exception {
		List <Product> list = productService.list();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	
	@GetMapping("/writePage")
	public String wirtePage(HttpSession session, Model model)throws Exception{
		if(session.getAttribute("userInfo") == null) {
			model.addAttribute("msg", "로그인 후 사용하세요님아");
			return "index";
		}
		return "regist";
	}
	
	@RequestMapping("/write")
	public String wirte(Product product,RedirectAttributes ra)throws Exception{
		Product check = productService.get(product);
		if(check != null) {
			ra.addFlashAttribute("msg", "상품코드를 다시 입력하세용 님아");
			return "redirect:writePage";
		}
		productService.write(product);
		return "redirect:list";
	}
	
}
