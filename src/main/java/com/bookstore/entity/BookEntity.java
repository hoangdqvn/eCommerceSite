package com.bookstore.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private int bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description", length = 16777215)
    private String description;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "price")
    private double price;

    @Column(name = "publish_date")
    private Date publishDate;

    @Column(name = "last_update_time")
    private Timestamp lastUpdateTime;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "primaryKey.bookEntity", cascade = CascadeType.ALL)
    private List<OrderDetailEntity> listOrderDetail;

    public int getBookId() { return bookId; }

    public void setBookId(int bookId) { this.bookId = bookId; }

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

    public CategoryEntity getCategoryEntity() { return categoryEntity; }

    public void setCategoryEntity(CategoryEntity categoryEntity) { this.categoryEntity = categoryEntity; }

    public List<OrderDetailEntity> getListOrderDetail() { return listOrderDetail; }

    public void setListOrderDetail(List<OrderDetailEntity> listOrderDetail) { this.listOrderDetail = listOrderDetail; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return bookId == that.bookId &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(title, that.title) &&
                Objects.equals(author, that.author) &&
                Objects.equals(description, that.description) &&
                Objects.equals(isbn, that.isbn) &&
                Arrays.equals(image, that.image) &&
                Objects.equals(publishDate, that.publishDate) &&
                Objects.equals(lastUpdateTime, that.lastUpdateTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(bookId, title, author, description, isbn, price, publishDate, lastUpdateTime);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
