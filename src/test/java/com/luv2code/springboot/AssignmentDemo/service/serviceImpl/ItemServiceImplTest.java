package com.luv2code.springboot.AssignmentDemo.service.serviceImpl;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.dao.ItemRepository;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.Item;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.serviceImpl.ItemServiceImpl;
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
public class ItemServiceImplTest {
    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImpl itemService;

    @Test
    void findAll() {
        itemService = new ItemServiceImpl(itemRepository);

        List<Item> itemList = new ArrayList<>();

        Item item1=new Item("Santoor soap","100gm",2,20);
        Item item2=new Item("Rin soap","100gm",2,20);


        itemList.add(item1);
        itemList.add(item2);


        when(itemRepository.findAll()).thenReturn(itemList);

        List<Item> expectedList = itemRepository.findAll();

        assertEquals(2, expectedList.size());
    }

    @Test
    void findByVendorId(){
        itemService = new ItemServiceImpl(itemRepository);
        List<Item> itemList = new ArrayList<>();
        Item item1=new Item("Santoor soap","100gm",2,20,1);
        itemList.add(item1);
        when(itemRepository.findItemByVendorId(1)).thenReturn(itemList);
        List<Item> item = itemService.findAllByVendorId(1);

        assertEquals(1, item.size());

    }
    @Test
    void findById(){

        when(itemRepository.findById(1)).thenReturn(Optional.of(new Item(1, "Santoor soap", "100gm", 2, 20)));
        Item item=itemService.findById(1);
        Assertions.assertThat(item.getItemName()).isEqualTo("Santoor soap");
        Assertions.assertThat(item.getItemDiscription()).isEqualTo("100gm");


    }


    @Test
    void save() {
        Item item1=new Item("Santoor soap","100gm",2,20,1);
        itemService.save(item1);
        verify(itemRepository).save(item1);
    }

    @Test
    void deleteById(){
        itemService.deleteById(1);
        verify(itemRepository).deleteById(1);
    }
    @Test
    void deleteItemsByVendorId(){
        itemService.deleteItemsByVendorId(1);
        verify(itemRepository).deleteItemsByVendorId(1);
    }


}
