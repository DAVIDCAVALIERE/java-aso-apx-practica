package com.mst.semillero.tallerrcon.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnimalProviderTest {
    @Test
    public void testCrearAnimalPerro() {
        AnimalProvider provider = new AnimalProvider();
        Animal animal = provider.crearAnimal("perro");

        // Verificar que es un Perro y sus propiedades
        assertTrue(animal instanceof Perro);
        assertEquals("Cremita", animal.getNombre());
        assertEquals("Guau", animal.hacerSonido());
    }

    @Test
    public void testCrearAnimalGato() {
        AnimalProvider provider = new AnimalProvider();
        Animal animal = provider.crearAnimal("gato");

        // Verificar que es un Gato y sus propiedades
        assertTrue(animal instanceof Gato);
        assertEquals("Eclipse", animal.getNombre());
        assertEquals("Miau", animal.hacerSonido());
    }

    @Test
    public void testCrearAnimalDesconocido() {
        AnimalProvider provider = new AnimalProvider();

        // Verificar que lanza excepción con tipo desconocido
        Exception exception = assertThrows(IllegalArgumentException.class, () -> provider.crearAnimal("pajaro"));
        assertEquals("Tipo desconocido: pajaro", exception.getMessage());
    }
}
