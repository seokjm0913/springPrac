package com.team.mapper;

import java.util.List;

import com.team.model.FaqDTO;
import com.team.page.Criteria;

public interface FaqMapper {
	public void insert(FaqDTO fdto);

	public List<FaqDTO> listAll();

	
// 현재 수정중인 부분	
		
	public void faq_enroll(FaqDTO fdto);
	
	public List<FaqDTO> getList();
	
	public FaqDTO getPage(int faq_no);
	
	public int faq_modify(FaqDTO fdto);
	
	public int faq_delete(int faq_no);
	
	public List<FaqDTO> getListPaging(Criteria cri);

	public int getTotal();

}
