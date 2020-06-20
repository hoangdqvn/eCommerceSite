package com.bookstore.service;

import com.bookstore.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<UserDTO> findAll();
    void updateUser(UserDTO dto);
    void saveUser(UserDTO userDto);
    UserDTO findById(Integer id);
    int delete(Integer userId);
    Object[] findByProperty(Map<String, Object> property, Boolean exact);
    UserDTO isUserExist(UserDTO dto);
}
