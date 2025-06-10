package com.mst.semillero.tallerrcon.dto;

/**
 * DTO para recibir el tipo de animal en el cuerpo de la petición POST
 */
public class TipoAnimalRequest {
    private String tipo;

    // Constructor por defecto necesario para la deserialización JSON
    public TipoAnimalRequest() {
    }

    public TipoAnimalRequest(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}