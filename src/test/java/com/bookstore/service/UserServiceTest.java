package com.bookstore.service;

import com.bookstore.dto.UserDTO;
import com.bookstore.serviceimpl.impl.UserServiceImpl;
import com.bookstore.serviceimpl.utils.SingletonServiceUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceTest {
    //Test findByProperty
    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("hoangdq@gmail.com");

        Map<String, Object> mapProperty = new HashMap<>();
        mapProperty.put("email", userDTO.getEmail());

        Object[] objects = SingletonServiceUtil.getUserServiceInstance().findByProperty(mapProperty, true);
        List<UserDTO> userDtoList = (List<UserDTO>) objects[1];

        userDtoList.forEach((user) -> {
            System.out.println(user.getFullName());
        });
    }
}
