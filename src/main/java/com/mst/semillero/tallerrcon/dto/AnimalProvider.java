package com.mst.semillero.tallerrcon.dto;

import org.springframework.stereotype.Component;

@Component
public class AnimalProvider {
    public Animal crearAnimal(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "perro" -> new Perro("Cremita", "Golden", "blanco con dorado", 10, "hembra");
            case "gato" -> new Gato("Eclipse", "criollo", "negro", 3, "macho");
            case "conejo" -> new Conejo("Bunny", "criollo", "blanco con gris", 2, "macho");
            default -> throw new IllegalStateException("Unexpected value: " + tipo.toLowerCase());
        };
    }
}
