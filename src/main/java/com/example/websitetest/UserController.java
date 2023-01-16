package com.example.websitetest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    private final HomeController homeController;

    public UserController(UserService userService, HomeController homeController) {
        this.userService = userService;
        this.homeController = homeController;
    }

    @PostMapping("/create")
    public String create(@Validated UserRequest request) {
        userService.addUserLogic(request.getId());
        return "home";
    }

    @PostMapping("plus")
    public String plus(UserRequest request) {
        userService.plusLogic(request.getId());
        return "home";
    }


//    @GetMapping("/fullcreate")
//    public String createUser(@RequestParam String id,
//                             @RequestParam int count)
//    {
//
//        UserModel userModel = new UserModel(id, count);
//        userService.addUserLogic(userModel);
//        return "home";
//    }

    @GetMapping("/home2")
    public ModelAndView home2() {
        ModelAndView model = new ModelAndView();

        model.setViewName("home2");
        model.addObject("list", userService.getAll());
        return model;
    }

    @PostMapping("/click")
    public ModelAndView clicked(String id) {
//        userService.getUser(id);
        userService.getUser2(id);
        return home2();
    }


//    @GetMapping("/findUser")
//    public UserModel finduser(@RequestParam String id) {
//        return userService.getUser(id);
//    }
}
