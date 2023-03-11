package dev.iannbraga.dto;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class ProductDTO {
    
    private String code;
    private String description;
    private BigDecimal price;
    private int stock;
    private Long idBrand;
}
