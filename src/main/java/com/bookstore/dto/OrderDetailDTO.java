package com.bookstore.dto;

import java.io.Serializable;

public class OrderDetailDTO implements Serializable {
    private BookOrderDTO bookOrderDTO;
    private BookDTO bookDTO;
    private int quantity;
    private double subtotal;

    public BookOrderDTO getBookOrderDTO() {
        return bookOrderDTO;
    }

    public void setBookOrderDTO(BookOrderDTO bookOrderDTO) {
        this.bookOrderDTO = bookOrderDTO;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }

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
}
