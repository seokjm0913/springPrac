package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.team.mapper.FaqMapper;
import com.team.model.FaqDTO;
import com.team.page.Criteria;

public class FaqServiceImpl implements FaqService{
	
	@Autowired
	private FaqMapper faqMapper;
	
	@Override
	public void insert(FaqDTO fdto) {
		faqMapper.insert(fdto);
		
	}

	@Override
	public List<FaqDTO> listAll() {
		return faqMapper.listAll();
	}
	
	/* 페이징 */
	@Override
	public List<FaqDTO> getListPaging(Criteria cri) {
		return faqMapper.getListPaging(cri);
	}

	@Override
	public int getTotal() {
		return faqMapper.getTotal();
	}
	
	/* 게시글 등록 */
	@Override
	public void faq_enroll(FaqDTO fdto) {
		faqMapper.faq_enroll(fdto);
		
	}
	
	/* 게시판 목록 */
	@Override
	public List<FaqDTO> getList() {
		return faqMapper.getList();
	}
	
	/* 게시판 조회 */
	@Override
	public FaqDTO getPage(int faq_no) {
		return faqMapper.getPage(faq_no);
	}
	
	/* 게시판 수정 */
	@Override
	public int faq_modify(FaqDTO fdto) {
		return faqMapper.faq_modify(fdto);
	}

	@Override
	public int faq_delete(int faq_no) {
		return faqMapper.faq_delete(faq_no);
	}
	
}
