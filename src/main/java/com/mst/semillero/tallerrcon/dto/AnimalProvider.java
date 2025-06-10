package com.mst.semillero.tallerrcon.dto;

import org.springframework.stereotype.Component;

@Component
public class AnimalProvider {
    public Animal crearAnimal(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "perro" -> new Perro("Cremita");
            case "gato" -> new Gato("Eclipse");
            default -> throw new IllegalStateException("Unexpected value: " + tipo.toLowerCase());
        };
    }
}
