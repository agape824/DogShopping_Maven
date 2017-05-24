package com.company.DogShopping_Maven.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.company.DogShopping_Maven.svc.DogCartQtyUpService;

@Controller
public class DogCartQtyUpController{
	
	@Autowired
	private DogCartQtyUpService dogCartQtyUpService;
	
	@RequestMapping("/dogCartQtyUp.dog")
	public String execute(HttpServletRequest request) throws Exception {
	
		String kind = request.getParameter("kind");
		dogCartQtyUpService.upCartQty(kind,request);
		return "dogCartList.dog";
		
	}

}
