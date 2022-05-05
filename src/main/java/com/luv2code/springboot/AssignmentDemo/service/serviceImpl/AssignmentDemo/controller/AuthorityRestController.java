package com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.controller;

import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.Authority;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
@Controller
public class AuthorityRestController {
    private AuthorityService authorityService;
    @Autowired
    public AuthorityRestController(AuthorityService theAuthorityService){
        authorityService=theAuthorityService;
    }

    @GetMapping("/showFormForAuthorityAdd")
    public String showFormForAuthorityAdd(@RequestParam("vendorId") int theId,@RequestParam("username") String username, Model theModel){
        Authority theAuthority=authorityService.findByUsername(username);
        if(theAuthority==null){
            theAuthority=new Authority();
        }

        theAuthority.setUsername(username);
        theAuthority.setId(theId);
        theModel.addAttribute("user",theAuthority);
        return "authority-form";
    }
    @PostMapping("/authoritysave")
    public String saveAuthority(@Valid @ModelAttribute("user") Authority theAuthority, BindingResult theBindingResult, Model theModel,@RequestParam("vendorId") int theId,  @RequestParam("username") String username){
        if (theBindingResult.hasErrors()) {


            theAuthority.setUsername(username);


            return "authority-form";
        } else {


            authorityService.save(theAuthority);
            theModel.addAttribute("user",theAuthority);


            return "redirect:/vendors";
        }
    }
}
