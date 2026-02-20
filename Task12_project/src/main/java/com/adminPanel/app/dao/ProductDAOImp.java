package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.util.HibernateUtil;
import lombok.Getter;
import lombok.Setter;
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
         sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public void update(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    @Override
    public void delete(Product product) {
        sessionFactory.getCurrentSession().delete(product);
    }

    @Override
    public Product findById(int id) {
        return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public List<Product> getAllProducts() {
        return sessionFactory.getCurrentSession().createQuery("from list").list();
    }

}
