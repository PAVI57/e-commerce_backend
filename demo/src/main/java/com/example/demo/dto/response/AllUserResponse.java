package com.example.demo.dto.response;

import com.example.demo.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllUserResponse {
    private List<UserDTO> userDTOList;
    private String statusCode;
    private StatusMessage statusMessage;
}
