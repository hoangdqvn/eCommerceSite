package com.bookstore.controller.frontend;

import com.bookstore.dto.CategoryDTO;
import com.bookstore.serviceimpl.utils.SingletonServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CategoryDTO> listCategory = SingletonServiceUtil.getCategoryServiceInstance().findAll();
        request.setAttribute("listCategory", listCategory);

        RequestDispatcher dispatcher = request.getRequestDispatcher("frontend/index.jsp");
        dispatcher.forward(request, response);
    }
}
