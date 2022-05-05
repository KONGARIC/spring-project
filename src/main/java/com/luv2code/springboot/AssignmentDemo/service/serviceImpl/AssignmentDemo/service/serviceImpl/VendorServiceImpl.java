package com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.serviceImpl;

import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.dao.VendorRepository;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.Vendor;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class VendorServiceImpl implements VendorService {

	private VendorRepository vendorRepository;

	@Autowired
	public VendorServiceImpl(VendorRepository theVendorRepository) {
		vendorRepository = theVendorRepository;
	}

	@Override
	public List<Vendor> findAll() {
		return vendorRepository.findAll();
	}


	public VendorServiceImpl() {
	}

	@Override
	public Vendor findById(int theId) {
		Optional<Vendor> result = vendorRepository.findById(theId);

		Vendor theVendors = null;
		
		if (result.isPresent()) {
			theVendors = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theVendors;
	}

	@Override
	public void save(Vendor theVendor) {
		vendorRepository.save(theVendor);
	}

	@Override
	public void deleteById(int theId) {
		vendorRepository.deleteById(theId);
	}

}






