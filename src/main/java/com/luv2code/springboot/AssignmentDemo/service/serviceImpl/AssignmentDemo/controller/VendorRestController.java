package com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.controller;

import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.Vendor;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.AuthorityService;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.ItemService;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.UserService;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.VendorService;
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
