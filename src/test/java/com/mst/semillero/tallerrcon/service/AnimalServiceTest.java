package com.mst.semillero.tallerrcon.service;


import com.mst.semillero.tallerrcon.dto.Animal;
import com.mst.semillero.tallerrcon.dto.AnimalProvider;
import com.mst.semillero.tallerrcon.dto.Gato;
import com.mst.semillero.tallerrcon.dto.Perro;
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
        when(animalProvider.crearAnimal("perro")).thenReturn(new Perro("Cremita"));
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
        when(animalProvider.crearAnimal("gato")).thenReturn(new Gato("Eclipse"));
        // Llamar al método y verificar el resultado
        Animal animal = animalService.obtenerAnimal("gato");
        assertNotNull(animal);
        assertEquals("Eclipse", animal.getNombre());
        assertEquals("Miau", animal.hacerSonido());
        // Verificar interacción con el mock
        verify(animalProvider).crearAnimal("gato");
    }

    @Test
    void testObtenerAnimalTipoDesconocido() {
        // Configurar mock para lanzar una excepción
        when(animalProvider.crearAnimal("pajaro")).thenThrow(new IllegalArgumentException("Tipo desconocido: pajaro"));
        // Verificar que se lanza la excepción
        Exception exception = assertThrows(IllegalArgumentException.class, () -> animalService.obtenerAnimal("pajaro"));
        assertEquals("Tipo desconocido: pajaro", exception.getMessage());
        // Verificar interacción con el mock
        verify(animalProvider).crearAnimal("pajaro");
    }
}
