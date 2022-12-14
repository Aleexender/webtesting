package com.example.websitetest;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean addUserLogic(String id) {
        if (userRepository.checkUser(id)) {
            return userRepository.addUser(id);
        }
        return false;
    }

    public boolean addUserLogic(UserModel userModel) {
        if (userRepository.checkUser(userModel.getId())) {
            return userRepository.addUser(userModel);
        }
        return false;
    }

//    public UserModel getUser(String id) {
//        return userRepository.get
//    }
}
