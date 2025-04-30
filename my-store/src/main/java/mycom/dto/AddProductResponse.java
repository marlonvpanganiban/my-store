package mycom.dto;

import mycom.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddProductResponse {

    private String status;
    private String error;
    private Product product;
    
}
