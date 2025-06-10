package com.mst.semillero.tallerrcon.service;

import com.mst.semillero.tallerrcon.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AnimalServiceTest {
    @Mock
    private AnimalProvider animalProvider;
    @InjectMocks
    private AnimalService animalService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerAnimalPerro() {
        // Configurar mock para devolver un Perro
        when(animalProvider.crearAnimal("perro")).thenReturn(
            new Perro("Cremita", "Golden", "blanco con dorado", 10, "hembra"));
        // Llamar al método y verificar el resultado
        Animal animal = animalService.obtenerAnimal("perro");
        assertNotNull(animal);
        assertEquals("Cremita", animal.getNombre());
        assertEquals("Guau", animal.hacerSonido());
        // Verificar interacción con el mock
        verify(animalProvider).crearAnimal("perro");
    }

    @Test
    void testObtenerAnimalGato() {
        // Configurar mock para devolver un gato
        when(animalProvider.crearAnimal("gato")).thenReturn(
            new Gato("Eclipse", "criollo", "negro", 3, "macho"));
        // Llamar al método y verificar el resultado
        Animal animal = animalService.obtenerAnimal("gato");
        assertNotNull(animal);
        assertEquals("Eclipse", animal.getNombre());
        assertEquals("Miau", animal.hacerSonido());
        // Verificar interacción con el mock
        verify(animalProvider).crearAnimal("gato");
    }

    @Test
    void testObtenerAnimalConejo() {
        // Configurar mock para devolver un conejo
        when(animalProvider.crearAnimal("conejo")).thenReturn(
            new Conejo("Bunny", "criollo", "blanco con gris", 2, "macho"));
        // Llamar al método y verificar el resultado
        Animal animal = animalService.obtenerAnimal("conejo");
        assertNotNull(animal);
        assertEquals("Bunny", animal.getNombre());
        assertEquals("zzzzz", animal.hacerSonido());
        // Verificar interacción con el mock
        verify(animalProvider).crearAnimal("conejo");
    }

    @Test
    void testObtenerAnimalTipoDesconocido() {
        // Configurar mock para lanzar una excepción
        when(animalProvider.crearAnimal("pajaro")).thenThrow(new IllegalStateException("Unexpected value: pajaro"));
        // Verificar que se lanza la excepción
        Exception exception = assertThrows(IllegalStateException.class, () -> animalService.obtenerAnimal("pajaro"));
        assertEquals("Unexpected value: pajaro", exception.getMessage());
        // Verificar interacción con el mock
        verify(animalProvider).crearAnimal("pajaro");
    }

    @Test
    void testCrearAnimalPost() {
        // Crear request
        TipoAnimalRequest request = new TipoAnimalRequest("perro");
        // Configurar mock para devolver un Perro
        when(animalProvider.crearAnimal("perro")).thenReturn(
            new Perro("Cremita", "Golden", "blanco con dorado", 10, "hembra"));
        // Llamar al método y verificar el resultado
        Animal animal = animalService.crearAnimal(request);
        assertNotNull(animal);
        assertEquals("Cremita", animal.getNombre());
        assertEquals("Guau", animal.hacerSonido());
        // Verificar interacción con el mock
        verify(animalProvider).crearAnimal("perro");
    }
}
