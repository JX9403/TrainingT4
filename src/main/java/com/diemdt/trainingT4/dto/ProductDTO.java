package com.diemdt.trainingT4.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;

    @NotBlank(message = "Product name is required")
    private String name ;

    @Positive(message = "Cannot be negative")
    private Double price;

    private Long categoryId ;

}
