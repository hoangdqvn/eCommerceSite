package com.bookstore.controller.admin.user;

import com.bookstore.dto.UserDTO;
import com.bookstore.serviceimpl.impl.UserServiceImpl;
import com.bookstore.serviceimpl.utils.SingletonServiceUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UpdateUserServlet", urlPatterns = "/admin/update_user")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();

        String email = request.getParameter("email");
        Map<String, Object> mapProperty = new HashMap<>();
        if (email != null) {
            mapProperty.put("email", email);
        }
        Object[] objects = userService.findByProperty(mapProperty, true);
        List<UserDTO> userDtoList = (List<UserDTO>) objects[1];

        UserDTO userByEmail = new UserDTO();
        if (userDtoList.size()>0){
            userByEmail = userDtoList.get(0);
        } else{
            userByEmail = null;
        }
        UserDTO userById = userService.findById(Integer.parseInt(request.getParameter("userId")));

        if(userByEmail != null && userByEmail.getUserId() != userById.getUserId()){
            String message = "Could not update user. A user with email " + email + " already exists";
            request.setAttribute("message",message);
            userService.listUsers(request,response);
        } else{
            userService.updateUser(request,response);
            request.setAttribute("message","User has been updated successfully!");
            userService.listUsers(request,response);
        }
    }
}
