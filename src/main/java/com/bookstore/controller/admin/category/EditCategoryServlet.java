package com.bookstore.controller.admin.category;

import com.bookstore.serviceimpl.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditCategoryServlet", urlPatterns = "/admin/edit_category")
public class EditCategoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryServiceImpl categoryService = new CategoryServiceImpl();
        categoryService.editCategory(request,response);
    }
}
