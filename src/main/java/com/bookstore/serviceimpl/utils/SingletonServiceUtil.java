package com.bookstore.serviceimpl.utils;

import com.bookstore.service.BookService;
import com.bookstore.service.CategoryService;
import com.bookstore.service.UserService;
import com.bookstore.serviceimpl.impl.BookServiceImpl;
import com.bookstore.serviceimpl.impl.CategoryServiceImpl;
import com.bookstore.serviceimpl.impl.UserServiceImpl;

public class SingletonServiceUtil {
    private static UserService userService = null;
    private static CategoryService categoryService = null;
    private static BookService bookService = null;

    public static UserService getUserServiceInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    public static CategoryService getCategoryServiceInstance(){
        if (categoryService == null){
            categoryService = new CategoryServiceImpl();
        }
        return categoryService;
    }

    public static BookService getBookServiceInstance(){
        if (bookService == null){
            bookService = new BookServiceImpl();
        }
        return bookService;
    }
}
