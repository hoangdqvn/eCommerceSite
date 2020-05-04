package com.bookstore.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class OrderTest {
    public static void main(String[] args) throws IOException {
        BookEntity bookEntity = new BookEntity();
        BookOrderEntity bookOrderEntity = new BookOrderEntity();
        OrderDetailEntity orderDetailEntity = new OrderDetailEntity();

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setName("Math");
        categoryEntity.setCategoryId(12);

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(1);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(System.currentTimeMillis());

        //convert image to byte
        BufferedImage bImage = ImageIO.read(OrderTest.class.getResource("sample.jpg"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos );
        byte [] data = bos.toByteArray();

        bookEntity.setAuthor("Hoang DQ");
        bookEntity.setDescription("Good book!");
        bookEntity.setIsbn("123059310VN102");
        bookEntity.setLastUpdateTime(timestamp);
        bookEntity.setPrice(89.0);
        bookEntity.setPublishDate(date);
        bookEntity.setTitle("Math I");
        bookEntity.setCategoryEntity(categoryEntity);
        bookEntity.setImage(data);

        bookOrderEntity.setOrderDate(timestamp);
        bookOrderEntity.setPaymentMethod("COD");
        bookOrderEntity.setRecipientName("Dang Quang Huu");
        bookOrderEntity.setShippingAddress("ND-KC-HY");
        bookOrderEntity.setRecipientPhone("0353744859");
        bookOrderEntity.setStatus("Delivered!");
        bookOrderEntity.setCustomerEntity(customerEntity);

        Configuration configuration = new Configuration().configure();
//        configuration.addAnnotatedClass(CategoryEntity.class);
//        configuration.addAnnotatedClass(BookEntity.class);
//        configuration.addAnnotatedClass(BookOrderEntity.class);
        configuration.addAnnotatedClass(OrderDetailEntity.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
//        session.save(categoryEntity);
//        session.save(bookEntity);
//        session.save(bookOrderEntity);
        //User user = (User) session.get(User.class, new Long(40));
        BookOrderEntity bookOrderEntity1 = (BookOrderEntity) session.get(BookOrderEntity.class,22);
        BookEntity bookEntity1 = (BookEntity) session.get(BookEntity.class, 33);
        orderDetailEntity.setBookEntity(bookEntity1);
        orderDetailEntity.setBookOrderEntity(bookOrderEntity1);
        orderDetailEntity.setQuantity(5);
        orderDetailEntity.setSubtotal(445.0);
        session.save(orderDetailEntity);
        tx1.commit();
        session.close();

    }
}
