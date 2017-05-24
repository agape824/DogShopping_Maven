package com.company.DogShopping_Maven.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.company.DogShopping_Maven.svc.DogListService;
import com.company.DogShopping_Maven.vo.Dog;

@Controller
public class DogListController {
	
	@Autowired
	private DogListService dogListService;
	
	@RequestMapping("/dogList.dog")	
	public ModelAndView execute(HttpServletRequest request) throws Exception {
		ArrayList<String> todayImageList = new ArrayList<String>();
		Cookie[] cookieArray = request.getCookies();
		
		if(cookieArray != null){
			for (int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().startsWith("today")){
					todayImageList.add(cookieArray[i].getValue());
				}
			}
		}
		
		ArrayList<Dog> dogList = dogListService.getDogList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dogList", dogList);
		modelAndView.addObject("todayImageList", todayImageList);
		modelAndView.setViewName("dogList");
		//modelAndView.setViewName("/dogList.jsp");
		return modelAndView;
		
	}
}
