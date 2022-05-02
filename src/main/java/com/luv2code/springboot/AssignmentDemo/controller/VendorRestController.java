package com.luv2code.springboot.AssignmentDemo.controller;

import com.luv2code.springboot.AssignmentDemo.entity.Item;
import com.luv2code.springboot.AssignmentDemo.entity.User;
import com.luv2code.springboot.AssignmentDemo.entity.Vendor;
import com.luv2code.springboot.AssignmentDemo.exception.VendorException;
import com.luv2code.springboot.AssignmentDemo.service.AuthorityService;
import com.luv2code.springboot.AssignmentDemo.service.ItemService;
import com.luv2code.springboot.AssignmentDemo.service.UserService;
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
public class VendorRestController {

    /*private List<Item> theItems;
    @PostConstruct
    private void loadData(){
        Item item1=new Item(1,"Amul Milk","Single Toned Milk",11,23);
        Item item2=new Item(2,"santoor soap","Aloe Fresh Soap with Aloe Vera and Lime for Radiant Looking Skin, 125g",11,23);

        theItems=new ArrayList<>();
        theItems.add(item2);
        theItems.add(item1);

    }*/

    private VendorService vendorService;
    private UserService userService;

    private AuthorityService authorityService;
    private ItemService itemService;

    @Autowired
    public VendorRestController(VendorService theVendorService,UserService theUserService,AuthorityService theAuthorityService,ItemService theItemService){
        vendorService=theVendorService;
        userService=theUserService;
        authorityService=theAuthorityService;
        itemService=theItemService;
    }
    @GetMapping("/vendors")
    public String listItems(Model theModel){
        List<Vendor> vendorsList=vendorService.findAll();

        theModel.addAttribute("vendors",vendorsList);
        return "list-vendors";
    }



    @GetMapping("/showFormForVendorAdd")
    public String showFormForAdd(Model theModel){
        Vendor theVendor=new Vendor();
        theModel.addAttribute("vendor",theVendor);
        return "vendor-form";
    }
    @PostMapping("/vendorsave")
    public String saveItem(@Valid @ModelAttribute("vendor") Vendor theVendor, BindingResult theBindingResult,Model theModel){
        if (theBindingResult.hasErrors()) {

            //theModel.addAttribute("vendor", new Vendor());

            return "vendor-form";
        } else {
            vendorService.save(theVendor);
            theModel.addAttribute("vendor",theVendor);


            return "redirect:/vendors";
        }
    }
    @GetMapping("/showFormForVendorUpdate")
    public String showFormForUpdate(@RequestParam("vendorId") int theId,Model theModel){
        Vendor theVendor=vendorService.findById(theId);
        theModel.addAttribute("vendor",theVendor);
        return "vendor-form";
    }





    @GetMapping("/deleteVendor")
    public String delete(@RequestParam("vendorId") int theId){
        Vendor vendor=vendorService.findById(theId);
        userService.deleteById(vendor.getFirstName());
        authorityService.deleteByUsername(vendor.getFirstName());
        itemService.deleteItemsByVendorId(theId);
        vendorService.deleteById(theId);

        return "redirect:/vendors";
    }

}
