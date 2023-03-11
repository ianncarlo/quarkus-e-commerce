package dev.iannbraga.dto;

import java.math.BigDecimal;

import dev.iannbraga.model.Product;
import lombok.Getter;

@Getter
public class ProductResponseDTO {
    
    private String code;
    private String description;
    private BigDecimal price;
    private int stock;
    private String brand;

    public ProductResponseDTO(Product p){
        this.code = p.getCode();
        this.description = p.getDescription();
        this.price = p.getPrice();
        this.stock = p.getStock();
        this.brand = p.getBrand().getName();
    }
}
