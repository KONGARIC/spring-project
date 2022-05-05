package com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service;


import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.Vendor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface VendorService {

	public List<Vendor> findAll();

	
	public Vendor findById(int theId);
	
	public void save(Vendor theVendor);
	
	public void deleteById(int theId);


	
}
