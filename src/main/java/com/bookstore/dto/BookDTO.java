package com.bookstore.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class BookDTO implements Serializable {
    private int bookId;
    private String title;
    private String author;
    private String description;
    private String isbn;
    private byte[] image;
//    private String base64Image;
    private double price;
    private Date publishDate;
    private Timestamp lastUpdateTime;
    private CategoryDTO categoryDTO;
    private List<OrderDetailDTO> listOrderDetailDTO;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public List<OrderDetailDTO> getListOrderDetailDTO() {
        return listOrderDetailDTO;
    }

    public void setListOrderDetailDTO(List<OrderDetailDTO> listOrderDetailDTO) {
        this.listOrderDetailDTO = listOrderDetailDTO;
    }
}
