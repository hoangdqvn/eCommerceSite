package com.bookstore.controller.admin.category;

import com.bookstore.dto.CategoryDTO;
import com.bookstore.serviceimpl.impl.CategoryServiceImpl;
import com.bookstore.serviceimpl.utils.SingletonServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCategoryServlet", urlPatterns = "/admin/delete_category")
public class DeleteCategoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer categoryId = Integer.parseInt(request.getParameter("id"));

        CategoryDTO categoryDTO = SingletonServiceUtil.getCategoryServiceInstance().findById(categoryId);
        CategoryServiceImpl categoryService = new CategoryServiceImpl();
        if(categoryDTO != null) {
            Integer ids = SingletonServiceUtil.getCategoryServiceInstance().delete(categoryId);
            request.setAttribute("message", "Category is has been deleted successfully!");
            categoryService.listCategory(request, response);
        } else {
            request.setAttribute("message", "Could not find category with ID " + categoryId + ", or it might have been deleted by another admin.");
            categoryService.listCategory(request, response);
        }
    }
}
