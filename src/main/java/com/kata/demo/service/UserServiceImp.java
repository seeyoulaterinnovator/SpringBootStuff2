package com.kata.demo.service;

import com.kata.demo.dao.UserDao;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void creatUser(User users) {
        userDao.creatUser(users);
    }

    @Transactional
    @Override
    public void updatUser(User users) {
        userDao.updatUser(users);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserId(Long id) {
        return userDao.getUserId(id);
    }

    @Transactional
    @Override
    public void delUser(Long id) {
        userDao.delUser(id);
    }
}