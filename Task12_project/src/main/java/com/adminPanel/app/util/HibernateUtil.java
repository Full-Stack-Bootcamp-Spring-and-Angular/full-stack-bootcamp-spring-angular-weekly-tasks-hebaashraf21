package com.adminPanel.app.util;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    @Getter
    private final static SessionFactory sessionFactory = new Configuration()
            .configure("hibernate-config.xml")
            .addAnnotatedClass(Product.class)
            .addAnnotatedClass(ProductDetails.class)
            .buildSessionFactory();

}
