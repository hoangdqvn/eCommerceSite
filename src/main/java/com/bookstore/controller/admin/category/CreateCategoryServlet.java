package com.bookstore.controller.admin.category;

import com.bookstore.dto.CategoryDTO;
import com.bookstore.serviceimpl.impl.CategoryServiceImpl;
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

@WebServlet(name = "CreateCategoryServlet", urlPatterns = "/admin/create_category")
public class CreateCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("category_form.jsp");
//        dispatcher.forward(request, response);
        String name = request.getParameter("name");
        Map<String, Object> mapProperty = new HashMap<>();
        if (name != null) {
            mapProperty.put("name", name);
        }

        Object[] objects = SingletonServiceUtil.getCategoryServiceInstance().findByProperty(mapProperty, true);
        List<CategoryDTO> categoryDTOList = (List<CategoryDTO>) objects[1];

        CategoryServiceImpl categoryService = new CategoryServiceImpl();

        if(categoryDTOList.size()>0){
            String message = "Could not create category. A category with name " + name + " already exists";
            request.setAttribute("message",message);
            categoryService.listCategory(request,response);
        } else{
            categoryService.createCategory(request,response);
            request.setAttribute("message","New category created successfully!");
            categoryService.listCategory(request,response);
        }
    }
}
