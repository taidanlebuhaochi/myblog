package com.houmingjian.blog.domain.query;

import com.houmingjian.blog.domain.BlogPaper;
import com.houmingjian.blog.domain.Page;

public class BlogPaperQueryVo extends BlogPaper{
	Page page;

	String day;
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
