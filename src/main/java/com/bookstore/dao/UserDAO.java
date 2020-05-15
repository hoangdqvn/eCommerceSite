package com.bookstore.dao;

import com.bookstore.entity.UserEntity;

public interface UserDAO extends GenericDAO<Integer, UserEntity> {
    UserEntity isUserExist(String email, String password);
}
