package com.bookstore.utils;

import com.bookstore.dto.BookOrderDTO;
import com.bookstore.entity.BookOrderEntity;

public class BookOrderBeanUtils {
    public static BookOrderEntity dtoToEntity(BookOrderDTO dto){
        BookOrderEntity entity = new BookOrderEntity();
        entity.setStatus(dto.getStatus());
        entity.setRecipientPhone(dto.getRecipientPhone());
        entity.setCustomerEntity(CustomerBeanUtils.dtoToEntity(dto.getCustomerDTO()));
        entity.setShippingAddress(dto.getShippingAddress());
        entity.setRecipientName(dto.getRecipientName());
        entity.setPaymentMethod(dto.getPaymentMethod());
        entity.setOrderDate(dto.getOrderDate());
        entity.setOrderId(dto.getOrderId());
        entity.setTotal(dto.getTotal());
        return entity;
    }

    public static BookOrderDTO entityToDTO(BookOrderEntity entity){
        BookOrderDTO dto = new BookOrderDTO();
        dto.setCustomerDTO(CustomerBeanUtils.entityToDTO(entity.getCustomerEntity()));
        dto.setOrderDate(entity.getOrderDate());
        dto.setOrderId(entity.getOrderId());
        dto.setPaymentMethod(entity.getPaymentMethod());
        dto.setRecipientName(entity.getRecipientName());
        dto.setRecipientPhone(entity.getRecipientPhone());
        dto.setShippingAddress(entity.getShippingAddress());
        dto.setStatus(entity.getStatus());
        dto.setTotal(entity.getTotal());
        return dto;
    }
}
