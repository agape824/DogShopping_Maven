package com.company.DogShopping_Maven.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.DogShopping_Maven.dao.DogDAO;
import com.company.DogShopping_Maven.vo.Dog;

@Service
public class DogRegistService {
	
	@Autowired
	private DogDAO dogDAO;
	
	public boolean registDog(Dog dog) {
		
		boolean isRegistSuccess = false;		
		int insertCount = dogDAO.insertDog(dog);
		
		if(insertCount>0){
			isRegistSuccess=true;
		}
		
		return isRegistSuccess;
		
	}

}
