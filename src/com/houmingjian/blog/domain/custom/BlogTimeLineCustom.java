package com.houmingjian.blog.domain.custom;

import java.util.ArrayList;
import java.util.List;

import com.houmingjian.blog.domain.BlogTimeLine;

public class BlogTimeLineCustom{
	private int year;
	private List<BlogTimeLine> blogTimeLineList;
	
	public BlogTimeLineCustom() {
		this.blogTimeLineList = new ArrayList<BlogTimeLine>();
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<BlogTimeLine> getBlogTimeLineList() {
		return blogTimeLineList;
	}
	public void setBlogTimeLineList(List<BlogTimeLine> blogTimeLineList) {
		this.blogTimeLineList = blogTimeLineList;
	}
	
	@Override
	public String toString() {
		return "BlogTimeLineCustom [year=" + year + ", blogTimeLineList="
				+ blogTimeLineList + "]";
	}
	
	
}
