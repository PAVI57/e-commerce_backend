package com.example.demo.dao;

import com.example.demo.model.Product;
import com.example.demo.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User userDetails);
    void deleteUser(Long id);
    List<Product> getProductsByUserId(Long userId);
}
