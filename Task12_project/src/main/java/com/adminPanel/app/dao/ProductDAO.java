package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;

import java.util.List;

public interface ProductDAO {
    void save(Product product);
    void update(Product product);
    void delete(Product product);
    Product findById(int id);
    List<Product> getAllProducts();
}
