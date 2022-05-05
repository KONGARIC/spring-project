package com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.serviceImpl;

import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.dao.UserRepository;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.User;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository theUserRepository){
        userRepository=theUserRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String theId) {

        User theUser = userRepository.findByUsername(theId);

        if (theUser==null) {
            theUser = new User();
        }


        return theUser;
    }

    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public void deleteById(String theId) {
        userRepository.deleteById(theId);

    }
}
