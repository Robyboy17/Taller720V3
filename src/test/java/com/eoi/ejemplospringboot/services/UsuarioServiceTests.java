package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.entities.Usuario;
import com.eoi.ejemplospringboot.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UsuarioServiceTests {

    @Mock
    private JpaRepository<Usuario, Integer> repository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    /*
    @Test
    public void testListAll() {
        List<Usuario> usuarios = new ArrayList<>();
        //usuarios.add(new Usuario("John", "Doe"));
        //usuarios.add(new Usuario("Jane", "Smith"));

        when(repository.findAll()).thenReturn(usuarios);

        List<Usuario> result = usuarioService.listAll();

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getNombre());
        assertEquals("Doe", result.get(0).getApellido());
        assertEquals("Jane", result.get(1).getNombre());
        assertEquals("Smith", result.get(1).getApellido());

        verify(repository, times(1)).findAll();
        verifyNoMoreInteractions(repository);
    }


    @Test
    public void testGetById() {
        Usuario usuario = new Usuario( "John", "Doe");

        when(repository.findById(1)).thenReturn(Optional.of(usuario));

        Usuario result = usuarioService.getById(1);

        assertEquals("John", result.getNombre());
        assertEquals("Doe", result.getApellido());

        verify(repository, times(1)).findById(1);
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void testGetByIdNotFound() {
        when(repository.findById(1)).thenReturn(Optional.empty());

        assertThrows(MiEntidadNoEncontradaException.class, () -> {
            usuarioService.getById(1);
        });

        verify(repository, times(1)).findById(1);
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void testCreate() {
        Usuario usuario = new Usuario("John", "Doe");

        when(repository.saveAndFlush(usuario)).thenReturn(usuario);

        Usuario result = usuarioService.create(usuario);

        assertEquals("John", result.getNombre());
        assertEquals("Doe", result.getApellido());

        verify(repository, times(1)).saveAndFlush(usuario);
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void testUpdate() {
        Usuario usuario = new Usuario("John", "Doe");

        when(repository.saveAndFlush(usuario)).thenReturn(usuario);

        Usuario result = usuarioService.update(usuario);

        assertEquals("John", result.getNombre());
        assertEquals("Doe", result.getApellido());

        verify(repository, times(1)).saveAndFlush(usuario);
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void testDelete() {
        usuarioService.delete(1);

        verify(repository, times(1)).deleteById(1);
        verifyNoMoreInteractions(repository);
    }
    */

}
