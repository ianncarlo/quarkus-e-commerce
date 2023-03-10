package dev.iannbraga.dto;

import java.math.BigDecimal;

import dev.iannbraga.model.Product;
import lombok.Getter;

@Getter
public class ProductResponseDTO {
    
    private String codigo;
    private String descricao;
    private BigDecimal preco;
    private int estoque;
    private String marca;

    public ProductResponseDTO(Product p){
        this.codigo = p.getCodigo();
        this.descricao = p.getDescricao();
        this.preco = p.getPreco();
        this.estoque = p.getEstoque();
        this.marca = p.getMarca().getName();
    }
}
