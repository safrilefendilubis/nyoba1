package com.juaracoding.JavaWeb.controller;/*
IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author User a.k.a. Safril Efendi Lubis
Java Developer
Created on 2/27/2023 9:34 PM
@Last Modified 2/27/2023 9:34 PM
Version 1.1
*/
import com.juaracoding.JavaWeb.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/check")
public class CheckPageController {

    @GetMapping("/signin")
    public String pageTwo(Model model)
    {
        User users = new User();
        model.addAttribute("users",users);
        return "signin";
    }

    @GetMapping("/register")
    public String pageOne(Model model)
    {
        User users = new User();
        model.addAttribute("users",users);
        return "register";
    }

    @GetMapping("/verify")
    public String pageTwor(Model model)
    {
        model.addAttribute("email", "Paulo");
        return "verify";
    }
    @GetMapping("/index1")
    public String pageThree()
    {
        return "index_1";

    }
    @GetMapping("/styledPage")
    public String pageFour(Model model)
    {
        model.addAttribute("name", "Paulo");
        return "styledPage";
    }

    @GetMapping("/index")
    public String pageFive()
    {
        return "index";

    }



}
