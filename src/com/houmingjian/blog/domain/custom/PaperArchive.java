package com.houmingjian.blog.domain.custom;

import java.util.ArrayList;
import java.util.List;
import com.houmingjian.blog.domain.custom.Month;;
public class PaperArchive {
	int year;
	List<Month> months;
	
	public PaperArchive(){
		
	}
	
	public PaperArchive(int year){
		this.year = year;
		months = new ArrayList<Month>();
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Month> getMonths() {
		return months;
	}

	public void setMonths(List<Month> months) {
		this.months = months;
	}

	public void addMonth(int month, int count){
		Month m = new Month();
		m.month = month;
		m.count = count;
		
		this.months.add(m);
	}

}
