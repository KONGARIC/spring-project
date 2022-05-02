package com.luv2code.springboot.AssignmentDemo.controller;

import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/")
    public String index() {
        //theModel.addAttribute("id",theId);
        return "homepage";
    }

    @GetMapping("/loginPage")
    public String loginPage(){
        return "login-page";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }
    @GetMapping("/homepage")
    public String homepage(@RequestParam("id") int theId, Model theModel){
        theModel.addAttribute("id",theId);
        return "homepage";
    }

}
