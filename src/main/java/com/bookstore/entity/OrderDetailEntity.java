package com.bookstore.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_detail")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.bookOrderEntity",
                joinColumns = @JoinColumn(name = "order_id")),
        @AssociationOverride(name = "primaryKey.bookEntity",
                joinColumns = @JoinColumn(name = "book_id")) })
public class OrderDetailEntity {
    @EmbeddedId
    private OrderDetailId primaryKey = new OrderDetailId();

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "subtotal")
    private double subtotal;

    public OrderDetailId getPrimaryKey() { return primaryKey; }

    public void setPrimaryKey(OrderDetailId primaryKey) { this.primaryKey = primaryKey; }

    @Transient
    public BookOrderEntity getBookOrderEntity(){return getPrimaryKey().getBookOrderEntity();}

    public void setBookOrderEntity(BookOrderEntity bookOrderEntity){getPrimaryKey().setBookOrderEntity(bookOrderEntity);}

    @Transient
    public BookEntity getBookEntity(){return getPrimaryKey().getBookEntity();}

    public void setBookEntity(BookEntity bookEntity){getPrimaryKey().setBookEntity(bookEntity);}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        OrderDetailEntity that = (OrderDetailEntity) o;
//        return quantity == that.quantity &&
//                Double.compare(that.subtotal, subtotal) == 0;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(quantity, subtotal);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetailEntity)) return false;
        OrderDetailEntity that = (OrderDetailEntity) o;
        return getQuantity() == that.getQuantity() &&
                Double.compare(that.getSubtotal(), getSubtotal()) == 0 &&
                Objects.equals(getPrimaryKey(), that.getPrimaryKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrimaryKey(), getQuantity(), getSubtotal());
    }
}
