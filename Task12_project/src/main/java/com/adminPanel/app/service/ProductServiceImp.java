package com.adminPanel.app.service;

import com.adminPanel.app.dao.ProductDAO;
import com.adminPanel.app.exception.ValidationException;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public void save(Product product) {
        validateProduct(product);
        productDAO.save(product);
    }

    @Override
    public void update(Product product) {
        validateProduct(product);
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

    private void validateProduct(Product product) {

        if (product == null) {
            throw new ValidationException("Product cannot be null");
        }

        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new ValidationException("Product name cannot be empty");
        }

        if (product.getName().length() < 3) {
            throw new ValidationException("Product name must be at least 3 characters");
        }

        ProductDetails details = product.getProductDetails();

        if (details == null) {
            throw new ValidationException("Product details must be provided");
        }

        if (details.getManufacturer() == null || details.getManufacturer().trim().isEmpty()) {
            throw new ValidationException("Manufacturer cannot be empty");
        }

        if (details.getPrice() <= 0) {
            throw new ValidationException("Price must be greater than 0");
        }

        if (details.getExpirationDate() == null) {
            throw new ValidationException("Expiration date is required");
        }

        if (details.getExpirationDate().before(new Date())) {
            throw new ValidationException("Expiration date cannot be in the past");
        }
    }
}
