package com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.serviceImpl;

import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.dao.ItemRepository;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.Item;

import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

	private ItemRepository itemRepository;
	
	@Autowired
	public ItemServiceImpl(ItemRepository theItemRepository) {
		itemRepository = theItemRepository;
	}
	
	@Override
	public List<Item> findAll() {
		return itemRepository.findAllByOrderByItemNameAsc();
	}
	@Override
	public List<Item> findAllByVendorId(int vendor_id) {
		return itemRepository.findItemByVendorId(vendor_id);
	}

	public ItemServiceImpl() {
	}

	@Override
	public Item findById(int theId) {
		Optional<Item> result = itemRepository.findById(theId);

		Item theItem = null;
		
		if (result.isPresent()) {
			theItem = result.get();
		}
		else {

			throw new RuntimeException("Did not find theItem- " + theId);
		}
		
		return theItem;
	}

	@Override
	public void save(Item theItem) {
		//System.out.println(theItem.getVendor());
		itemRepository.save(theItem);
	}

	@Override
	public void deleteById(int theId) {
		itemRepository.deleteById(theId);
	}

	@Override
	public void deleteItemsByVendorId(int vendorId) {
		itemRepository.deleteItemsByVendorId(vendorId);
	}



}






