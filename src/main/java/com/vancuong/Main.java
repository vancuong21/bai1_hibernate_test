package com.vancuong;

import com.vancuong.entity.Product;
import org.hibernate.Session;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        //testInsert();
        //testSelectAndUpdate();
        testSelectAndDelete();
    }

    public static void testSelectAndDelete() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.getTransaction().begin();

        Product product = session.find(Product.class, 2);
        if(product != null) {
            session.delete(product);
        }

        session.getTransaction().commit();
    }

    public static void testSelectAndUpdate() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.getTransaction().begin();

        Product product = session.find(Product.class, 2);
        if (product != null) {
            product.setPrice(8888.88);
            product.setUpdateDate(LocalDateTime.now());
            product.setName("Update name");

            session.saveOrUpdate(product);
            //session.merge(product);
        }

        session.getTransaction().commit();

        System.out.println(product);
    }

    public static void testInsert() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.getTransaction().begin();

        Product product = new Product();

        product.setName("San pham 1");
        product.setPrice(99.999);
        product.setCreatedDate(LocalDateTime.now());
        product.setUpdateDate(LocalDateTime.now());

        //session.save(product);
        session.persist(product); // lưu các đối tượng thực thể

        session.getTransaction().commit();
    }
}
