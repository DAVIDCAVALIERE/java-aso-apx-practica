package com.mst.semillero.tallerrcon.dto;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnimalProviderTest {

    @Test
    public void testCrearAnimalPerro() {
        AnimalProvider provider = new AnimalProvider();
        Animal animal = provider.crearAnimal("perro");

        assertTrue(animal instanceof Perro);
        assertEquals("Cremita", animal.getNombre());
        assertEquals("Golden", animal.getRaza());
        assertEquals("blanco con dorado", animal.getColor());
        assertEquals(10, animal.getEdad());
        assertEquals("hembra", animal.getSexo());
        assertEquals("Guau", animal.hacerSonido());

        Perro perro = (Perro) animal;
        assertEquals(25.0, perro.getPeso(), 0.01);
        assertEquals(60.0, perro.getAltura(), 0.01);
        assertEquals(7, perro.getNivelEntrenamiento());
        assertTrue(perro.isEsGuardian());
    }

    @Test
    public void testCrearAnimalGato() {
        AnimalProvider provider = new AnimalProvider();
        Animal animal = provider.crearAnimal("gato");

        assertTrue(animal instanceof Gato);
        assertEquals("Eclipse", animal.getNombre());
        assertEquals("criollo", animal.getRaza());
        assertEquals("negro", animal.getColor());
        assertEquals(3, animal.getEdad());
        assertEquals("macho", animal.getSexo());
        assertEquals("Miau", animal.hacerSonido());

        Gato gato = (Gato) animal;
        assertEquals(4.5, gato.getPeso(), 0.01);
        assertEquals(45.0, gato.getLongitud(), 0.01);
        assertEquals("suave", gato.getTipoMaullido());
        assertEquals(8, gato.getNivelCaza());
    }

    @Test
    public void testCrearAnimalConejo() {
        AnimalProvider provider = new AnimalProvider();
        Animal animal = provider.crearAnimal("conejo");

        assertTrue(animal instanceof Conejo);
        assertEquals("Bunny", animal.getNombre());
        assertEquals("criollo", animal.getRaza());
        assertEquals("blanco con gris", animal.getColor());
        assertEquals(2, animal.getEdad());
        assertEquals("macho", animal.getSexo());
        assertEquals("zzzzz", animal.hacerSonido());

        Conejo conejo = (Conejo) animal;
        assertEquals(2.5, conejo.getPeso(), 0.01);
        assertEquals(12.0, conejo.getLongitudOrejas(), 0.01);
        assertEquals(35.0, conejo.getVelocidadSalto(), 0.01);
        assertEquals("herbívoro", conejo.getTipoAlimentacion());
    }

    @Test
    public void testCrearAnimalDesconocido() {
        AnimalProvider provider = new AnimalProvider();

        Exception exception = assertThrows(IllegalStateException.class, () -> provider.crearAnimal("pajaro"));
        assertEquals("Unexpected value: pajaro", exception.getMessage());
    }

    @Test
    public void testConstructorVacio() {
        TipoAnimalRequest request = new TipoAnimalRequest();
        assertNull(request.getTipo()); // tipo debería ser null al usar el constructor vacío
    }

    @Test
    public void testConstructorConTipo() {
        TipoAnimalRequest request = new TipoAnimalRequest("gato");
        assertEquals("gato", request.getTipo());
    }
}
