package com.houmingjian.blog.service;

import java.util.List;

import com.houmingjian.blog.domain.BlogPaper;
import com.houmingjian.blog.domain.BlogTag;
import com.houmingjian.blog.domain.BlogTimeLine;
import com.houmingjian.blog.domain.BlogUser;
import com.houmingjian.blog.domain.Page;
import com.houmingjian.blog.domain.custom.BlogPaperCustom;
import com.houmingjian.blog.domain.custom.BlogTimeLineCustom;
import com.houmingjian.blog.domain.custom.PaperArchive;

public interface BlogServiceInter {
	public void saveBlog(BlogPaper blogPaper);
	
	public List<BlogTag> getAllTag();
	
	public Page getLimitBlogPaper(Page page);
	
	public BlogPaper getBlogPaper(int id);
	
	public void updateBlogTagCount(int id);
	
	public BlogPaperCustom getBlogPaperById(int id);
	
	public BlogUser getUserByEmailPassword(BlogUser user);
	
	public Page getLimitBlogByTag(int tagId,Page page);
	
	public BlogTag getBlogTagById(int id);
	
	/*博客归档数据*/
	public List<PaperArchive> getBlogPaperDate();
	
	public Page getLimitBlogPaperByHistory(String queryDate,Page page);
	
	/*TimeLine*/
	public void addTimeLine(BlogTimeLine blogTimeLine);
	
	public List<BlogTimeLineCustom> loadAllBlogTimeLine();
}
