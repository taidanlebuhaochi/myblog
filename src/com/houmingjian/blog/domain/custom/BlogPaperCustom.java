package com.houmingjian.blog.domain.custom;

import java.util.List;

import com.houmingjian.blog.domain.BlogPaper;
import com.houmingjian.blog.domain.BlogTag;
import com.houmingjian.blog.util.Time;

public class BlogPaperCustom extends BlogPaper{
	/*多久之前发布的文章*/
	String timeAgo = null;
	/*tag实体类*/
	BlogTag tagDomain = null;
	
	public String getTimeAgo() {
		return Time.getTimeAgo(super.getCreatetime());
	}

	public void setTimeAgo(String timeAgo) {
		this.timeAgo = timeAgo;
	}

	public BlogTag getTagDomain() {
		return tagDomain;
	}

	public void setTagDomain(BlogTag tagDomain) {
		this.tagDomain = tagDomain;
	}
}
