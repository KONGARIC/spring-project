package com.luv2code.springboot.AssignmentDemo.service;

import com.luv2code.springboot.AssignmentDemo.dao.UserRepository;
import com.luv2code.springboot.AssignmentDemo.entity.User;
import com.luv2code.springboot.AssignmentDemo.entity.Vendor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class UserServiceImpl implements UserService{
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
       // Optional<User> result = Optional.ofNullable(userRepository.findById(theId));

        User theUser = userRepository.findByUsername(theId);
        /*
        if (result.isPresent()) {
            theUsers = result.get();
        }
        else {
            // we didn't find the employee
            theUsers=new User();
        }*/
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
