package com.example.demo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_Id")
    private Long productId;
    @Column(name = "Product_Name")
    private String productName;
    @Column(name = "Product_Brand")
    private String productBrand;
    @Column(name = "Product_Category")
    private String productCategory;
    @Column(name = "Product_Price")
    private double productPrice;
    @Column(name = "Product_Quantity")
    private int productQuantity;

    @ManyToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private User user;
}
