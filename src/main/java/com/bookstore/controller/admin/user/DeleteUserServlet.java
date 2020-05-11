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
import java.util.List;

@WebServlet(name = "DeleteUserServlet", urlPatterns = "/admin/delete_user")
public class DeleteUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = Integer.parseInt(request.getParameter("id"));

        if (userId == 48) {
            String message = "The default admin user account cannot be deleted.";

            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
            dispatcher.forward(request, response);
        } else {
            UserDTO userDTO = SingletonServiceUtil.getUserServiceInstance().findById(userId);
            UserServiceImpl userService = new UserServiceImpl();
            if(userDTO != null) {
                Integer ids = SingletonServiceUtil.getUserServiceInstance().delete(userId);
                request.setAttribute("message", "User is has been deleted successfully!");
                userService.listUsers(request, response);
            } else {
                request.setAttribute("message", "Could not find user with ID " + userId + ", or it might have been deleted by another admin.");
                userService.listUsers(request, response);
            }
        }
    }
}
