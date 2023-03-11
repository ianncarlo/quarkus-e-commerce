package dev.iannbraga.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String code;
    
    private String description;
    
    private BigDecimal price;
    
    private int stock;
    
    @ManyToOne
    @JoinColumn(name = "id_brand_fk")
    private Brand brand;
    
}
