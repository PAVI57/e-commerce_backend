package com.example.demo.dto.response;

import com.example.demo.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllProductResponse {
    private List<ProductDTO> productDTOList;
    private String statusCode;
    private StatusMessage statusMessage;
}
