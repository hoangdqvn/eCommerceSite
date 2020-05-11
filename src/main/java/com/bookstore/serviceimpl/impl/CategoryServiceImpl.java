package com.bookstore.serviceimpl.impl;

import com.bookstore.dto.CategoryDTO;
import com.bookstore.entity.CategoryEntity;
import com.bookstore.service.CategoryService;
import com.bookstore.serviceimpl.utils.SingletonDaoUtil;
import com.bookstore.utils.CategoryBeanUtils;

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
}
