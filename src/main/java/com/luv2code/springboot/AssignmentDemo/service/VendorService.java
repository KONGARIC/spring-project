package com.luv2code.springboot.AssignmentDemo.service;


import com.luv2code.springboot.AssignmentDemo.entity.Vendor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface VendorService {

	public List<Vendor> findAll();
	//public List<Vendor> findAllByVendorId(int vendor_id);
	
	public Vendor findById(int theId);
	
	public void save(Vendor theVendor);
	
	public void deleteById(int theId);


	
}
