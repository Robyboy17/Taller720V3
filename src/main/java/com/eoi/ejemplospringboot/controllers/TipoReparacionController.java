package com.eoi.ejemplospringboot.controllers;


import com.eoi.ejemplospringboot.entities.Cliente;
import com.eoi.ejemplospringboot.entities.TipoReparacion;
import com.eoi.ejemplospringboot.services.TipoReparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/reparaciones/tipos")
public class TipoReparacionController {

    private final TipoReparacionService tipoReparacionService;

    @Autowired
    public TipoReparacionController(TipoReparacionService tipoReparacionService) {
        this.tipoReparacionService = tipoReparacionService;
    }

    // Index AHORA ESTÁN PAGINADOS, USAMOS LA DEL FINAL
//    @GetMapping("all")
//    public String getAllTipoReparaciones(
//            Model model) {
//        model.addAttribute("entities",tipoReparacionService.findAll());
//        return "tipoReparaciones/all-tipoReparaciones";
//    }

    // Delete
    @GetMapping("{id}/delete")
    public String deleteTipoReparacionById(
            @PathVariable("id") Integer id) {
        tipoReparacionService.deleteTipoReparacionById(id);
        return "redirect:/reparaciones/tipos/all";
    }

    // Create
    @GetMapping("new")
    public String addTipoReparacionForm(Model model) {
        model.addAttribute("tipoReparacion", new TipoReparacion());
        return "tipoReparaciones/tipoReparacion-create";
    }

    @PostMapping("/create")
    public String createTipoReparacion(
            @ModelAttribute("tipoReparacion") TipoReparacion tipoReparacion) {
        tipoReparacionService.createTipoReparacion(tipoReparacion);
        return "redirect:/reparaciones/tipos/all";
    }

    // Update & Show
    @GetMapping("/{id}")
    public String updateTipoReparacionForm(
            @PathVariable("id") Integer id, Model model) {
        model.addAttribute("entity", tipoReparacionService.findById(id));
        Optional<TipoReparacion> tipoReparacion = tipoReparacionService.findById(id);
        tipoReparacion.ifPresent(value -> model.addAttribute("tipoReparacion", value));
        return "tipoReparaciones/tipoReparacion-update";
    }

    @PostMapping("/{id}")
    public String updateTipoReparacion(@ModelAttribute TipoReparacion tipoReparacion) {
        tipoReparacionService.updateTipoReparacion(tipoReparacion);
        return "redirect:/reparaciones/tipos/all";
    }
    //PAGEABLE
    @GetMapping("all")
    public String getAllTiposReparacionesPageable(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size,
                                         Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TipoReparacion> tipoReparacionPage = tipoReparacionService.getAllTiposReparacionesPageable(pageable);

        model.addAttribute("entities", tipoReparacionPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", tipoReparacionPage.getTotalPages());

        return "tipoReparaciones/all-tipoReparaciones";
    }
}
