package com.bookstore.dao;

import com.bookstore.daoimpl.UserDAOImpl;
import com.bookstore.entity.UserEntity;
import org.junit.Test;

import javax.persistence.PersistenceException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserDAOTest {
    @Test
    public void createUser(){
        UserDAOImpl userDAO = new UserDAOImpl();
        UserEntity userEntity = new UserEntity();

//        userEntity.setUserId(21);
        userEntity.setFullName("Khoa PA");
        userEntity.setPassword("hn2020");
        userEntity.setEmail("khoapa@gmail.com");

        UserEntity userEntity1 = userDAO.save(userEntity);

        String expected = "hn2020";
        String actual = userEntity1.getPassword();
        assertEquals(expected,actual);
    }

    @Test
    public void update(){
        UserDAOImpl userDAO = new UserDAOImpl();
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(20);
        userEntity.setFullName("Huu DQ");
        userEntity.setPassword("hn2020");
        userEntity.setEmail("huudq@gmail.com");

        userEntity = userDAO.update(userEntity);
        String expected = "hn2020";
        String actual = userEntity.getPassword();

        assertEquals(expected,actual);
    }

    @Test()
    public void testFindById(){
        Integer userId = 19;
        UserDAOImpl userDAO = new UserDAOImpl();
        UserEntity userEntity = new UserEntity();
        userEntity = userDAO.findByID(userId);
        if(userEntity != null) {
            System.out.println(userEntity.getEmail());
        }
        assertNotNull(userEntity);
    }

    @Test
    public void testDeleteUser(){
        List<Integer> ids = new ArrayList<>();
        ids.add(23);
        ids.add(24);

        UserDAOImpl userDAO = new UserDAOImpl();
        Integer result = userDAO.delete(ids);

        Integer expected = 2;

        assertEquals(expected,result);
    }
}
