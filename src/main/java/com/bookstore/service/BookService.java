package com.bookstore.service;

import com.bookstore.dto.BookDTO;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<BookDTO> findAll();
    void update(BookDTO dto);
    void save(BookDTO dto);
    BookDTO findById(Integer id);
    int delete(Integer id);
    Object[] findByProperty(Map<String, Object> property, Boolean exact);
}
