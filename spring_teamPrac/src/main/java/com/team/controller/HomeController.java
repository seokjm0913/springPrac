package com.team.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.team.model.FaqDTO;
import com.team.page.Criteria;
import com.team.page.ViewPage;
import com.team.service.FaqService;


@Controller
public class HomeController {
	
	@Autowired
	private FaqService faqService;

	@GetMapping("/")
	public String home() {
		return "home";

	}
	
	@GetMapping("/register")
	public String goRegister() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(FaqDTO fdto) {
		
		faqService.insert(fdto);
		
		return "redirect:/";
	}
	
	@GetMapping("/faq_List")
	public String faq_List(Model model, Criteria cri) {
		List<FaqDTO> faq_List = faqService.getListPaging(cri);
		model.addAttribute("faq_List", faq_List);
		int total = faqService.getTotal();
		ViewPage vp = new ViewPage(cri, total);
		model.addAttribute("pageMaker", vp);
		return "faq_List";
	}
	

	
}
