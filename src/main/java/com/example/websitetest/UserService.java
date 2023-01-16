package com.example.websitetest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public boolean plusLogic(String id) {
        if (userRepository.plusCount(id)) {
        }
        return false;
    }

    public List<UserModel> getAll() {

        return userRepository.getAll();
    }
@Transactional(isolation = Isolation.SERIALIZABLE)
    public UserModel getUser2(String id) { //upsert
        return userRepository.updateOrInsert(id);
    }

    public UserModel getUser(String id) {
        if (userRepository.checkIdExist(id).equals("")) {
            return userRepository.updateIfIDExist(id);
        }
        return  userRepository.insertIfNoID(id);
    }
}


