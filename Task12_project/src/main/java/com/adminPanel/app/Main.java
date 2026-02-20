package com.adminPanel.app;

import com.adminPanel.app.dao.ProductDAOImp;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

import java.util.List;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ProductDAOImp dao = new ProductDAOImp();

        Product product = new Product("prooo");
        ProductDetails productDetails = new ProductDetails("pd1", new Date(), "m1", 300.0, true);
        productDetails.setProduct(product);
        product.setProductDetails(productDetails);

        dao.save(product);
        System.out.println("Saved: " + product);


        product.setName("updated name");
        product.getProductDetails().setPrice(350.0);
        dao.update(product);
        System.out.println("Updated: " + product);


        List<Product> products = dao.getAllProducts();
        System.out.println("All Products:");
        for (Product p : products) {
            System.out.println(p + " - Details: " + p.getProductDetails());
        }


        Product p1 = dao.findById(product.getId());
        System.out.println("Found: " + p1 + " - Details: " + p1.getProductDetails());
//        dao.delete(p1);
//        System.out.println("Deleted: " + p1);
    }
}
