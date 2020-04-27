package com.bookstore.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "book_order")
public class BookOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "recipient_phone")
    private String recipientPhone;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "total")
    private double total;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "primaryKey.bookOrderEntity", cascade = CascadeType.ALL)
    private List<OrderDetailEntity> listOrderDetail;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public CustomerEntity getCustomerEntity() { return customerEntity; }

    public void setCustomerEntity(CustomerEntity customerEntity) { this.customerEntity = customerEntity; }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderDetailEntity> getListOrderDetail() { return listOrderDetail; }

    public void setListOrderDetail(List<OrderDetailEntity> listOrderDetail) { this.listOrderDetail = listOrderDetail; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookOrderEntity that = (BookOrderEntity) o;
        return orderId == that.orderId &&
                Double.compare(that.total, total) == 0 &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(shippingAddress, that.shippingAddress) &&
                Objects.equals(recipientName, that.recipientName) &&
                Objects.equals(recipientPhone, that.recipientPhone) &&
                Objects.equals(paymentMethod, that.paymentMethod) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderDate, shippingAddress, recipientName, recipientPhone, paymentMethod, total, status);
    }
}
