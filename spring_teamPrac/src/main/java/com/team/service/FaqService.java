package com.team.service;

import java.util.List;

import com.team.model.FaqDTO;
import com.team.page.Criteria;

public interface FaqService {
	public void insert(FaqDTO fdto);

	public List<FaqDTO> listAll();
	
	
//	새로 작성하는 부분
	
	
	/* 게시판 등록 */
	public void faq_enroll(FaqDTO fdto);
	
	/* 게시판 목록 */
	public List<FaqDTO> getList();
	
	/* 게시판 조회 */
	public FaqDTO getPage(int faq_no);
	
	/* 게시판 수정 */
	public int faq_modify(FaqDTO fdto);
	
	/* 게시판 삭제 */
	public int faq_delete(int faq_no);
	
	/* 게시판 페이징 */
	public List<FaqDTO> getListPaging(Criteria cri);
	public int getTotal();
	
}
