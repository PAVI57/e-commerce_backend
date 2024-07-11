package com.example.demo.mapper;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
@Service
public class ResponseMapper {

   public static UserDTO convert(User user, UserDTO userDTO) {
       userDTO.setUserId(user.getUserId());
       userDTO.setFirstName(user.getFirstName());
       userDTO.setLastName(user.getLastName());
       userDTO.setEmail(user.getEmail());
       userDTO.setPhoneNumber(user.getPhoneNumber());
       userDTO.setAddress(user.getAddress());
       return userDTO;
   }

   public static ProductDTO convert(Product product, ProductDTO productDTO) {
     productDTO.setProductId(product.getProductId());
     productDTO.setProductName(product.getProductName());
       productDTO.setProductBrand(product.getProductBrand());
     productDTO.setProductCategory(product.getProductCategory());
     productDTO.setProductPrice(product.getProductPrice());
     productDTO.setProductQuantity(product.getProductQuantity());
     return productDTO;
   }
}
