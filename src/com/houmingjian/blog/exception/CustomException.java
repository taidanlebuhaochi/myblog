package com.houmingjian.blog.exception;

/**
 * 自定义异常处理，需要抛出异常时直接抛出即可
 * @author Ming
 *
 */
public class CustomException extends Exception{
	private String msg;
	
	public CustomException(String msg){
		super(msg);
		this.setMsg(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
