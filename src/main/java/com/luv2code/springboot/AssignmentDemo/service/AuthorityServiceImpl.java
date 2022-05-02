package com.luv2code.springboot.AssignmentDemo.service;

import com.luv2code.springboot.AssignmentDemo.dao.AuthorityRepository;
import com.luv2code.springboot.AssignmentDemo.entity.Authority;
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
    public List<Authority> findAllByAuthorityId(int authority_id) {
        return null;
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
