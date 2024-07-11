package com.example.demo.dao;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    List<Product> getProductsByUserId(Long userId);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product productDetails);
    void deleteProduct(Long id);
}
