package com.adminPanel.app.service;

import com.adminPanel.app.model.Product;
import java.util.List;

public interface ProductService {

    void save(Product product);
    void update(Product product);
    void delete(int id);
    Product findById(int id);
    List<Product> findAll();
}
