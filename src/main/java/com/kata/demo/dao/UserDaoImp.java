package com.kata.demo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void creatUser(User users) {
        entityManager.persist(users);
    }

    @Override
    public void updatUser(User users) {
        entityManager.merge(users);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Override
    public User getUserId(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delUser(Long id) {
        entityManager.remove(getUserId(id));
    }
}
