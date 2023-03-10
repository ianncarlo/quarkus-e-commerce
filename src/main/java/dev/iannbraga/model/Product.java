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
    
    private String codigo;
    
    private String descricao;
    
    private BigDecimal preco;
    
    @ManyToOne
    @JoinColumn(name = "id_marca_fk")
    private Marca marca;
    
    private int estoque;
}
