package com.bookstore.serviceimpl.impl;

import com.bookstore.dto.UserDTO;
import com.bookstore.entity.UserEntity;
import com.bookstore.service.UserService;
import com.bookstore.serviceimpl.utils.SingletonDaoUtil;
import com.bookstore.serviceimpl.utils.SingletonServiceUtil;
import com.bookstore.utils.UserBeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    public void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<UserEntity> list = SingletonDaoUtil.getUserDaoInstance().findAll();
        List<UserDTO> UserDTOList = new ArrayList<>();
        for (UserEntity entity : list){
            UserDTOList.add(UserBeanUtils.entityToDTO(entity));
        }

        request.setAttribute("listUsers", UserDTOList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("user_list.jsp");
        dispatcher.forward(request, response);
    }

    public void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDTO userDTO = new UserDTO();

        userDTO.setEmail(request.getParameter("email"));
        userDTO.setFullName(request.getParameter("fullname"));
        userDTO.setPassword(request.getParameter("password"));

        UserEntity entity = UserBeanUtils.dtoToEntity(userDTO);
        SingletonDaoUtil.getUserDaoInstance().save(entity);
    }

    public void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = Integer.parseInt(request.getParameter("id"));
        UserDTO userDTO = SingletonServiceUtil.getUserServiceInstance().findById(userId);

        String redirectedPage = "user_form.jsp";

        if (userDTO == null) {
            redirectedPage = "message.jsp";
            String message = "Could not find user with ID " + userId;
            request.setAttribute("message", message);
        } else {
            request.setAttribute("userE", userDTO);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(redirectedPage);
        dispatcher.forward(request, response);
    }

    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDTO userDTO = new UserDTO();

        Integer userId = Integer.parseInt(request.getParameter("userId"));
        userDTO.setUserId(userId);
        userDTO.setEmail(request.getParameter("email"));
        userDTO.setFullName(request.getParameter("fullname"));
        userDTO.setPassword(request.getParameter("password"));

//        System.out.println(userId);

        UserEntity entity = UserBeanUtils.dtoToEntity(userDTO);
        SingletonDaoUtil.getUserDaoInstance().update(entity);
    }
}
