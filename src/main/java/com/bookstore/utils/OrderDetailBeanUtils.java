package com.bookstore.utils;

import com.bookstore.dto.OrderDetailDTO;
import com.bookstore.entity.OrderDetailEntity;
import com.bookstore.entity.OrderDetailId;

public class OrderDetailBeanUtils {
    public static OrderDetailEntity dtoToEntity(OrderDetailDTO dto){
        OrderDetailId primaryKey = new OrderDetailId();
        primaryKey.setBookEntity(BookBeanUtils.dtoToEntity(dto.getBookDTO()));
        primaryKey.setBookOrderEntity(BookOrderBeanUtils.dtoToEntity(dto.getBookOrderDTO()));

        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setSubtotal(dto.getSubtotal());
        entity.setQuantity(dto.getQuantity());
//        entity.setBookOrderEntity(BookOrderBeanUtils.dtoToEntity(dto.getBookOrderDTO()));
//        entity.setBookEntity(BookBeanUtils.dtoToEntity(dto.getBookDTO()));
        entity.setPrimaryKey(primaryKey);
        return entity;
    }

    public static OrderDetailDTO entityToDTO(OrderDetailEntity entity){
        OrderDetailDTO dto = new OrderDetailDTO();
        dto.setBookDTO(BookBeanUtils.entityToDTO(entity.getBookEntity()));
        dto.setBookOrderDTO(BookOrderBeanUtils.entityToDTO(entity.getBookOrderEntity()));
        dto.setQuantity(entity.getQuantity());
        dto.setSubtotal(entity.getSubtotal());
        return dto;
    }
}
