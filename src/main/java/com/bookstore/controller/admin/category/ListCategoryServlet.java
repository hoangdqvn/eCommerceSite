package com.bookstore.controller.admin.category;

import com.bookstore.serviceimpl.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListCategoryServlet", urlPatterns = "/admin/list_category")
public class ListCategoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<CategoryDTO> listCategory = SingletonServiceUtil.getCategoryServiceInstance().findAll();
//
//        request.setAttribute("listCategory", listCategory);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("category_list.jsp");
//        dispatcher.forward(request, response);
        CategoryServiceImpl categoryService = new CategoryServiceImpl();
        categoryService.listCategory(request,response);
    }
}
