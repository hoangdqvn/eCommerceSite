package com.bookstore.serviceimpl.utils;

import com.bookstore.daoimpl.*;

public class SingletonDaoUtil {
    private static UserDAOImpl userDAOImpl = null;
    private static BookDAOImpl bookDAOImpl = null;
    private static BookOrderDAOImpl bookOrderDAOImpl = null;
    private static CategoryDAOImpl categoryDAOImpl = null;
    private static CustomerDAOImpl customerDAOImpl = null;
    private static OrderDetailDAOImpl orderDetailDAOImpl = null;
    private static ReviewDAOImpl reviewDAOImpl = null;

    public static UserDAOImpl getUserDaoInstance() {
        if (userDAOImpl == null) {
            userDAOImpl = new UserDAOImpl();
        }
        return userDAOImpl;
    }

    public static BookDAOImpl getBookDaoInstance() {
        if (bookDAOImpl == null){
            bookDAOImpl = new BookDAOImpl();
        }
        return bookDAOImpl;
    }

    public static BookOrderDAOImpl getBookOrderDaoInstance() {
        if (bookOrderDAOImpl == null){
            bookOrderDAOImpl = new BookOrderDAOImpl();
        }
        return bookOrderDAOImpl;
    }

    public static CategoryDAOImpl getCategoryDaoInstance() {
        if (categoryDAOImpl == null){
            categoryDAOImpl = new CategoryDAOImpl();
        }
        return categoryDAOImpl;
    }

    public static CustomerDAOImpl getCustomerDaoInstance() {
        if (customerDAOImpl == null){
            customerDAOImpl = new CustomerDAOImpl();
        }
        return customerDAOImpl;
    }

    public static OrderDetailDAOImpl getOrderDetailDaoInstance() {
        if (orderDetailDAOImpl == null){
            orderDetailDAOImpl = new OrderDetailDAOImpl();
        }
        return orderDetailDAOImpl;
    }

    public static ReviewDAOImpl getReviewDaoInstance() {
        if (reviewDAOImpl == null){
            reviewDAOImpl = new ReviewDAOImpl();
        }
        return reviewDAOImpl;
    }
}
