package dev.iannbraga.repository;

import javax.enterprise.context.ApplicationScoped;

import dev.iannbraga.model.Brand;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class BrandRepository implements PanacheRepository<Brand>{
    
}
