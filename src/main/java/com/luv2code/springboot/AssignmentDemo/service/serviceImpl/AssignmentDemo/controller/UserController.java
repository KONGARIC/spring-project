package com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.controller;


import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity.User;
import com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.service.UserService;
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
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService theUserService){
        userService=theUserService;
    }

    @GetMapping("/showHome")
    public String showHome(@RequestParam("username") String username,Model theModel){
        User theUser=userService.findByUsername(username);
        if(theUser!=null){
            theModel.addAttribute("user",theUser);
            theModel.addAttribute("vendorId",theUser.getId());
            return "vendor-home";

        }



        return "user-form";
    }

    @GetMapping("/showFormForUserAdd")
    public String showFormForUserAdd(@RequestParam("vendorId") int theId,@RequestParam("username") String username,Model theModel){
        User theUser=userService.findByUsername(username);
        if(theUser==null){
            theUser=new User();
        }
        theUser.setId(theId);
        theUser.setUsername(username);
        theModel.addAttribute("user",theUser);
        return "user-form";
    }
    @PostMapping("/usersave")
    public String saveUser(@Valid @ModelAttribute("user") User theUser, BindingResult theBindingResult, Model theModel,@RequestParam("vendorId") int theId,@RequestParam("username") String username){
        if (theBindingResult.hasErrors()) {

            theUser.setId(theId);
            theUser.setUsername(username+theId);


            return "user-form";
        } else {

            theUser.setId(theId);
            userService.save(theUser);
            theModel.addAttribute("user",theUser);



            return "redirect:/vendors";
        }
    }

    @PostMapping("/usersaveByvendor")
    public String usersaveByvendor(@Valid @ModelAttribute("user") User theUser, BindingResult theBindingResult, Model theModel,@RequestParam("vendorId") int theId,@RequestParam("username") String username){
        if (theBindingResult.hasErrors()) {

            theUser.setId(theId);
            theUser.setUsername(username+theId);


            return "user-form";
        } else {

            theUser.setId(theId);
            userService.save(theUser);
            theModel.addAttribute("user",theUser);
            theModel.addAttribute("vendorId",theId);
            theModel.addAttribute("username",theUser.getUsername());


            return "vendor-home";
        }
    }

}
