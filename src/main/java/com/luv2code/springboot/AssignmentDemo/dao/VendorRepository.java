package com.luv2code.springboot.AssignmentDemo.dao;

import com.luv2code.springboot.AssignmentDemo.entity.Item;
import com.luv2code.springboot.AssignmentDemo.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

	// that's it ... no need to write any code LOL!
    //public List<Item> findAllByOrderByItemNameAsc();
    /*@Query("select i from Item i where i.object = :vendor_id")
    public List<Item> findItemByObjectId(int vendor_id);
    */

    //public List<Item> findItemByVendorId(int vendor_id);
	
}
