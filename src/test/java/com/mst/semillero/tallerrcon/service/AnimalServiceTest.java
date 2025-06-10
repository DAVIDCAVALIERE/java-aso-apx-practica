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
        Perro perro = new Perro("Cremita", "Golden", "blanco con dorado", 10, "hembra");
        when(animalProvider.crearAnimal("perro")).thenReturn(perro);

        Animal result = animalService.obtenerAnimal("perro");

        assertNotNull(result);
        assertEquals("Cremita", result.getNombre());
        assertEquals("Golden", result.getRaza());
        assertEquals("blanco con dorado", result.getColor());
        assertEquals(10, result.getEdad());
        assertEquals("hembra", result.getSexo());
        assertEquals("Guau", result.hacerSonido());

        assertInstanceOf(Perro.class, result);
        Perro p = (Perro) result;
        assertEquals(25.0, p.getPeso());
        assertEquals(60.0, p.getAltura());
        assertEquals(7, p.getNivelEntrenamiento());
        assertTrue(p.isEsGuardian());

        verify(animalProvider).crearAnimal("perro");
    }

    @Test
    void testObtenerAnimalGato() {
        Gato gato = new Gato("Eclipse", "criollo", "negro", 3, "macho");
        when(animalProvider.crearAnimal("gato")).thenReturn(gato);

        Animal result = animalService.obtenerAnimal("gato");

        assertNotNull(result);
        assertEquals("Eclipse", result.getNombre());
        assertEquals("criollo", result.getRaza());
        assertEquals("negro", result.getColor());
        assertEquals(3, result.getEdad());
        assertEquals("macho", result.getSexo());
        assertEquals("Miau", result.hacerSonido());

        assertInstanceOf(Gato.class, result);
        Gato g = (Gato) result;
        assertEquals(4.5, g.getPeso());
        assertEquals(45.0, g.getLongitud());
        assertEquals("suave", g.getTipoMaullido());
        assertEquals(8, g.getNivelCaza());

        verify(animalProvider).crearAnimal("gato");
    }

    @Test
    void testObtenerAnimalConejo() {
        Conejo conejo = new Conejo("Bunny", "criollo", "blanco con gris", 2, "macho");
        when(animalProvider.crearAnimal("conejo")).thenReturn(conejo);

        Animal result = animalService.obtenerAnimal("conejo");

        assertNotNull(result);
        assertEquals("Bunny", result.getNombre());
        assertEquals("criollo", result.getRaza());
        assertEquals("blanco con gris", result.getColor());
        assertEquals(2, result.getEdad());
        assertEquals("macho", result.getSexo());
        assertEquals("zzzzz", result.hacerSonido());

        assertInstanceOf(Conejo.class, result);
        Conejo c = (Conejo) result;
        assertEquals(2.5, c.getPeso());
        assertEquals(12.0, c.getLongitudOrejas());
        assertEquals(35.0, c.getVelocidadSalto());
        assertEquals("herbívoro", c.getTipoAlimentacion());

        verify(animalProvider).crearAnimal("conejo");
    }

    @Test
    void testObtenerAnimalTipoDesconocido() {
        when(animalProvider.crearAnimal("pajaro")).thenThrow(new IllegalStateException("Unexpected value: pajaro"));

        Exception exception = assertThrows(IllegalStateException.class, () -> animalService.obtenerAnimal("pajaro"));

        assertEquals("Unexpected value: pajaro", exception.getMessage());
        verify(animalProvider).crearAnimal("pajaro");
    }

    @Test
    void testCrearAnimalPost() {
        TipoAnimalRequest request = new TipoAnimalRequest("perro");
        Perro perro = new Perro("Cremita", "Golden", "blanco con dorado", 10, "hembra");
        when(animalProvider.crearAnimal("perro")).thenReturn(perro);

        Animal result = animalService.crearAnimal(request);

        assertNotNull(result);
        assertEquals("Cremita", result.getNombre());
        assertEquals("Guau", result.hacerSonido());

        verify(animalProvider).crearAnimal("perro");
    }

    @Test
    void testCrearAnimalPostTipoDesconocido() {
        TipoAnimalRequest request = new TipoAnimalRequest("tortuga");
        when(animalProvider.crearAnimal("tortuga")).thenThrow(new IllegalStateException("Unexpected value: tortuga"));

        Exception exception = assertThrows(IllegalStateException.class, () -> animalService.crearAnimal(request));

        assertEquals("Unexpected value: tortuga", exception.getMessage());
        verify(animalProvider).crearAnimal("tortuga");
    }

    @Test
    void testConstructor() {
        AnimalProvider provider = mock(AnimalProvider.class);
        AnimalService service = new AnimalService(provider);
        assertNotNull(service);
    }
}
