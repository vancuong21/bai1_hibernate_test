package com.vancuong.repository;

import com.vancuong.entity.Product;
import com.vancuong.utils.HibernateUtils;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProductRepository {
    // tim theo name
    public static List<Product> findByName(String name) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query<Product> query = session.createQuery("FROM Product WHERE name = :productName", Product.class);
        query.setParameter("productName", name);
        try {
            return query.getResultList();
        } catch (NoResultException exception) {
            return null;
        }

    }

    // tim kiem id
    public static Product findById(Integer id) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        return session.find(Product.class, id);
    }

    // save or update
    public static Product saveOrUpdate(Product product) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(product);

        session.getTransaction().commit();
        return product;
    }

    // delete
    public static Product delete(Product product) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(product);
        session.getTransaction().commit();
        return product;
    }
}
