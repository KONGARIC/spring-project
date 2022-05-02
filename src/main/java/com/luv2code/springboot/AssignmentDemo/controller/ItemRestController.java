package com.luv2code.springboot.AssignmentDemo.controller;

import com.luv2code.springboot.AssignmentDemo.entity.Item;
import com.luv2code.springboot.AssignmentDemo.entity.Vendor;
import com.luv2code.springboot.AssignmentDemo.service.ItemService;
import com.luv2code.springboot.AssignmentDemo.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ItemRestController {

    /*private List<Item> theItems;
    @PostConstruct
    private void loadData(){
        Item item1=new Item(1,"Amul Milk","Single Toned Milk",11,23);
        Item item2=new Item(2,"santoor soap","Aloe Fresh Soap with Aloe Vera and Lime for Radiant Looking Skin, 125g",11,23);

        theItems=new ArrayList<>();
        theItems.add(item2);
        theItems.add(item1);

    }*/

    private ItemService itemService;
    private VendorService vendorService;


    @Autowired
    public ItemRestController(ItemService theItemService,VendorService theVendorService){
        itemService=theItemService;
        vendorService=theVendorService;
    }




    @GetMapping("/list")
    public String listItems(Model theModel){
        List<Item> itemList=itemService.findAll();

        theModel.addAttribute("items",itemList);
        return "list-items";
    }
   @GetMapping("/listByVendorId")
   public String listItems(@RequestParam("vendorId") int theId,Model theModel){
       List<Item> itemList=itemService.findAllByVendorId(theId);
       Vendor theVendor=vendorService.findById(theId);
       theModel.addAttribute("items",itemList);
       theModel.addAttribute("vendorId",theId);
       theModel.addAttribute("username",theVendor.getFirstName());
       return "list-items";
   }



    @GetMapping("/showFormForAdd")
    public String showFormForAdd(@RequestParam("vendorId") int vendorId,Model theModel){
        Item theItem=new Item();


        Vendor theVendor=vendorService.findById(vendorId);

        theItem.setVendorId(vendorId);

        theModel.addAttribute("item",theItem);
        theModel.addAttribute("vendorId",vendorId);


        System.out.println(theVendor);
        return "item-form";
    }
    @PostMapping("/save")
    public String saveItem(@Valid @ModelAttribute("item") Item theItem,@Valid @ModelAttribute("vendorId") int vendorId, BindingResult theBindingResult, Model theModel){
        if (theBindingResult.hasErrors()) {
            return "item-form";
        }
        else{
            theItem.setVendorId(vendorId);
            itemService.save(theItem);
            theModel.addAttribute("item",theItem);
            theModel.addAttribute("vendorId",vendorId);

            return "confermation";
        }

    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("vendorId") int vendorId,@RequestParam("itemId") int theId,Model theModel){
        Item theItem=itemService.findById(theId);
        theItem.setVendorId(vendorId);
        theModel.addAttribute("vendorId",vendorId);
        theModel.addAttribute("item",theItem);
        return "item-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("vendorId") int vendorId,@RequestParam("itemId") int theId,Model theModel){
       // int vendorId=itemService.findVendorIdByItemId(theId);
        itemService.deleteById(theId);

        theModel.addAttribute("vendorId",vendorId);
        return "deleteConfermation";
    }

    @GetMapping("/confermation")
    public String confermation(@RequestParam("vendorId") int theId,Model theModel){
        theModel.addAttribute("vendorId",theId);

        return "confermation";
    }
    @GetMapping("/deleteConfermation")
    public String deleteConfermation(@RequestParam("vendorId") int theId,Model theModel){
        theModel.addAttribute("vendorId",theId);

        return "deleteConfermation";
    }

}
