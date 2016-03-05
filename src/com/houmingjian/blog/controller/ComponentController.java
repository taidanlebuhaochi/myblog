package com.houmingjian.blog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.houmingjian.blog.domain.BlogTag;
import com.houmingjian.blog.service.BlogServiceInter;
import com.houmingjian.blog.util.Time;

@Controller
public class ComponentController{
	@Resource
	BlogServiceInter blogServiceInter;
	
	/*获取siderbar*/
	@RequestMapping("/siderbar")
	public String siderbar(Model model,HttpServletResponse res,HttpSession session){
		List<BlogTag> tags = blogServiceInter.getAllTag();
		model.addAttribute("tags",tags);
		model.addAttribute("builtDay", Time.getBuiltDay());
		model.addAttribute("allData", blogServiceInter.getBlogPaperDate());
		return "blog/siderbar";
	}
	
}
