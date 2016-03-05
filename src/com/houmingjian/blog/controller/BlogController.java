package com.houmingjian.blog.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.houmingjian.blog.domain.BlogPaper;
import com.houmingjian.blog.domain.BlogTag;
import com.houmingjian.blog.domain.BlogTimeLine;
import com.houmingjian.blog.domain.BlogUser;
import com.houmingjian.blog.domain.Page;
import com.houmingjian.blog.domain.custom.BlogPaperCustom;
import com.houmingjian.blog.exception.CustomException;
import com.houmingjian.blog.service.BlogServiceInter;

@Controller
public class BlogController {
	@Resource
	BlogServiceInter blogServiceInter;
	
	/*主页*/
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String blog(Model model, @RequestParam(value="pageNo", defaultValue="1")int pageNo,
									@RequestParam(value="type", defaultValue="all")String type, 
									@RequestParam(value="detail", defaultValue="0")String detail){
		try{
			Page page = null;
			//所有文章,tag,文章归档
			if (type.equals("all")){
				page = blogServiceInter.getLimitBlogPaper(new Page(pageNo));
				model.addAttribute("type","all");
			}else if (type.equals("tag")){
				page = blogServiceInter.getLimitBlogByTag(Integer.parseInt(detail), new Page(pageNo));
				model.addAttribute("type","tag");
				model.addAttribute("tag", blogServiceInter.getBlogTagById(Integer.parseInt(detail)));
			}else if (type.equals("history")){
				page = blogServiceInter.getLimitBlogPaperByHistory(detail, new Page(pageNo));
				model.addAttribute("type","history");
				model.addAttribute("history",detail);
			}
			model.addAttribute("page",page);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "blog/home";
	}
	
	/*获取某标签下的文章*/
	@RequestMapping(value="/blog",method=RequestMethod.GET)
	public String getLimitPaper(Model model,int tagId, @RequestParam(value="pageNo", defaultValue="1")int pageNo){
		Page page = blogServiceInter.getLimitBlogByTag(tagId, new Page(pageNo));
		model.addAttribute("page",page);
		model.addAttribute("tag", blogServiceInter.getBlogTagById(tagId));
		return "blog/paper_tag";
	}
	
	/*Markdown页面*/
	@RequestMapping("/markdown")
	public String markDownBlogPage(Model model){
		List<BlogTag> tags = blogServiceInter.getAllTag();
		model.addAttribute("tags",tags);
		return "blog/markdown";
	}
	
	/*新增博客页面*/
	@RequestMapping(value="/blog",method=RequestMethod.POST)
	public String addBlog(Model model, BlogPaper blogPaper){
		try{
			blogPaper.setCreatetime(new Date());
			
			//保存和更新
			blogServiceInter.saveBlog(blogPaper);
			blogServiceInter.updateBlogTagCount(blogPaper.getTag());
		}catch(Exception e){
			e.printStackTrace();
			new CustomException("新建随笔出错");
		}
		return "redirect:/home";
	}
	
	/*----------------------标签-----------------------------------*/
	@RequestMapping("/tag")
	public String getAllTag(Model model){
		List<BlogTag> tags = blogServiceInter.getAllTag();
		model.addAttribute("tags",tags);
		return "blog/siderbar";
	}
	
	/*----------------------文章详情----------------------------------*/
	@RequestMapping(value="/blog/p/{id}",method=RequestMethod.GET)
	public String getPaper(Model model,@PathVariable("id") int id){
		try{
			BlogPaper paper = blogServiceInter.getBlogPaperById(id);
			model.addAttribute("paper",paper);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "blog/paper";
	}

	/*----------------------登录页----------------------------------*/
	/*登录页*/
	@RequestMapping(value="/login")
	public String login(Model model,String msg){
		model.addAttribute("msg",msg);
		return "blog/login";
	}
	
	@RequestMapping(value="/login/account")
	public String getUserByEmailPassword(HttpSession session ,Model model,BlogUser user){
		try{
			 BlogUser blogUser = blogServiceInter.getUserByEmailPassword(user);
			 if (blogUser == null){
				 model.addAttribute("msg","登录失败");
				 return "redirect:/login";
			 }else{
				 session.setAttribute("user", blogUser);
				 return "redirect:/home";
			 }
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/user/out")
	public String loginOut(HttpSession session,Model model){
		session.removeAttribute("user");
		return "redirect:/home";
	}
	
	/*----------------------时间轴---------------------------------*/
	@RequestMapping(value="/timeline", method=RequestMethod.GET)
	public String timeLine(Model model){
		model.addAttribute("ctimelines", blogServiceInter.loadAllBlogTimeLine());
		return "blog/timeline";
	}
	
	@RequestMapping(value="/timeline", method=RequestMethod.POST)
	public String addTimeLine(Model model, BlogTimeLine blogTimeLine){
		blogServiceInter.addTimeLine(blogTimeLine);
		return "redirect:/timeline";
	}
	
}
