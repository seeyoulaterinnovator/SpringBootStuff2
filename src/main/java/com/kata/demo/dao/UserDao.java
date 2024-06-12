package com.kata.demo.dao;

import org.apache.catalina.User;

import java.util.List;

public interface UserDao {
    void addUser(com.kata.demo.model.User user);
    com.kata.demo.model.User findUserById(Long id);
    void deleteUserById(Long id);
    void updateUser(com.kata.demo.model.User user);
    List<com.kata.demo.model.User> listAllUsers();
}