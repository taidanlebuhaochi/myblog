package com.houmingjian.blog.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常统一处理
 * @author Ming
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		//handler是处理器是配置要执行handler的对象
		String msg = null;
		if (ex instanceof CustomException){
			msg = ((CustomException)ex).getMsg();
		}else{
			msg = "未知错误";
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", msg);
		modelAndView.setViewName("info/error");
		return modelAndView;
	}
	
}
