package com.houmingjian.blog.test;

import java.util.Calendar;
import java.util.Date;

import com.houmingjian.blog.util.Time;


public class CommonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time time = new Time();
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		
		calendar.set(2015, 9, 2);
		date = calendar.getTime();
		
		System.out.println(Time.getTimeAgo(date));
	}

}
