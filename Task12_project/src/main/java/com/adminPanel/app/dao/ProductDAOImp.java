package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.util.HibernateUtil;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("singleton")
@Setter
@Getter
public class ProductDAOImp implements ProductDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void save(Product product) {
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Product product) {
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            Product product = (Product) session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            List<Product> products =
                    session.createQuery("from Product")
                            .list();
            session.getTransaction().commit();
            return products;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
