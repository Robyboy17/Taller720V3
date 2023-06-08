package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.errorcontrol.MyErrorController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;
import org.thymeleaf.exceptions.TemplateInputException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
class MyErrorControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHandleErrorNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/error")
                        .requestAttr(RequestDispatcher.ERROR_STATUS_CODE, 404))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("/error"));
        // Asegúrate de verificar el contenido del modelo y realizar las aserciones correspondientes
    }

    @Test
    public void testHandleErrorForbidden() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/error")
                        .requestAttr(RequestDispatcher.ERROR_STATUS_CODE, 403))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("/error"));
        // Asegúrate de verificar el contenido del modelo y realizar las aserciones correspondientes
    }

    @Test
    public void testHandleErrorTemplateInputException() throws Exception {
        HttpServletRequest request = MockMvcRequestBuilders.get("/error")
                .requestAttr(RequestDispatcher.ERROR_STATUS_CODE, 500)
                .requestAttr(RequestDispatcher.ERROR_EXCEPTION, new ServletException(new TemplateInputException("Error en la carga de la plantilla")))
                .buildRequest(mock(ServletContext.class));
        HttpServletResponse response = new MockHttpServletResponse();
        Model model = mock(Model.class);

        String viewName = new MyErrorController().handleError(request, model);

        assertEquals("/error", viewName);
        // Asegúrate de verificar el contenido del modelo y realizar las aserciones correspondientes
    }

    @Test
    public void testHandleErrorUnknownError() throws Exception {
        HttpServletRequest request = MockMvcRequestBuilders.get("/error")
                .requestAttr(RequestDispatcher.ERROR_STATUS_CODE, 500)
                .requestAttr(RequestDispatcher.ERROR_EXCEPTION, new ServletException("Error desconocido"))
                .buildRequest(mock(ServletContext.class));
        HttpServletResponse response = new MockHttpServletResponse();
        Model model = mock(Model.class);

        String viewName = new MyErrorController().handleError(request, model);

        assertEquals("/error", viewName);
        // Asegúrate de verificar el contenido del modelo y realizar las aserciones correspondientes
    }
}



