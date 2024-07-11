package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.response.AllProductResponse;
import com.example.demo.dto.response.ProductResponse;
import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    AllProductResponse getAllProducts();
    ProductResponse getProductById(Long id);
    AllProductResponse getProductsByUserId(Long userId);
    ProductResponse createProduct(Product product);
    ProductResponse updateProduct(Long id, Product productDetails);
    ProductResponse deleteProduct(Long id);
}
