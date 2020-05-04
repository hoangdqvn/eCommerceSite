package com.bookstore.dto;

import java.io.Serializable;
import java.util.List;

public class CategoryDTO implements Serializable {
    private int categoryId;
    private String name;
    private List<BookDTO> listBookDTO;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookDTO> getListBookDTO() {
        return listBookDTO;
    }

    public void setListBookDTO(List<BookDTO> listBookDTO) {
        this.listBookDTO = listBookDTO;
    }
}
