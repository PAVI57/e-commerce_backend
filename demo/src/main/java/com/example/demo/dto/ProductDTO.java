package com.example.demo.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long productId;
    private String productName;
    private String productBrand;
    private String productCategory;
    private double productPrice;
    private int productQuantity;
}
