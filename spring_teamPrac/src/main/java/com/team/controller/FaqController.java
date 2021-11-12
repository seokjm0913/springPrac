package com.team.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team.model.FaqDTO;
import com.team.service.FaqService;


@Controller
public class FaqController {
	
	 private static final Logger log = LoggerFactory.getLogger(FaqController.class);
	
	 @Autowired
	 private FaqService faqService;
	 
	 @GetMapping("/faq_list")
	 public void faq_listGET(Model model) {
		 log.info("게시판 목록 페이지 진입");
		 model.addAttribute("faq_list", faqService.getList());
	 }
	 
	 @GetMapping("/faq_enroll")
	 public void faq_enrollGET() {
		 log.info("게시판 등록 페이지 진입");
	 }
	 
	 @PostMapping("/faq_enroll")
	 public String faq_enrollPOST(FaqDTO fdto, RedirectAttributes rttr) {
		 log.info("FaqDTO" + fdto);
		 faqService.faq_enroll(fdto);
		 rttr.addFlashAttribute("result", "faq 게시글 등록 성공");
		 return "redirect:/faq_List";
	 }
	 
	 @GetMapping("/faq_contents")
	 public void faqGetPage(int faq_no, Model model) {
		 model.addAttribute("pageInfo", faqService.getPage(faq_no));
	 }
	 
	 @GetMapping("/faq_modify")
	 public void faq_modifyGet(int faq_no, Model model) {
		 model.addAttribute("pageInfo", faqService.getPage(faq_no));
	 }
	 
	 @PostMapping("/faq_modify")
	 public String faq_modifyPost(FaqDTO fdto, RedirectAttributes rttr) {
		 faqService.faq_modify(fdto);
		 rttr.addFlashAttribute("result", "faq 게시글 수정 성공");
		 return "redirect:/faq_List";
	 }
	 
	 @PostMapping("/faq_delete")
	 public String faq_deletePost(int faq_no, RedirectAttributes rttr) {
		 faqService.faq_delete(faq_no);
		 rttr.addFlashAttribute("result", "faq 게시글 삭제 성공");
		 return "redirect:/faq_List";
	 }
	 
	 
	 
	 
	 
//	@Autowired
//	private FaqService faqService;
//
//	@GetMapping("/")
//	public String home() {
//		return "home";
//
//	}
//	

	

	
}
