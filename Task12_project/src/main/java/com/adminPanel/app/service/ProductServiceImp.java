package com.adminPanel.app.service;

import com.adminPanel.app.dao.ProductDAO;
import com.adminPanel.app.exception.ValidationException;
import com.adminPanel.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    public void update(Product product) {
        productDAO.update(product);
    }

    @Override
    public void delete(int id) {
        Product product = productDAO.findById(id);
        if (product == null) {
            throw new ValidationException("Product not found with id: " + id);
        }
        productDAO.delete(product);
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.getAllProducts();
    }

}
