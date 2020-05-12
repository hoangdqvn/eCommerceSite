package com.bookstore.controller.admin.category;

import com.bookstore.dto.CategoryDTO;
import com.bookstore.serviceimpl.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UpdateCategoryServlet", urlPatterns = "/admin/update_category")
public class UpdateCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryServiceImpl categoryService = new CategoryServiceImpl();

        String name = request.getParameter("name");
        Map<String, Object> mapProperty = new HashMap<>();
        if (name != null) {
            mapProperty.put("name", name);
        }
        Object[] objects = categoryService.findByProperty(mapProperty, true);
        List<CategoryDTO> categoryDTOList = (List<CategoryDTO>) objects[1];

        CategoryDTO categoryByEmail = new CategoryDTO();
        if (categoryDTOList.size()>0){
            categoryByEmail = categoryDTOList.get(0);
        } else{
            categoryByEmail = null;
        }
        CategoryDTO categoryById = categoryService.findById(Integer.parseInt(request.getParameter("categoryId")));

        if(categoryByEmail != null && categoryByEmail.getCategoryId() != categoryById.getCategoryId()){
            String message = "Could not update category. A category with name " + name + " already exists";
            request.setAttribute("message",message);
            categoryService.listCategory(request,response);
        } else{
            categoryService.updateCategory(request,response);
            request.setAttribute("message","Category has been updated successfully!");
            categoryService.listCategory(request,response);
        }
    }
}
