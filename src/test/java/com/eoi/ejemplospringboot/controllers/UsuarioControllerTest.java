package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.MyControllerTestInterface;
import com.eoi.ejemplospringboot.abstractcomponents.GenericServiceWithJPA;
import com.eoi.ejemplospringboot.entities.Usuario;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes= UsuarioController.class)
@AutoConfigureMockMvc
public class UsuarioControllerTest implements MyControllerTestInterface {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GenericServiceWithJPA<Usuario, ?> userService;

    @Test
    @WithMockUser(username="admin@test.com")
    public void testGetAll() throws Exception {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario());
        usuarios.add(new Usuario());

        Mockito.when(userService.listAll()).thenReturn(usuarios);

        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("entities"))
                .andExpect(MockMvcResultMatchers.view().name("usuarios/all-entities"));
    }

    @Test
    @WithMockUser(username="admin@test.com")
    public void testGetById() throws Exception {
        Usuario usuario = new Usuario();
        Object usuarioId = 1;

        Mockito.when(userService.getById(usuarioId)).thenReturn(usuario);

        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/{id}", usuarioId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                ///.andExpect(MockMvcResultMatchers.model().attributeExists("entity"))
                .andExpect(MockMvcResultMatchers.view().name("usuarios/entity-details"));
    }

    @Test
    @WithMockUser(username="admin@test.com")

    public void testGetById_InvalidId() throws Exception {
        Mockito.when(userService.getById(1)).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("usuarios/entity-details"));
    }


    @Test
    @WithMockUser(username="admin@test.com")

    public void testCreate() throws Exception {
        Usuario usuario = new Usuario();

        Mockito.when(userService.create(Mockito.any())).thenReturn(usuario);

        mockMvc.perform(MockMvcRequestBuilders.post("/usuarios/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.model().attributeExists("entity"))
                .andExpect(MockMvcResultMatchers.view().name("usuarios/entity-details"));
    }

    @Test
    @WithMockUser(username="admin@test.com")

    public void testUpdate() throws Exception {
        Usuario usuario = new Usuario();
        Object usuarioId = 1;

        Mockito.when(userService.update( Mockito.any())).thenReturn(usuario);

        mockMvc.perform(MockMvcRequestBuilders.put("/usuarios/{id}", usuarioId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.model().attributeExists("entity"))
                .andExpect(MockMvcResultMatchers.view().name("usuarios/entity-details"));
    }

    @Test
    @WithMockUser(username="admin@test.com")

    public void testDelete() throws Exception {
        Object usuarioId = 1;

        mockMvc.perform(MockMvcRequestBuilders.delete("/usuarios/{id}", usuarioId))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/usuarios/all"));
    }
}
