package com.luv2code.springboot.AssignmentDemo.service.serviceImpl;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.dao.UserRepository;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.User;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.serviceImpl.UserServiceImpl;
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
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void findAll() {
        userService = new UserServiceImpl(userRepository);
        List<User> userList = new ArrayList<>();
        User user1=new User("chan","1234",1,1);
        User user2=new User("cs","1234",2,1);
        userList.add(user1);
        userList.add(user2);
        when(userRepository.findAll()).thenReturn(userList);
        List<User> expectedList = userService.findAll();
        assertEquals(2, expectedList.size());
    }

    @Test
    void findByUsername(){

        when(userRepository.findByUsername("chan")).thenReturn(new User("chan","1234",1,1));
        User user=userService.findByUsername("chan");
        Assertions.assertThat(user.getUsername()).isEqualTo("chan");
        Assertions.assertThat(user.getPassword()).isEqualTo("1234");
    }

    @Test
    void save() {
        User user1=new User("chan","1234",1,1);
        userService.save(user1);
        verify(userRepository).save(user1);
    }
    @Test
    void deleteById(){
        userService.deleteById("1");
        verify(userRepository).deleteById("1");
    }
}
