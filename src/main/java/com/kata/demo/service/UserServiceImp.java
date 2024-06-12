package com.kata.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.kata.demo.dao.UserDao;
import com.kata.demo.model.User;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    @Transactional
    public void updateUserInfo(User user) {
        userDao.updateUser(user);
    }

    @Override
    public List<User> listAllUsers() {
        return userDao.listAllUsers();
    }
}