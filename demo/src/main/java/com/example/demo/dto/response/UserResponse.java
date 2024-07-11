package com.example.demo.dto.response;

import com.example.demo.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private UserDTO userDTO;
    private String statusCode;
    private StatusMessage statusMessage;
}
