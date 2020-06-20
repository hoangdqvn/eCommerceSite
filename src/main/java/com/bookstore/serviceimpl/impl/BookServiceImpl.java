package com.bookstore.serviceimpl.impl;

import com.bookstore.dto.BookDTO;
import com.bookstore.service.BookService;

import java.util.List;
import java.util.Map;

public class BookServiceImpl implements BookService {
    @Override
    public List<BookDTO> findAll() {
        return null;
    }

    @Override
    public void update(BookDTO dto) {

    }

    @Override
    public void save(BookDTO dto) {

    }

    @Override
    public BookDTO findById(Integer id) {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public Object[] findByProperty(Map<String, Object> property, Boolean exact) {
        return new Object[0];
    }
}
