package com.bookstore.utils;

import com.bookstore.dto.UserDTO;
import com.bookstore.entity.UserEntity;

public class UserBeanUtils {
    public static UserEntity dtoToEntity(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setEmail(dto.getEmail());
        entity.setFullName(dto.getFullName());
        entity.setUserId(dto.getUserId());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    public static UserDTO entityToDTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setEmail(entity.getEmail());
        dto.setFullName(entity.getFullName());
        dto.setUserId(entity.getUserId());
        dto.setPassword(entity.getPassword());
        return dto;
    }
}
