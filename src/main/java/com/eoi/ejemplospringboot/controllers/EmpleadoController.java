package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.entities.Empleado;
import com.eoi.ejemplospringboot.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;
    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/all")
    public String getAllEmpleados(Model model) {
        model.addAttribute("entities",empleadoService.findAll());
        return "empleado";
    }

    // Delete
    @GetMapping("{id}/delete")
    public String deleteEmpleadoById(
            @PathVariable("id") Integer id) {
        empleadoService.deleteEmpleadoById(id);
        return "redirect:/empleados/all";
    }
    // Create
    @GetMapping("new")
    public String addEmpleadoForm(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleados/empleado-create";
    }

    @PostMapping("/create")
    public String createEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        empleadoService.createEmpleado(empleado);
        return "redirect:/empleados/all-empleados";
    }

    // Update & Show
    @GetMapping("/{id}")
    public String updateEmpleadoForm(
            @PathVariable("id") Integer id, Model model) {
        model.addAttribute("entity", empleadoService.findById(id));
        Optional<Empleado> empleado = empleadoService.findById(id);
        empleado.ifPresent(value -> model.addAttribute("empleado", value));
        return "empleados/empleado-update";
    }
    @PostMapping("/{id}")
    public String updateEmpleado(@ModelAttribute Empleado empleado){
        empleadoService.updateEmpleado(empleado);
        return "redirect:/empleados/all";
    }
}