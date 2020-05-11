package com.bookstore.controller.admin.user;

import com.bookstore.dto.UserDTO;
import com.bookstore.serviceimpl.impl.UserServiceImpl;
import com.bookstore.serviceimpl.utils.SingletonServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CreateUserServlet", urlPatterns = "/admin/create_user")
public class CreateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        UserDTO userDTO = new UserDTO();
//
//        userDTO.setEmail(request.getParameter("email"));
//        userDTO.setFullName(request.getParameter("fullname"));
//        userDTO.setPassword(request.getParameter("password"));
//
//        SingletonServiceUtil.getUserServiceInstance().saveUser(userDTO);
        String email = request.getParameter("email");
        Map<String, Object> mapProperty = new HashMap<>();
        if (email != null) {
            mapProperty.put("email", email);
        }

        Object[] objects = SingletonServiceUtil.getUserServiceInstance().findByProperty(mapProperty, true);
        List<UserDTO> userDtoList = (List<UserDTO>) objects[1];

        UserServiceImpl userService = new UserServiceImpl();

        if(userDtoList.size()>0){
            String message = "Could not create user. A user with email " + email + " already exists";
            request.setAttribute("message",message);
            userService.listUsers(request,response);
        } else{
            userService.createUser(request,response);
            request.setAttribute("message","New user created successfully!");
            userService.listUsers(request,response);
        }
    }
}
