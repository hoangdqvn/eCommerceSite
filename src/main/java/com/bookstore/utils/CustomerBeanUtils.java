package com.bookstore.utils;

import com.bookstore.dto.CustomerDTO;
import com.bookstore.entity.CustomerEntity;

public class CustomerBeanUtils {
    public static CustomerEntity dtoToEntity(CustomerDTO dto){
        CustomerEntity entity = new CustomerEntity();
        entity.setCustomerId(dto.getCustomerId());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setCountry(dto.getCountry());
        entity.setEmail(dto.getEmail());
        entity.setFullname(dto.getFullname());
        entity.setPassword(dto.getPassword());
        entity.setPhone(dto.getPhone());
        entity.setRegisterDate(dto.getRegisterDate());
        entity.setZipcode(dto.getZipcode());
        return entity;
    }

    public static CustomerDTO entityToDTO(CustomerEntity entity){
        CustomerDTO dto = new CustomerDTO();
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());
        dto.setCustomerId(entity.getCustomerId());
        dto.setEmail(entity.getEmail());
        dto.setFullname(entity.getFullname());
        dto.setPassword(entity.getPassword());
        dto.setPhone(entity.getPhone());
        dto.setRegisterDate(entity.getRegisterDate());
        dto.setZipcode(entity.getZipcode());
        return dto;
    }
}
