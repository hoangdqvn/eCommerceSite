package com.bookstore.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class BookOrderDTO implements Serializable {
    private int orderId;
    private CustomerDTO customerDTO;
    private Timestamp orderDate;
    private String shippingAddress;
    private String recipientName;
    private String recipientPhone;
    private String paymentMethod;
    private double total;
    private String status;
    private List<OrderDetailDTO> listOrderDetailDTO;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

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

    public List<OrderDetailDTO> getListOrderDetailDTO() {
        return listOrderDetailDTO;
    }

    public void setListOrderDetailDTO(List<OrderDetailDTO> listOrderDetailDTO) {
        this.listOrderDetailDTO = listOrderDetailDTO;
    }
}
