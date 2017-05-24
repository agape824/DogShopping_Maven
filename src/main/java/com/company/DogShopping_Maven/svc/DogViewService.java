package com.company.DogShopping_Maven.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.DogShopping_Maven.dao.DogDAO;
import com.company.DogShopping_Maven.vo.Dog;

@Service
public class DogViewService {
	
	@Autowired
	private DogDAO dogDAO;
	
	public Dog getDogView(int id) {	
		
		Dog dog = null;
		int updateCount = dogDAO.updateReadCount(id);
		
		if(updateCount > 0){
		dog = dogDAO.selectDog(id);
		}
		
		return dog;
		
	}

}
