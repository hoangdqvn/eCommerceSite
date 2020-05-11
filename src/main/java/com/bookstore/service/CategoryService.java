package com.bookstore.service;

import com.bookstore.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    List<CategoryDTO> findAll();
    void updateCategory(CategoryDTO dto);
    void saveCategory(CategoryDTO dto);
    CategoryDTO findById(Integer id);
    int delete(Integer id);
    Object[] findByProperty(Map<String, Object> property, Boolean exact);
}
