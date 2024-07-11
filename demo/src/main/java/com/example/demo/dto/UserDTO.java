package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private List<ProductDTO> products;
}
