package com.bookstore.serviceimpl.impl;

import com.bookstore.dto.CategoryDTO;
import com.bookstore.entity.CategoryEntity;
import com.bookstore.service.CategoryService;
import com.bookstore.serviceimpl.utils.SingletonDaoUtil;
import com.bookstore.serviceimpl.utils.SingletonServiceUtil;
import com.bookstore.utils.CategoryBeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoryServiceImpl implements CategoryService {
    public List<CategoryDTO> findAll() {
        List<CategoryEntity> list = SingletonDaoUtil.getCategoryDaoInstance().findAll();
        List<CategoryDTO> CategoryDTOList = new ArrayList<>();
        for (CategoryEntity entity : list){
            CategoryDTOList.add(CategoryBeanUtils.entityToDTO(entity));
        }
        return CategoryDTOList;
    }

    @Override
    public void updateCategory(CategoryDTO dto) {
        SingletonDaoUtil.getCategoryDaoInstance().update(CategoryBeanUtils.dtoToEntity(dto));
    }

    @Override
    public void saveCategory(CategoryDTO dto) {
        CategoryEntity entity = CategoryBeanUtils.dtoToEntity(dto);
        SingletonDaoUtil.getCategoryDaoInstance().save(entity);
    }

    public CategoryDTO findById(Integer id){
        CategoryEntity entity = SingletonDaoUtil.getCategoryDaoInstance().findByID(id);
        return CategoryBeanUtils.entityToDTO(entity);
    }

    public int delete(Integer id){
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        return SingletonDaoUtil.getCategoryDaoInstance().delete(ids);
    }

    public Object[] findByProperty(Map<String, Object> property, Boolean exact){
        Object[] objects = SingletonDaoUtil.getCategoryDaoInstance().findByProperty(property, exact, null);
        List<CategoryDTO> categoryDtoList = new ArrayList<CategoryDTO>();
        for (CategoryEntity item: (List<CategoryEntity>)objects[1]){
            CategoryDTO categoryDTO = CategoryBeanUtils.entityToDTO(item);
            categoryDtoList.add(categoryDTO);
        }
        objects[1] = categoryDtoList;
        return objects;
    }

    public void listCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CategoryEntity> list = SingletonDaoUtil.getCategoryDaoInstance().findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (CategoryEntity entity : list){
            categoryDTOList.add(CategoryBeanUtils.entityToDTO(entity));
        }

        request.setAttribute("listCategory", categoryDTOList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("category_list.jsp");
        dispatcher.forward(request, response);
    }

    public void createCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setName(request.getParameter("name"));

        CategoryEntity entity = CategoryBeanUtils.dtoToEntity(categoryDTO);
        SingletonDaoUtil.getCategoryDaoInstance().save(entity);
    }

    public void editCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer categoryId = Integer.parseInt(request.getParameter("id"));
        CategoryDTO categoryDTO = SingletonServiceUtil.getCategoryServiceInstance().findById(categoryId);

        String redirectedPage = "category_form.jsp";

        if (categoryDTO == null) {
            redirectedPage = "message.jsp";
            String message = "Could not find category with ID " + categoryId;
            request.setAttribute("message", message);
        } else {
            request.setAttribute("categoryE", categoryDTO);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(redirectedPage);
        dispatcher.forward(request, response);
    }

    public void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDTO categoryDTO = new CategoryDTO();

        Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));
        categoryDTO.setCategoryId(categoryId);
        categoryDTO.setName(request.getParameter("name"));

        CategoryEntity entity = CategoryBeanUtils.dtoToEntity(categoryDTO);
        SingletonDaoUtil.getCategoryDaoInstance().update(entity);
    }
}
