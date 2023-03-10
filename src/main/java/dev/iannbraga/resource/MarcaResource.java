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

import dev.iannbraga.model.Marca;
import dev.iannbraga.repository.MarcaRepository;

@Path("/marcas")
public class MarcaResource {
    
    @Inject
    MarcaRepository marcaRepository;

    @POST
    @Transactional
    public Marca persist(Marca newMarca){
        Marca m = new Marca();
        m.setName(newMarca.getName().toUpperCase());
        marcaRepository.persist(m);
        return m;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Marca update(@PathParam("id") Long id, Marca receivedMarca){
        if(marcaRepository.findByIdOptional(id).isPresent()){
            Marca m = marcaRepository.findById(id);
            m.setName(receivedMarca.getName().toUpperCase());
            marcaRepository.persist(m);
            return m;
        }else{
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public String deleteById(@PathParam("id") Long id){
        boolean deleted = marcaRepository.deleteById(id);
        return deleted ? "Deleted with success" : "Not found";
    }

    @GET
    public List<Marca> listAll(){
        List<Marca> list = marcaRepository.findAll().list();
        return list;
    }
}
