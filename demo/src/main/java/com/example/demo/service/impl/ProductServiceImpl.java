package com.example.demo.service.impl;

import com.example.demo.constants.Codes;
import com.example.demo.dao.ProductDAO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.response.AllProductResponse;
import com.example.demo.dto.response.ProductResponse;
import com.example.demo.dto.response.StatusMessage;
import com.example.demo.mapper.ResponseMapper;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public AllProductResponse getAllProducts() {
        List<Product> productList = productDAO.getAllProducts();
        List<ProductDTO> productDTOList = new ArrayList<>(productList.size());

        for (Product product : productList) {
            ProductDTO productDTO = ResponseMapper.convert(product, new ProductDTO());
            productDTOList.add(productDTO);
        }

        StatusMessage statusMessage = new StatusMessage(Codes.SUCCESS_MSG, Codes.SUCCESS_DESC);
        return new AllProductResponse(productDTOList, Codes.SUCCESS, statusMessage);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productDAO.getProductById(id);
        ProductDTO productDTO = ResponseMapper.convert(product, new ProductDTO());
        StatusMessage statusMessage = new StatusMessage(Codes.SUCCESS_MSG, Codes.SUCCESS_DESC);
        return new ProductResponse(productDTO, Codes.SUCCESS, statusMessage);
    }

    @Override
    public AllProductResponse getProductsByUserId(Long userId) {
        List<Product> productList = productDAO.getProductsByUserId(userId);
        List<ProductDTO> productDTOList = new ArrayList<>(productList.size());

        for (Product product : productList) {
            ProductDTO productDTO = ResponseMapper.convert(product, new ProductDTO());
            productDTOList.add(productDTO);
        }

        StatusMessage statusMessage = new StatusMessage(Codes.SUCCESS_MSG, Codes.SUCCESS_DESC);
        return new AllProductResponse(productDTOList, Codes.SUCCESS, statusMessage);
    }

    @Override
    public ProductResponse createProduct(Product product) {
        productDAO.createProduct(product);
        ProductDTO productDTO = ResponseMapper.convert(product, new ProductDTO());
        StatusMessage statusMessage = new StatusMessage(Codes.SUCCESS_MSG, Codes.SUCCESS_DESC);
        return new ProductResponse(productDTO, Codes.SUCCESS, statusMessage);
    }

    @Override
    public ProductResponse updateProduct(Long id, Product productDetails) {
        Product product = productDAO.getProductById(id);
        product.setProductId(id);
        product.setProductName(productDetails.getProductName());
        product.setProductBrand(productDetails.getProductBrand());
        product.setProductCategory(productDetails.getProductCategory());
        product.setProductPrice(productDetails.getProductPrice());
        product.setProductQuantity(productDetails.getProductQuantity());

        productDAO.createProduct(product);
        ProductDTO productDTO = ResponseMapper.convert(product, new ProductDTO());
        StatusMessage statusMessage = new StatusMessage(Codes.SUCCESS_MSG, Codes.SUCCESS_DESC);
        return new ProductResponse(productDTO, Codes.SUCCESS, statusMessage);
    }

    @Override
    public ProductResponse deleteProduct(Long id) {
        Product product = productDAO.getProductById(id);
        productDAO.deleteProduct(product.getProductId());
        ProductDTO productDTO = ResponseMapper.convert(product, new ProductDTO());
        StatusMessage statusMessage = new StatusMessage(Codes.SUCCESS_MSG, Codes.SUCCESS_DESC);
        return new ProductResponse(productDTO, Codes.SUCCESS, statusMessage);
    }
}
