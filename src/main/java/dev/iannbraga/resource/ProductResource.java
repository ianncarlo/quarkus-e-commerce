package dev.iannbraga.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import dev.iannbraga.dto.ProductDTO;
import dev.iannbraga.dto.ProductResponseDTO;
import dev.iannbraga.model.Product;
import dev.iannbraga.repository.BrandRepository;
import dev.iannbraga.repository.ProductRepository;

@Path("/products")
public class ProductResource {
    
    @Inject
    ProductRepository productRepository;

    @Inject
    BrandRepository brandRepository;

    @POST
    @Transactional
    public ProductResponseDTO persist(ProductDTO newProduct){
        Product p = new Product();
        p.setCode(newProduct.getCode());
        p.setDescription(newProduct.getDescription().toUpperCase());
        p.setStock(newProduct.getStock());
        p.setPrice(newProduct.getPrice());
        p.setBrand(brandRepository.findById(newProduct.getIdBrand()));
        productRepository.persist(p);
        
        return new ProductResponseDTO(p);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public ProductResponseDTO update(@PathParam("id") Long id, ProductDTO receiveProduct){
        Product p = productRepository.findById(id);
        p.setCode(receiveProduct.getCode());
        p.setDescription(receiveProduct.getDescription().toUpperCase());
        p.setStock(receiveProduct.getStock());
        p.setPrice(receiveProduct.getPrice());
        p.setBrand(brandRepository.findById(receiveProduct.getIdBrand()));
        
        return new ProductResponseDTO(p);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public String deleteById(@PathParam("id") Long id){
        boolean deleted = productRepository.deleteById(id);
        return deleted ? "Deleted with success" : "Not found";
    }
    
    @GET
    public List<ProductResponseDTO> listAll(){
        List<ProductResponseDTO> list = productRepository.listAllOrdenated().stream().map(product -> new ProductResponseDTO(product)).collect(Collectors.toList());
        return list;
    }

    @GET
    @Path("/{id}")
    public ProductResponseDTO findById(@PathParam("id") Long id){
        ProductResponseDTO entity = new ProductResponseDTO(productRepository.findById(id));
        return entity;
    }

    @GET
    @Path("/search/{descricao}")
    public List<ProductResponseDTO> findByName(@PathParam("descricao") String descricao){
        descricao.toUpperCase();
        List<ProductResponseDTO> list = productRepository.findByDescricao(descricao).stream().map(product -> new ProductResponseDTO(product)).collect(Collectors.toList());
        return list;
    }
}
