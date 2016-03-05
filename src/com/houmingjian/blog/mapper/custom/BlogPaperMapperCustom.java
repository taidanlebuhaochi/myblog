package com.houmingjian.blog.mapper.custom;

import java.util.Date;
import java.util.List;

import com.houmingjian.blog.domain.Page;
import com.houmingjian.blog.domain.custom.BlogPaperCustom;
import com.houmingjian.blog.domain.query.BlogPaperQueryVo;

public interface BlogPaperMapperCustom {
	public List<BlogPaperCustom> getLimitBlogPaper(Page page);
	
	public BlogPaperCustom getBlogPaperById(int id);
	
	public int getBlogPaperCount();
	
	public List<BlogPaperCustom> getLimitBlogByTag(BlogPaperQueryVo queryVo);
	
	public Date getLastPaperTime();
	
	public int getMonthPaperCount(String day);
	
	public List<BlogPaperCustom> getLimitBlogByHistory(BlogPaperQueryVo queryVo);
	
	public int getBlogPaperCountByTag(int tagId);
	
	
}
