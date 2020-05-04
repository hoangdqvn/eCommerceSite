package com.bookstore.utils;

import com.bookstore.dto.BookDTO;
import com.bookstore.entity.BookEntity;

public class BookBeanUtils {
    public static BookEntity dtoToEntity(BookDTO dto){
        BookEntity entity = new BookEntity();
        entity.setImage(dto.getImage());
        entity.setCategoryEntity(CategoryBeanUtils.dtoToEntity(dto.getCategoryDTO()));
        entity.setTitle(dto.getTitle());
        entity.setPublishDate(dto.getPublishDate());
        entity.setPrice(dto.getPrice());
        entity.setLastUpdateTime(dto.getLastUpdateTime());
        entity.setIsbn(dto.getIsbn());
        entity.setDescription(dto.getDescription());
        entity.setAuthor(dto.getAuthor());
        entity.setBookId(dto.getBookId());
        return entity;
    }

    public static BookDTO entityToDTO(BookEntity entity){
        BookDTO dto = new BookDTO();
        dto.setImage(entity.getImage());
        dto.setAuthor(entity.getAuthor());
        dto.setBookId(entity.getBookId());
        dto.setCategoryDTO(CategoryBeanUtils.entityToDTO(entity.getCategoryEntity()));
        dto.setDescription(entity.getDescription());
        dto.setIsbn(entity.getIsbn());
        dto.setLastUpdateTime(entity.getLastUpdateTime());
        dto.setPrice(entity.getPrice());
        dto.setPublishDate(entity.getPublishDate());
        dto.setTitle(entity.getTitle());
        return dto;
    }
}
