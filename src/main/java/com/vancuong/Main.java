package com.vancuong;

import com.vancuong.entity.Product;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        testInsert();
        //testSelectAndUpdate();
//        testSelectAndDelete();

        List<Product> result = ProductRepository.findByName("san pham 1");
        for (Product product : result) {
            System.out.println(result);
        }
    }

    public static void testSelectAndDelete() {
        Product product = ProductRepository.findById(4);
        if (product != null) {
            ProductRepository.delete(product);
        }
    }

    public static void testSelectAndUpdate() {
        Product product = ProductRepository.findById(2);
        if (product != null) {
            product.setName("AAAAAAAAAAAAAAA");
            ProductRepository.saveOrUpdate(product);
        }
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
        session.saveOrUpdate(product); // lưu các đối tượng thực thể

        session.getTransaction().commit();
    }
}
