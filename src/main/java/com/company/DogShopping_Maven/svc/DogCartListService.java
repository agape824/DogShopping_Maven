package com.company.DogShopping_Maven.svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import com.company.DogShopping_Maven.vo.Cart;

@Service
public class DogCartListService {
	
	public ArrayList<Cart> getCartList(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		return cartList;
		
	}
	
}
