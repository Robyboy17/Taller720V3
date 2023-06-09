package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    EmpleadoService EmpleadoService;

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("entities",EmpleadoService.findAll());
        return "empleados";
    }

    @GetMapping("/{id}")
    public String all(@PathVariable Integer id, Model model) {
        model.addAttribute("entity", EmpleadoService.findById(id));
        return "empleados/entity-details";
    }

}