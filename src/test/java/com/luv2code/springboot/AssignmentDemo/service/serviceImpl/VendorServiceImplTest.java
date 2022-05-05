package com.luv2code.springboot.AssignmentDemo.service.serviceImpl;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.dao.UserRepository;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.dao.VendorRepository;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.Item;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.User;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.Vendor;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.serviceImpl.UserServiceImpl;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.serviceImpl.VendorServiceImpl;
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
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class VendorServiceImplTest {

    @Mock
    private VendorRepository vendorRepository;

    @InjectMocks
    private VendorServiceImpl vendorService;

    @Test
    void findAll() {
        vendorService = new VendorServiceImpl(vendorRepository);
        List<Vendor> vendorList = new ArrayList<>();

        Vendor vendor1=new Vendor("c","s","cs@gmail.com");
        Vendor vendor2=new Vendor("cc","ss","ccss@gmail.com");
        vendorList.add(vendor1);
        vendorList.add(vendor2);
        when(vendorRepository.findAll()).thenReturn(vendorList);
        List<Vendor> expectedList = vendorRepository.findAll();
        assertEquals(2, expectedList.size());
    }
    @Test
    void findById(){

        when(vendorRepository.findById(1)).thenReturn(Optional.of(new Vendor("c","s","cs@gmail.com")));
        Vendor vendor=vendorService.findById(1);
        Assertions.assertThat(vendor.getFirstName()).isEqualTo("c");
        Assertions.assertThat(vendor.getLastName()).isEqualTo("s");
        Assertions.assertThat(vendor.getEmail()).isEqualTo("cs@gmail.com");


    }

    @Test
    void save() {
        Vendor vendor1=new Vendor("c","s","cs@gmail.com");
        vendorService.save(vendor1);
        verify(vendorRepository).save(vendor1);
    }
    @Test
    void deleteById(){
        vendorService.deleteById(1);
        verify(vendorRepository).deleteById(1);
    }
}
