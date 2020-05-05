package com.bookstore.dao;

import com.bookstore.daoimpl.UserDAOImpl;
import com.bookstore.entity.UserEntity;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserDAOTest {
    @Test
    public void update(){
        UserDAOImpl userDAO = new UserDAOImpl();
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(19);
        userEntity.setFullName("Hoang Ngoan");
        userEntity.setPassword("hn2020");
        userEntity.setEmail("braveheart@gmail.com");

        userEntity = userDAO.update(userEntity);
        String expected = "hn2020";
        String actual = userEntity.getPassword();

        assertEquals(expected,actual);
    }
}
