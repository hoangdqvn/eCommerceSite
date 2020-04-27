package com.bookstore.entity;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class OrderDetailId implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    private BookOrderEntity bookOrderEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    private BookEntity bookEntity;

    public BookOrderEntity getBookOrderEntity() {
        return bookOrderEntity;
    }

    public void setBookOrderEntity(BookOrderEntity bookOrderEntity) {
        this.bookOrderEntity = bookOrderEntity;
    }

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }
}
