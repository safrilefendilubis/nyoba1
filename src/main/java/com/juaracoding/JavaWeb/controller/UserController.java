package com.juaracoding.JavaWeb.controller;/*
IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author User a.k.a. Safril Efendi Lubis
Java Developer
Created on 2/27/2023 9:36 PM
@Last Modified 2/27/2023 9:36 PM
Version 1.1
*/
import com.juaracoding.JavaWeb.model.User;
import com.juaracoding.JavaWeb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/authz")
public class UserController {

    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;
    private Map<String,Object> objectMapper = new HashMap<String,Object>();

    private List<User> lsCPUpload = new ArrayList<User>();

    private String [] strExceptionArr = new String[2];

    @Autowired
    public UserController(UserService userService) {
        strExceptionArr[0]="UserController";
        this.userService = userService;
    }

    @PostMapping("/v1/register")
    public String doRegis(@ModelAttribute("users") User userz,Model model) throws Exception {
        String strEmail = userService.checkRegis(userz);

        if(!strEmail.equals(""))
        {
            model.addAttribute("verifyEmail",strEmail);
            return "verfikasi";
//            return "redirect:/api/check/verify";
        }
        else
        {
            return "redirect:/api/check/signin";
        }
    }

//    @PostMapping("/v1/verify")
//    public String verifyRegis()
//    {
//
//
//    }
}