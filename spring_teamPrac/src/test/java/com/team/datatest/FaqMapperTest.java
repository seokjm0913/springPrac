package com.team.datatest;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.team.mapper.FaqMapper;
import com.team.model.FaqDTO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class FaqMapperTest {
	
	@Autowired
	private FaqMapper faqMapper;
	
//	@Test
	public void FaqInsertTest() {
	
		for(int i = 1; i<=500; i++) {
			FaqDTO fdto = new FaqDTO();
			fdto.setFaq_title(i+ "제목");
			fdto.setFaq_content(i + "내용");

			faqMapper.insert(fdto);
		}

	}
	
//	@Test
	public void faqGetList() {
		List<FaqDTO> list = faqMapper.getList();
		for(int i = 0; i < list.size(); i++) {
			System.out.println("==============" + list.get(i));
		}
	}
	
	
//	@Test
	public void getPageTest() {
		int faq_no = 8;
		
		System.out.println("============" + faqMapper.getPage(faq_no));
	}
	
//	@Test
	public void faq_modifyTest() {
		FaqDTO fdto = new FaqDTO();
		fdto.setFaq_no(301);
		fdto.setFaq_title("수정제목");
		fdto.setFaq_content("수정내용");
		
		int result = faqMapper.faq_modify(fdto);
		System.out.println("====result=====" + result);
	}
	
//	@Test
	public void faq_delete() {
		int result = faqMapper.faq_delete(1);
		System.out.println("====result 삭제완료=====" + result);
	}
	
	
	
	
	
	
//	//@Test
//	public void boardListAllTest() {
//		List<BoardDTO> list = boardMapper.list_all();
//		for(BoardDTO i : list) {
//			System.out.println(i);
//		}
//	}
	
//	//@Test
//	public void deleteTest() {
//		boardMapper.delete(2L);
//	}
//	
//	//@Test
//	public void boardContentTest() {
//		BoardDTO dto = boardMapper.boardContent(1L);
//		System.out.println(dto);
//	}
//	
//	//@Test
//	public void boardUpdateTest() {
//		BoardDTO dto = new BoardDTO();
//		dto.setBno(1L);
//		dto.setBtitle("������ �����Դϴ�.");
//		dto.setBcontent("������ �����Դϴ�.");
//		
//		boardMapper.update(dto);
//	}

//	//@Test
//	public void update() {
//		BoardDTO dto = new BoardDTO();
//		dto.setBno(1L);
//		dto.setBtitle("��������");
//		dto.setBcontent("��������");
//		dto.setBwriter("������");
//		boardMapper.update(dto);
//		
//		System.out.println(dto);
//	}
//	
//	//@Test
//	public void delete() {
//		boardMapper.delete(4L);
//	}
	
	
//	@Test
//	public void pagingTest() {
//		Criteria cri =  new Criteria();
//		cri.setPageNum(10);
//		cri.setAmount(20);
//		
//		List<BoardDTO> list = boardMapper.getListPaging(cri);
//		list.forEach(i->System.out.println(i));
//	}

}
