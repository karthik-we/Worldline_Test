package com.registration.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.registration.application.entity.User;
import com.registration.application.service.UserService;
@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
    @GetMapping("/")
    public String register(Model model){
    	User user=new User();
    	model.addAttribute("user",user);
        return "register";
    }
    
    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") User user) {
    	String result="error";
    	System.out.println(user);
    	if(user.getEmail().equals(user.getCEmail)) {
    		try {
    		service.registerUser(user);
    		result="home";
    	}
    	catch(Exception e) {
    		result="error";
    	}
    }
    return result; 
	}
}