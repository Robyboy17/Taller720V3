package com.eoi.ejemplospringboot.controllers;


import com.eoi.ejemplospringboot.entities.TipoReparacion;
import com.eoi.ejemplospringboot.services.TipoReparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/tipo-reparaciones")
public class TipoReparacionController {
    private final TipoReparacionService tipoReparacionService;

    @Autowired
    public TipoReparacionController(TipoReparacionService tipoReparacionService) {
        this.tipoReparacionService = tipoReparacionService;
    }

    // Index
    @GetMapping("all")
    public String getAllTipoReparaciones(
            Model model) {
        model.addAttribute("entities",tipoReparacionService.findAll());
        return "tipo-reparaciones/all-tipo-reparaciones";
    }

    // Delete
    @GetMapping("{id}/delete")
    public String deleteTipoReparacionById(
            @PathVariable("id") Integer id) {
        tipoReparacionService.deleteTipoReparacionById(id);
        return "redirect:/tipo-reparaciones/all";
    }

    // Create
    @GetMapping("new")
    public String addTipoReparacionForm(Model model) {
        model.addAttribute("tipoReparacion", new TipoReparacion());
        return "tipo-reparaciones/tipo-reparacion-create";
    }

    @PostMapping("/create")
    public String createTipoReparacion(
            @ModelAttribute("tipoReparacion") TipoReparacion tipoReparacion) {
        tipoReparacionService.createTipoReparacion(tipoReparacion);
        return "redirect:/tipo-reparaciones/all";
    }

    // Update & Show
    @GetMapping("/{id}")
    public String updateTipoReparacionForm(
            @PathVariable("id") Integer id, Model model) {
        model.addAttribute("entity", tipoReparacionService.findById(id));
        Optional<TipoReparacion> tipoReparacion = tipoReparacionService.findById(id);
        tipoReparacion.ifPresent(value -> model.addAttribute("tipoReparacion", value));
        return "tipo-reparaciones/tipo-reparacion-update";
    }
    @PostMapping("/{id}")
    public String updateTipoReparacion(@ModelAttribute TipoReparacion tipoReparacion) {
        tipoReparacionService.updateTipoReparacion(tipoReparacion);
        return "redirect:/tipo-reparaciones/all";
    }
}
