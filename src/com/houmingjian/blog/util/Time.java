package com.houmingjian.blog.util;

import java.util.Calendar;
import java.util.Date;

public class Time {
	private static long minute = 60000L;
	private static long hour = 3600000L;
	private static long day = 86400000L;
	private static long month = 2592000000L;
	private static long year = 2592000000L * 12;
	
	public static String getTimeAgo(Date date){
		if (date == null){
			return null;
		}
		
		long curTime = new Date().getTime();
		long agoTime = date.getTime();
		long diff = curTime -  agoTime;
		
		String r = "";
		if (diff > year){
			r = (diff / year) + " Years Ago";
		}else if (diff > month){
			r = (diff / month) + " Months Ago";
		}else if (diff > day){
			r = (diff / day) + " Days Ago";
		}else if (diff > hour){
			r = (diff / hour) + " Hours Ago";
		}else if (diff > minute){
			r = (diff / minute) + " Minute Ago";
		}else{
			r = " Just";
		}
		return r;
	}
	
	public static int getBuiltDay(){
		Calendar curCal = Calendar.getInstance();
		Calendar endCal = Calendar.getInstance();
		endCal.set(2015, 9, 1);
		
		long nTime = curCal.getTimeInMillis() - endCal.getTimeInMillis();
		
		int nDay = (int) (nTime / day);
		
		return nDay;
	}
	
}
