package com.bookstore.controller.admin;

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
import java.util.List;

@WebServlet(name = "ListUserServlet", urlPatterns = "/admin/list_users")
public class ListUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        List<UserDTO> listUsers = SingletonServiceUtil.getUserServiceInstance().findAll();

        request.setAttribute("listUsers", listUsers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("user_list.jsp");
        dispatcher.forward(request, response);
    }
}
