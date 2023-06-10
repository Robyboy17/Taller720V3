package com.eoi.ejemplospringboot.controllers;


import com.eoi.ejemplospringboot.entities.Reparacion;
import com.eoi.ejemplospringboot.services.ReparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/reparaciones")
public class ReparacionController {

    ReparacionService reparacionService;

    @Autowired
    public ReparacionController(ReparacionService reparacionService) {
        this.reparacionService = reparacionService;
    }

    @GetMapping("/all")
    public String getAllReparaciones(Model model) {
        model.addAttribute("entities",reparacionService.findAll());
        return "reparaciones/all-reparaciones";
    }



    @GetMapping("{id}/delete")
    public String deleteReparacionById(
            @PathVariable("id") Integer id) {
        reparacionService.deleteReparacionById(id);
        return "redirect:/reparacion/all";
    }

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

    @GetMapping("new")
    public String addReparacionForm(Model model) {
        model.addAttribute("reparacion", new Reparacion());
        return "reparaciones/reparacion-create";
    }

    @PostMapping("/create")
    public String createReparacion(@ModelAttribute("reparacion") Reparacion reparacion) {
        reparacionService.createReparacion(reparacion);
        return "redirect:/reparaciones/all";
    }

}
