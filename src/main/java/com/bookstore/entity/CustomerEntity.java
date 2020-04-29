package com.bookstore.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "email")
    private String email;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "phone")
    private String phone;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "password")
    private String password;

    @Column(name = "register_date")
    private Timestamp registerDate;

    @OneToMany(mappedBy = "customerEntity", fetch = FetchType.LAZY)
    private List<BookOrderEntity> listOrder;

    @OneToMany(mappedBy = "customerReviewEntity", fetch = FetchType.LAZY)
    private List<ReviewEntity> listReviewEntity;

    public List<ReviewEntity> getListReviewEntity() { return listReviewEntity; }

    public void setListReviewEntity(List<ReviewEntity> listReviewEntity) { this.listReviewEntity = listReviewEntity; }

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

    public List<BookOrderEntity> getListOrder() { return listOrder; }

    public void setListOrder(List<BookOrderEntity> listOrder) { this.listOrder = listOrder; }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return customerId == that.customerId &&
                Objects.equals(email, that.email) &&
                Objects.equals(fullname, that.fullname) &&
                Objects.equals(address, that.address) &&
                Objects.equals(city, that.city) &&
                Objects.equals(country, that.country) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(zipcode, that.zipcode) &&
                Objects.equals(password, that.password) &&
                Objects.equals(registerDate, that.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, email, fullname, address, city, country, phone, zipcode, password, registerDate);
    }
}
