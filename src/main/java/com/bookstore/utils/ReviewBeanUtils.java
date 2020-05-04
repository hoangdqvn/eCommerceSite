package com.bookstore.utils;

import com.bookstore.dto.ReviewDTO;
import com.bookstore.entity.ReviewEntity;

public class ReviewBeanUtils {
    public static ReviewEntity dtoToEntity(ReviewDTO dto){
        ReviewEntity entity = new ReviewEntity();
        entity.setBookReviewEntity(BookBeanUtils.dtoToEntity(dto.getBookDTO()));
        entity.setComment(dto.getComment());
        entity.setCustomerReviewEntity(CustomerBeanUtils.dtoToEntity(dto.getCustomerDTO()));
        entity.setHeadline(dto.getHeadline());
        entity.setRating(dto.getRating());
        entity.setReviewId(dto.getReviewId());
        entity.setReviewTime(dto.getReviewTime());
        return entity;
    }

    public static ReviewDTO entityToDTO(ReviewEntity entity){
        ReviewDTO dto = new ReviewDTO();
        dto.setBookDTO(BookBeanUtils.entityToDTO(entity.getBookReviewEntity()));
        dto.setComment(entity.getComment());
        dto.setCustomerDTO(CustomerBeanUtils.entityToDTO(entity.getCustomerReviewEntity()));
        dto.setHeadline(entity.getHeadline());
        dto.setRating(entity.getRating());
        dto.setReviewId(entity.getReviewId());
        dto.setReviewTime(entity.getReviewTime());
        return dto;
    }
}
