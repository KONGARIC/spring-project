package com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service;

import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.Item;
import org.springframework.stereotype.Service;


import java.util.List;
@Service

public interface ItemService {

	public List<Item> findAll();
	public List<Item> findAllByVendorId(int vendor_id);


	
	public Item findById(int theId);
	
	public void save(Item theItem);
	
	public void deleteById(int theId);

	public void deleteItemsByVendorId(int vendorId);




	
}
