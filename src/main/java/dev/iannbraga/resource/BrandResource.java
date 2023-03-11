package dev.iannbraga.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import dev.iannbraga.model.Brand;
import dev.iannbraga.repository.BrandRepository;

@Path("/brands")
public class BrandResource {
    
    @Inject
    BrandRepository brandRepository;

    @POST
    @Transactional
    public Brand persist(Brand newBrand){
        Brand m = new Brand();
        m.setName(newBrand.getName().toUpperCase());
        brandRepository.persist(m);
        return m;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Brand update(@PathParam("id") Long id, Brand receivedBrand){
        if(brandRepository.findByIdOptional(id).isPresent()){
            Brand m = brandRepository.findById(id);
            m.setName(receivedBrand.getName().toUpperCase());
            brandRepository.persist(m);
            return m;
        }else{
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public String deleteById(@PathParam("id") Long id){
        boolean deleted = brandRepository.deleteById(id);
        return deleted ? "Deleted with success" : "Not found";
    }

    @GET
    public List<Brand> listAll(){
        List<Brand> list = brandRepository.findAll().list();
        return list;
    }
}
