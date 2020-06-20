//package com.bookstore.service;
//
//import com.bookstore.dto.UserDTO;
//import com.bookstore.serviceimpl.impl.UserServiceImpl;
//import com.bookstore.serviceimpl.utils.SingletonServiceUtil;
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.Assert.assertEquals;
//
//public class UserServiceTest {
//    //Test findByProperty
//    public static void main(String[] args) {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setEmail("hoangdq@gmail.com");
//
//        Map<String, Object> mapProperty = new HashMap<>();
//        mapProperty.put("email", userDTO.getEmail());
//
//        Object[] objects = SingletonServiceUtil.getUserServiceInstance().findByProperty(mapProperty, true);
//        List<UserDTO> userDtoList = (List<UserDTO>) objects[1];
//
//        userDtoList.forEach((user) -> {
//            System.out.println(user.getFullName());
//        });
//    }
//
//    @Test
//    public void checkLogin(){
//        UserDTO userDTO = new UserDTO();
//        userDTO.setEmail("dieppn@gmail.com");
//        userDTO.setPassword("123456");
//
//        int expected = 48;
//        int actual = SingletonServiceUtil.getUserServiceInstance().isUserExist(userDTO).getUserId();
//
//        assertEquals(expected,actual);
//    }
//}
