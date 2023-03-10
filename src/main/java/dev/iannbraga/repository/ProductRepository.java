package dev.iannbraga.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.iannbraga.model.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product>{

    public List<Product> listAllOrdenated(){
        List<Product> list = find("order by id").list();
        return list;
    }
    public List<Product> findByDescricao(String descricao) {
        String like = "%"+descricao+"%";
        return find("descricao like ?1", like).list();
    }    
}
