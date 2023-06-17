package com.eoi.ejemplospringboot.controllers;


import com.eoi.ejemplospringboot.entities.Empleado;
import com.eoi.ejemplospringboot.entities.Reparacion;
import com.eoi.ejemplospringboot.entities.TipoReparacion;
import com.eoi.ejemplospringboot.repositories.ClienteRepository;
import com.eoi.ejemplospringboot.repositories.EmpleadoRepository;
import com.eoi.ejemplospringboot.repositories.TipoReparacionRepository;
import com.eoi.ejemplospringboot.services.ReparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reparaciones")
public class ReparacionController {

    private final ReparacionService reparacionService;

    private final TipoReparacionRepository tipoReparacionRepository;

    private final ClienteRepository clienteRepository;

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public ReparacionController(ReparacionService reparacionService, TipoReparacionRepository tipoReparacionRepository, ClienteRepository clienteRepository, EmpleadoRepository empleadoRepository) {
        this.reparacionService = reparacionService;
        this.tipoReparacionRepository = tipoReparacionRepository;
        this.clienteRepository = clienteRepository;
        this.empleadoRepository = empleadoRepository;
    }

    // Index
    @GetMapping("/all")
    public String getAllReparaciones(Model model) {
        model.addAttribute("entities",reparacionService.findAll());
        return "reparaciones/all-reparaciones";
    }

    // Delete
    @GetMapping("{id}/delete")
    public String deleteReparacionById(
            @PathVariable("id") Integer id) {
        reparacionService.deleteReparacionById(id);
        return "redirect:/reparaciones/all";
    }

    // Update
    @GetMapping("/{id}")
    public String updateReparacionForm(
            @PathVariable("id") Integer id, Model model) {
        model.addAttribute("entity", reparacionService.findById(id));
        Optional<Reparacion> reparacion = reparacionService.findById(id);
        reparacion.ifPresent(value -> model.addAttribute("reparacion", value));
        return "reparaciones/reparacion-update";
    }

    @PostMapping("/{id}")
    public String updateReparacion(@ModelAttribute Reparacion reparacion){
        reparacionService.updateReparacion(reparacion);
        return "redirect:/reparaciones/all";
    }

    // Create
    @GetMapping("new")
    public String addReparacionForm(Model model) {
        List<TipoReparacion> tipoReparaciones = tipoReparacionRepository.findAll();
        List<Empleado> empleados = empleadoRepository.findAll();
        model.addAttribute("empleados", empleados);
        model.addAttribute("tiposReparaciones", tipoReparaciones);
        model.addAttribute("reparacion", new Reparacion());
        return "reparaciones/reparacion-create";
    }

    @PostMapping("/create")
    public String createReparacion(@ModelAttribute("reparacion") Reparacion reparacion) {
        reparacionService.createReparacion(reparacion);
        return "redirect:/reparaciones/all";
    }

}
