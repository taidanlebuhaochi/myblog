package com.houmingjian.blog.test;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.houmingjian.blog.domain.BlogPaper;
import com.houmingjian.blog.domain.BlogTag;
import com.houmingjian.blog.domain.Page;
import com.houmingjian.blog.domain.custom.BlogPaperCustom;
import com.houmingjian.blog.mapper.BlogPaperMapper;
import com.houmingjian.blog.service.BlogServiceInter;

public class BlogTest {
	@Resource
	BlogPaperMapper blogPaperMapper;
	@Resource
	BlogServiceInter blogServiceInter;
	
	private ApplicationContext applicationContext; 
	
	@Before
	public void setup() {
		// TODO Auto-generated method stub
		applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext-*.xml");
		blogServiceInter = (BlogServiceInter) applicationContext.getBean("blogService");
	}
	
//	@Test
//	public void getAllTagTest(){
//		
//		List<BlogTag> tags = blogServiceInter.getAllTag();
//		Assert.assertNotNull(tags);
//	}
	
//	@Test
//	public void getLimitBlog(){
//		Page page = new Page();
//		page.setPageNo(2);
//		List<BlogPaperCustom> papers = blogServiceInter.getLimitBlogPaper(page);
//		System.out.println(papers.size());
////		Assert.assertNotNull(papers);
//	}
	
	@Test
	public void testGetMonthBlogCount(){
		blogServiceInter.getBlogPaperDate();
	}
	
}
