package com.example.demo.Controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.response.AllProductResponse;
import com.example.demo.dto.response.ProductResponse;
import com.example.demo.dto.response.StatusMessage;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<AllProductResponse> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        System.out.println(productDetails);
        return new ResponseEntity<>(productService.updateProduct(id, productDetails), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<AllProductResponse> getProductsByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(productService.getProductsByUserId(userId), HttpStatus.OK);
    }
}
