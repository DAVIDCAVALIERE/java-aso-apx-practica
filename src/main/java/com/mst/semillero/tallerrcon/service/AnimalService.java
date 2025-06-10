package com.mst.semillero.tallerrcon.service;

import com.mst.semillero.tallerrcon.dto.Animal;
import com.mst.semillero.tallerrcon.dto.AnimalProvider;
import com.mst.semillero.tallerrcon.dto.TipoAnimalRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.stereotype.Service;

// Servicio REST que utiliza AnimalProvider como dependencia inyectada
@Path("/animales") //Ruta base del endpoint
@Produces(MediaType.APPLICATION_JSON) //Tipo de respuesta JSON
@Consumes(MediaType.APPLICATION_JSON) //Tipo de petición JSON
@Service
public class AnimalService {
    private final AnimalProvider animalProvider;

    public AnimalService(AnimalProvider animalProvider) {
        this.animalProvider = animalProvider;
    }

    // Endpoint REST que utiliza POLIMORFISMO dinámico para devolver diferentes animales
    @GET
    @Path("/{tipo}") //Ruta del endpoint de la operación
    public Animal obtenerAnimal(@PathParam("tipo") String tipo) {
        return animalProvider.crearAnimal(tipo);
    }

    // Nuevo endpoint POST que recibe un JSON con el tipo de animal y responde con el animal correspondiente
    @POST
    public Animal crearAnimal(TipoAnimalRequest request) {
        return animalProvider.crearAnimal(request.getTipo());
    }
}
