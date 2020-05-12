package com.bookstore.service;

import com.bookstore.dto.CategoryDTO;
import com.bookstore.dto.UserDTO;
import com.bookstore.entity.CategoryEntity;
import com.bookstore.serviceimpl.utils.SingletonServiceUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CategoryServiceTest {
    @Test
    public void create(){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName("Art");

        SingletonServiceUtil.getCategoryServiceInstance().saveCategory(categoryDTO);
    }

    @Test
    public void update(){
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryId(13);
        dto.setName("Marketing");

        SingletonServiceUtil.getCategoryServiceInstance().updateCategory(dto);
        String expected = "Marketing";
        String actual = SingletonServiceUtil.getCategoryServiceInstance().findById(13).getName();

        assertEquals(expected,actual);
    }

    @Test
    public void listAll(){
        List<CategoryDTO> listCategory = SingletonServiceUtil.getCategoryServiceInstance().findAll();

        for( CategoryDTO item : listCategory){
            System.out.println(item.getName());
        }
    }

    @Test
    public void delete(){
        Integer actual = SingletonServiceUtil.getCategoryServiceInstance().delete(13);
        Integer expected = 1;

        assertEquals(expected,actual);
    }

    @Test
    public void findByProperty(){
        String name = "Business";

        Map<String, Object> mapProperty = new HashMap<>();
        mapProperty.put("name", name);

        Object[] objects = SingletonServiceUtil.getCategoryServiceInstance().findByProperty(mapProperty, true);
        List<CategoryDTO> categoryDTOList = (List<CategoryDTO>) objects[1];

        assertEquals(14,categoryDTOList.get(0).getCategoryId());
    }
}
