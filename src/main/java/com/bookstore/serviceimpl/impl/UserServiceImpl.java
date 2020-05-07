package com.bookstore.serviceimpl.impl;

import com.bookstore.dao.UserDAO;
import com.bookstore.daoimpl.UserDAOImpl;
import com.bookstore.dto.UserDTO;
import com.bookstore.entity.UserEntity;
import com.bookstore.service.UserService;
import com.bookstore.serviceimpl.utils.SingletonDaoUtil;
import com.bookstore.utils.UserBeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    public List<UserDTO> findAll() {
        List<UserEntity> list = SingletonDaoUtil.getUserDaoInstance().findAll();
        List<UserDTO> UserDTOList = new ArrayList<>();
        for (UserEntity entity : list){
            UserDTOList.add(UserBeanUtils.entityToDTO(entity));
        }
        return UserDTOList;
    }

    public void updateUser(UserDTO userDto){
        SingletonDaoUtil.getUserDaoInstance().update(UserBeanUtils.dtoToEntity(userDto));
    }

    public void saveUser(UserDTO userDto){
        UserEntity entity = UserBeanUtils.dtoToEntity(userDto);
        SingletonDaoUtil.getUserDaoInstance().save(entity);
    }

    public UserDTO findById(Integer userId){
        UserEntity entity = SingletonDaoUtil.getUserDaoInstance().findByID(userId);
        return UserBeanUtils.entityToDTO(entity);
    }

    public int delete(Integer userId){
        List<Integer> ids = new ArrayList<>();
        ids.add(userId);
        return SingletonDaoUtil.getUserDaoInstance().delete(ids);
    }

    public Object[] findByProperty(Map<String, Object> property, Boolean exact){
        Object[] objects = SingletonDaoUtil.getUserDaoInstance().findByProperty(property, exact, null);
        List<UserDTO> userDtoList = new ArrayList<UserDTO>();
        for (UserEntity item: (List<UserEntity>)objects[1]){
            UserDTO userDto = UserBeanUtils.entityToDTO(item);
            userDtoList.add(userDto);
        }
        objects[1] = userDtoList;
        return objects;
    }
}
