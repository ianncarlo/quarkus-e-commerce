package dev.iannbraga.dto;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class ProductDTO {
    
    private String codigo;
    private String descricao;
    private BigDecimal preco;
    private int estoque;
    private Long idMarca;
}
