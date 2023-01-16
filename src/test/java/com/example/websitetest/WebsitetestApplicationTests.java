package com.example.websitetest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class WebsitetestApplicationTests {
    @Autowired
    UserService userService;

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserController userController;

//    @Autowired
//    UserRequest ;

//    @Test
//    public void 만들기테스트() {
//        userController.create();
//
//
//    }
//
//    @Test
//    public void 카운트추카() {
//        userController.plus();
//    }

    @Test
    public void 실험() {
        userController.clicked("qweqweqweqwe");
    }


    @Test
    public boolean addUserLogic(String id) {
        id = "123";
        if (userRepository.checkUser(id)) {
            return userRepository.addUser(id);
        }
        return false;
    }
}
