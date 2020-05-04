package com.bookstore.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class CustomerDTO implements Serializable {
    private int customerId;
    private String email;
    private String fullname;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String zipcode;
    private String password;
    private Timestamp registerDate;
    private List<BookOrderDTO> listOrderDTO;
    private List<ReviewDTO> listReviewDTO;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public List<BookOrderDTO> getListOrderDTO() {
        return listOrderDTO;
    }

    public void setListOrderDTO(List<BookOrderDTO> listOrderDTO) {
        this.listOrderDTO = listOrderDTO;
    }

    public List<ReviewDTO> getListReviewDTO() {
        return listReviewDTO;
    }

    public void setListReviewDTO(List<ReviewDTO> listReviewDTO) {
        this.listReviewDTO = listReviewDTO;
    }
}
