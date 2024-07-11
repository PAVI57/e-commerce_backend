package com.example.demo.dto.response;

import com.example.demo.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private ProductDTO productDTO;
    private String statusCode;
    private StatusMessage statusMessage;
}
