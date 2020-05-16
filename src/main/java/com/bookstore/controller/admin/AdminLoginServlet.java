package com.bookstore.controller.admin;

import com.bookstore.dto.UserDTO;
import com.bookstore.serviceimpl.utils.SingletonServiceUtil;
import com.bookstore.utils.SessionUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", urlPatterns = "/admin/login")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDTO pojo = new UserDTO();
        pojo.setEmail(request.getParameter("email"));
        pojo.setPassword(request.getParameter("password"));

        try{
            UserDTO dto = SingletonServiceUtil.getUserServiceInstance().isUserExist(pojo);
            if(dto != null){
                SessionUtils.getInstance().putValue(request, "useremail", dto.getEmail());
                RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
                dispatcher.forward(request, response);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            request.setAttribute("message", "Login failed!");
            doGet(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }
}
