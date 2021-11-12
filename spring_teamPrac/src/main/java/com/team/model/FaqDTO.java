package com.team.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class FaqDTO {
	private int faq_no;
	private String faq_title;
	private String faq_content;
	private int faq_viewCnt;
	private Timestamp faq_regdate;
}
