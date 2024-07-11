package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.response.AllProductResponse;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    UserResponse getUserById(Long id);
    UserResponse createUser(User user);
    UserResponse updateUser(Long id, User userDetails);
    UserResponse deleteUser(Long id);
    //List<ProductDTO> getProductsByUserId(Long userId);
   AllProductResponse getProductsByUserId(Long userId);
}
