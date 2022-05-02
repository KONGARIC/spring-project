package com.luv2code.springboot.AssignmentDemo.service;

import com.luv2code.springboot.AssignmentDemo.entity.Authority;
import com.luv2code.springboot.AssignmentDemo.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AuthorityService {
    public List<Authority> findAll();
    public List<Authority> findAllByAuthorityId(int authority_id);

    //public int findVendorIdByItemId(int item_id);

    public Authority findByUsername(String username);

    public void save(Authority theAuthority);

    public void deleteByUsername(String username);
}
