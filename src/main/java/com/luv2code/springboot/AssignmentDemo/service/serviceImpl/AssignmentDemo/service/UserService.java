package com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service;

import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> findAll();


    public User findByUsername(String theId);

    public void save(User theUser);

    public void deleteById(String theId);
}
