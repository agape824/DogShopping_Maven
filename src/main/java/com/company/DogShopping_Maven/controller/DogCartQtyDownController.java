package com.company.DogShopping_Maven.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.company.DogShopping_Maven.svc.DogCartQtyDownService;

@Controller
public class DogCartQtyDownController {

	@Autowired
	private DogCartQtyDownService dogCartQtyDownService;
	
	@RequestMapping("/dogCartQtyDown.dog")
	public String execute(HttpServletRequest request) throws Exception {
		
		String kind = request.getParameter("kind");
		dogCartQtyDownService.downCartQty(kind,request);
		return "dogCartList.dog";
		
	}
	
}
