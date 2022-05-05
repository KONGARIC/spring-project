package com.luv2code.springboot.AssignmentDemo.service.serviceImpl;

import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.dao.AuthorityRepository;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.Authority;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.serviceImpl.AuthorityServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AuthorityServiceImplTest {
    @Mock
    private AuthorityRepository authorityRepository;

    @InjectMocks
    private AuthorityServiceImpl authorityService;

    @Test
    void findAll() {
        authorityService = new AuthorityServiceImpl(authorityRepository);

        List<Authority> authorityList = new ArrayList<>();

        Authority authority1=new Authority("cs","ROLE_VENDOR");
        Authority authority2=new Authority("chan","ROLE_ADMIN");
        authorityList.add(authority1);
        authorityList.add(authority2);


        when(authorityRepository.findAll()).thenReturn(authorityList);

        List<Authority> expectedList = authorityService.findAll();

        assertEquals(2, expectedList.size());
    }

    @Test
    void findByUsername(){

        when(authorityRepository.findByUsername("chan")).thenReturn(new Authority( "chan", "ROLE_ADMIN"));
        Authority authority = authorityService.findByUsername("chan");

        Assertions.assertThat(authority.getUsername()).isEqualTo("chan");
        Assertions.assertThat(authority.getAuthority()).isEqualTo("ROLE_ADMIN");

        verify(authorityRepository,times(1)).findByUsername("chan");

    }

    @Test
    void save() {
        Authority authority = new Authority("cs","ROLE_VENDOR");
        authorityService.save(authority);
        verify(authorityRepository).save(authority);
    }

    @Test
    void deleteByUsername(){
        authorityService.deleteByUsername("chan");
        verify(authorityRepository).deleteByUsername("chan");
    }

}
