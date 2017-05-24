package com.company.DogShopping_Maven.svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.DogShopping_Maven.dao.DogDAO;
import com.company.DogShopping_Maven.vo.Cart;
import com.company.DogShopping_Maven.vo.Dog;

@Service
public class DogCartAddService {
	
	@Autowired
	private DogDAO dogDAO;
	
	public Dog getCartDog(int id) {
		return dogDAO.selectDog(id);
	}

	public void addCart(HttpServletRequest request, Dog cartDog) {
		
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		if(cartList == null){
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		boolean isNewCart = true;
		//���� ��ٱ��Ͽ� ��� �׸��� ���� �߰��Ǵ� �׸������� ������ ����
		
		for (int i = 0; i < cartList.size(); i++) {
			if(cartDog.getKind().equals(cartList.get(i).getKind())){
				isNewCart = false;
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
				break;
			}
		}
		
		if(isNewCart){
			Cart cart = new Cart();
			cart.setImage(cartDog.getImage());
			cart.setKind(cartDog.getKind());
			cart.setPrice(cartDog.getPrice());
			cart.setQty(1);
			cartList.add(cart);
		}
		
	}
	
}