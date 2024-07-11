package com.example.demo.Controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.response.AllProductResponse;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponse> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return new ResponseEntity<>(userService.updateUser(id, userDetails), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }

    @GetMapping("/{userId}/products")
    public ResponseEntity<AllProductResponse> getProductsByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.getProductsByUserId(userId), HttpStatus.OK);
    }



}
