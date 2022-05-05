package com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.serviceImpl;

import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.dao.AuthorityRepository;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.Authority;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.AuthorityService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorityServiceImpl implements AuthorityService {

    private AuthorityRepository authorityRepository;
    public AuthorityServiceImpl(AuthorityRepository theAuthorityRepository){
        authorityRepository=theAuthorityRepository;
    }
    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }



    @Override
    public Authority findByUsername(String username) {
        return authorityRepository.findByUsername(username);
    }

    @Override
    public void save(Authority theAuthority) {
        authorityRepository.save(theAuthority);
    }

    @Override
    public void deleteByUsername(String username) {

        authorityRepository.deleteByUsername(username);
    }
}
