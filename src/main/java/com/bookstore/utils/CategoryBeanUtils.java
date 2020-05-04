package com.bookstore.utils;

import com.bookstore.dto.CategoryDTO;
import com.bookstore.entity.CategoryEntity;

public class CategoryBeanUtils {
    public static CategoryEntity dtoToEntity(CategoryDTO dto){
        CategoryEntity entity = new CategoryEntity();
        entity.setCategoryId(dto.getCategoryId());
        entity.setName(dto.getName());
        return entity;
    }

    public static CategoryDTO entityToDTO(CategoryEntity entity){
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryId(entity.getCategoryId());
        dto.setName(entity.getName());
        return dto;
    }
}
