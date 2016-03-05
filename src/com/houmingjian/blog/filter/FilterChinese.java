package com.houmingjian.blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class FilterChinese extends HttpServlet implements Filter {

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 顺序：客户端页面-->web服务器-->过滤器链-->actionservlet-->actionForm-->action
		arg0.setCharacterEncoding("utf-8");// 设置接收编码
		// System.out.println("filter...");
		arg2.doFilter(arg0, arg1);//
		arg1.setContentType("text/html;charset=utf-8");// 设置返回属性
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
