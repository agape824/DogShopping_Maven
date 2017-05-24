package com.company.DogShopping_Maven.svc;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.DogShopping_Maven.dao.DogDAO;
import com.company.DogShopping_Maven.vo.Dog;

@Service
public class DogListService {
	
	@Autowired
	private DogDAO dogDAO;
	
	public ArrayList<Dog> getDogList() {
		
		return dogDAO.selectDogList();
		
	}
	
}