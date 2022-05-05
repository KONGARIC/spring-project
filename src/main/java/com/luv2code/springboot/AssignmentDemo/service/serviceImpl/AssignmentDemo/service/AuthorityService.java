package com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service;

import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.Authority;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AuthorityService {
    public List<Authority> findAll();




    public Authority findByUsername(String username);

    public void save(Authority theAuthority);

    public void deleteByUsername(String username);
}
