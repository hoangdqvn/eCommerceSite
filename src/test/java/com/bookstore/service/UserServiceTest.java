package com.bookstore.service;

import com.bookstore.dto.UserDTO;
import com.bookstore.serviceimpl.impl.UserServiceImpl;

import java.util.List;

public class UserServiceTest {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        List<UserDTO> listUsers = userService.findAll();

        listUsers.forEach((user) -> {
            System.out.println(user.getFullName());
        });
    }
}
