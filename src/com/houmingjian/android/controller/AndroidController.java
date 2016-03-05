package com.houmingjian.android.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.houmingjian.android.util.CityUtil;

@Controller
public class AndroidController {
	@RequestMapping(value="/data/{resourceName}", method= RequestMethod.GET , produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getResourceName(Model model, @PathVariable String resourceName){
		String result = CityUtil.getProvince(resourceName);
		return result;
	}
}
