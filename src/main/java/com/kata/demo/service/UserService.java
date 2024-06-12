package com.kata.demo.service;


import com.kata.demo.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User findUserById(Long id);
    void deleteUserById(Long id);
    void updateUserInfo(User user);
    List<User> listAllUsers();
}