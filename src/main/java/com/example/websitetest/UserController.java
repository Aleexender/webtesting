package com.example.websitetest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    private final HomeController homeController;

    public UserController(UserService userService, HomeController homeController) {
        this.userService = userService;
        this.homeController = homeController;
    }

    @GetMapping("/create")
    public String create(@RequestParam String id) {
        userService.addUserLogic(id);
        return homeController.homepage();
    }

}
