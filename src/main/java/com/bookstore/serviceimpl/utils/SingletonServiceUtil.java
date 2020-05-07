package com.bookstore.serviceimpl.utils;

import com.bookstore.service.UserService;
import com.bookstore.serviceimpl.impl.UserServiceImpl;

public class SingletonServiceUtil {
    private static UserService userService = null;

    public static UserService getUserServiceInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }
}
