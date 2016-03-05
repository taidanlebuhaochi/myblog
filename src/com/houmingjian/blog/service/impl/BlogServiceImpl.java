package com.houmingjian.blog.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import com.houmingjian.blog.domain.BlogPaper;
import com.houmingjian.blog.domain.BlogTag;
import com.houmingjian.blog.domain.BlogTimeLine;
import com.houmingjian.blog.domain.BlogUser;
import com.houmingjian.blog.domain.Page;
import com.houmingjian.blog.domain.custom.BlogPaperCustom;
import com.houmingjian.blog.domain.custom.BlogTimeLineCustom;
import com.houmingjian.blog.domain.custom.PaperArchive;
import com.houmingjian.blog.domain.query.BlogPaperQueryVo;
import com.houmingjian.blog.mapper.BlogPaperMapper;
import com.houmingjian.blog.mapper.BlogTagMapper;
import com.houmingjian.blog.mapper.BlogTimeLineMapper;
import com.houmingjian.blog.mapper.custom.BlogPaperMapperCustom;
import com.houmingjian.blog.mapper.custom.BlogTagMapperCustom;
import com.houmingjian.blog.mapper.custom.BlogTimeLineMapperCustom;
import com.houmingjian.blog.mapper.custom.BlogUserMapperCustom;
import com.houmingjian.blog.service.BlogServiceInter;



public class BlogServiceImpl implements BlogServiceInter {
	@Resource
	BlogPaperMapper blogPaperMapper;
	@Resource
	BlogTagMapper blogTagMapper;
	@Resource
	BlogPaperMapperCustom blogPaperMapperCustom;
	@Resource
	BlogTagMapperCustom blogTagMapperCustom;
	@Resource
	BlogUserMapperCustom blogUserMapperCustom;
	@Resource
	BlogTimeLineMapper blogTimeLineMapper;
	@Resource
	BlogTimeLineMapperCustom blogTimeLineMapperCustom;
	/*添加blog*/
	public void saveBlog(BlogPaper blogPaper) {
		blogPaperMapper.insertSelective(blogPaper);
	}
	
	/*得到所有的tag*/
	public List<BlogTag> getAllTag(){
		return blogTagMapperCustom.getAllTag();
	}
	
	/*得到分页的博客数据*/
	public Page getLimitBlogPaper(Page page) {
		page.setTotalRecNum(blogPaperMapperCustom.getBlogPaperCount());
		page.setPageContent(blogPaperMapperCustom.getLimitBlogPaper(page));
		return page;
	}

	public BlogPaper getBlogPaper(int id) {
		return blogPaperMapper.selectByPrimaryKey(id);
	}

	public void updateBlogTagCount(int id) {
		BlogTag tag = blogTagMapper.selectByPrimaryKey(id);
		tag.setCount(tag.getCount() + 1);
		//update
		blogTagMapper.updateByPrimaryKeySelective(tag);
	}

	public BlogPaperCustom getBlogPaperById(int id) {
		return blogPaperMapperCustom.getBlogPaperById(id);
	}

	public BlogUser getUserByEmailPassword(BlogUser user) {
		return blogUserMapperCustom.getBlogUserByAcPwd(user);
	}

	public Page getLimitBlogByTag(int tagId, Page page) {
		BlogPaperQueryVo queryVo = new BlogPaperQueryVo();
		queryVo.setTag(tagId);
		queryVo.setPage(page);
		page.setTotalRecNum(blogPaperMapperCustom.getBlogPaperCountByTag(tagId));
		page.setPageContent(blogPaperMapperCustom.getLimitBlogByTag(queryVo));
		return page;
	}
	
	public BlogTag getBlogTagById(int id){
		return blogTagMapper.selectByPrimaryKey(id);
	}

	public List<PaperArchive> getBlogPaperDate() {
		Calendar curCal = Calendar.getInstance();
		Calendar lastCal = Calendar.getInstance();
		Date date = blogPaperMapperCustom.getLastPaperTime();
		lastCal.setTime(blogPaperMapperCustom.getLastPaperTime());
		
		List<PaperArchive> archives = new ArrayList<PaperArchive>();
		for (int year=curCal.get(Calendar.YEAR); year>=lastCal.get(Calendar.YEAR); year--){
			PaperArchive pa = new PaperArchive(year);
			
			int n_month;
			if (year == lastCal.get(Calendar.YEAR)){
				n_month = lastCal.get(Calendar.MONTH);
			}else{
				n_month = 1;
			}
			
			int startMonth = 12;
			if (year == lastCal.get(Calendar.YEAR) && curCal.get(Calendar.YEAR) == lastCal.get(Calendar.YEAR)){
				startMonth = curCal.get(Calendar.MONTH) + 1;
			}
			for (int month=startMonth; month>=n_month; month--){
				
				String day;
				if (month<10){
					day = year + "-0" + month;
				}else{
					day = year + "-" + month;
				}
				int count = blogPaperMapperCustom.getMonthPaperCount(day);
				if (count != 0){
					pa.addMonth(month, count);
				}
			}
			archives.add(pa);
		}
		return archives;
	}

	public Page getLimitBlogPaperByHistory(String queryDate, Page page) {
		String[] s = queryDate.split("-");
		if (Integer.parseInt(s[1]) < 10){
			s[1] = "0" + s[1];
		}
		String day = s[0] + "-" + s[1];

		
		page.setTotalRecNum(blogPaperMapperCustom.getMonthPaperCount(day));
		
		BlogPaperQueryVo vo = new BlogPaperQueryVo();
		vo.setPage(page);
		vo.setDay(day);
		page.setPageContent(blogPaperMapperCustom.getLimitBlogByHistory(vo));
		return page;
	}

	public void addTimeLine(BlogTimeLine blogTimeLine) {
		Date date = new Date();
		String year = new SimpleDateFormat("yyyy").format(date);
		
		Random random = new Random();
		blogTimeLine.setColor(Math.abs((random.nextInt()%4))+1);
		blogTimeLine.setDate(date);
		blogTimeLine.setYear(Integer.valueOf(year));
		blogTimeLineMapper.insertSelective(blogTimeLine);
	}

	public List<BlogTimeLineCustom> loadAllBlogTimeLine() {
		List<BlogTimeLine> lines = blogTimeLineMapperCustom.loadAllTimeLine();
		
		List<BlogTimeLineCustom> clines = new ArrayList<BlogTimeLineCustom>();
		
		int year = 0;
		
		BlogTimeLineCustom blogTimeLineCustom = new BlogTimeLineCustom();
		for (BlogTimeLine timeline: lines){
			int lineyear = timeline.getYear();
			// 第一次赋值
			if (year == 0){
				year = lineyear;
				blogTimeLineCustom.setYear(lineyear);
			}
			if (lineyear == year){
				blogTimeLineCustom.getBlogTimeLineList().add(timeline);
			}else {
				clines.add(blogTimeLineCustom);
				blogTimeLineCustom = new BlogTimeLineCustom();
				blogTimeLineCustom.setYear(lineyear);
				blogTimeLineCustom.getBlogTimeLineList().add(timeline);
				year = lineyear;
			}
		}
		clines.add(blogTimeLineCustom);
		
		System.out.println("123");
		return clines;
	}
	
}
