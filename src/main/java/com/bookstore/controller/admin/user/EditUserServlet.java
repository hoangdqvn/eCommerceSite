package com.bookstore.controller.admin.user;

import com.bookstore.serviceimpl.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditUserServlet", urlPatterns = "/admin/edit_user")
public class EditUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        userService.editUser(request,response);
    }
}
