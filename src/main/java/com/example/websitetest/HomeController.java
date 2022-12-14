package com.example.websitetest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(path = "/home")
    public String homepage(){
        return "home";
    }
}
