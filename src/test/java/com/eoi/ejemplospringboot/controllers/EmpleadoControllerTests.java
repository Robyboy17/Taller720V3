package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.MyControllerTestInterface;
import com.eoi.ejemplospringboot.entities.Empleado;
import com.eoi.ejemplospringboot.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.eoi.ejemplospringboot.services.EmpleadoService;
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
@SpringBootTest(classes = EmpleadoController.class)
@AutoConfigureMockMvc
class EmpleadoControllerTests implements MyControllerTestInterface {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpleadoService empleadoService;

    @Test
    @WithMockUser(username = "admin@test.com")
    public void testGetAll() throws Exception {
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado());
        empleados.add(new Empleado());

        Mockito.when(empleadoService.listAll()).thenReturn(empleados);

        mockMvc.perform(MockMvcRequestBuilders.get("/empleados/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("entities"))
                .andExpect(MockMvcResultMatchers.view().name("empleados/all-entities"));
    }

    @Test
    @WithMockUser(username = "admin@test.com")
    public void testGetById() throws Exception {
        Empleado empleado = new Empleado();
        Object empleadoId = 1;

        Mockito.when(empleadoService.getById(empleadoId)).thenReturn(empleado);

        mockMvc.perform(MockMvcRequestBuilders.get("/empleados/{id}", empleadoId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.model().attributeExists("entity"))
                .andExpect(MockMvcResultMatchers.view().name("empleados/entity-details"));
    }

    @Test
    @WithMockUser(username = "admin@test.com")
    public void testGetById_InvalidId() throws Exception {
        Mockito.when(empleadoService.getById(1)).thenThrow(new MiEntidadNoEncontradaException());

        mockMvc.perform(MockMvcRequestBuilders.get("/empleados/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @WithMockUser(username = "admin@test.com")
    public void testCreate() throws Exception {
        Empleado empleado = new Empleado();

        Mockito.when(empleadoService.create(Mockito.any())).thenReturn(empleado);

        mockMvc.perform(MockMvcRequestBuilders.post("/empleados/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.model().attributeExists("entity"))
                .andExpect(MockMvcResultMatchers.view().name("empleados/entity-details"));
    }

    @Test
    @WithMockUser(username = "admin@test.com")
    public void testUpdate() throws Exception {
        Empleado empleado = new Empleado();
        Object empleadoId = 1;

        Mockito.when(empleadoService.update(Mockito.any())).thenReturn(empleado);

        mockMvc.perform(MockMvcRequestBuilders.put("/empleados/{id}", empleadoId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.model().attributeExists("entity"))
                .andExpect(MockMvcResultMatchers.view().name("empleados/entity-details"));
    }

    @Test
    @WithMockUser(username = "admin@test.com")
    public void testDelete() throws Exception {
        Object empleadoId = 1;

        mockMvc.perform(MockMvcRequestBuilders.delete("/empleados/{id}", empleadoId))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/empleados/all"));
    }
}
