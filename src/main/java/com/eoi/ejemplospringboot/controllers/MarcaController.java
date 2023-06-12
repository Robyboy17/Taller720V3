package com.eoi.ejemplospringboot.controllers;


import com.eoi.ejemplospringboot.entities.Marca;
import com.eoi.ejemplospringboot.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    @Autowired
    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    // Index
    @GetMapping("all")
    public String getAllMarcas(
            Model model) {
        model.addAttribute("entities",marcaService.findAll());
        return "marcas/all-marcas";
    }
    // Show

    // Delete
    @GetMapping("{id}/delete")
    public String deleteMarcaById(
            @PathVariable("id") Integer id) {
        marcaService.deleteMarcaById(id);
        return "redirect:/marcas/all";
    }
    // Create
    @GetMapping("new")
    public String addMarcaForm(Model model) {
        model.addAttribute("marca", new Marca());
        return "marcas/marca-create";
    }

    @PostMapping("/create")
    public String createMarca(@ModelAttribute("marca") Marca marca) {
        marcaService.createMarca(marca);
        return "redirect:/marcas/all";
    }

    // Update & Show
    @GetMapping("/{id}")
    public String updateMarcaForm(
            @PathVariable("id") Integer id, Model model) {
        model.addAttribute("entity", marcaService.findById(id));
        Optional<Marca> marca = marcaService.findById(id);
        marca.ifPresent(value -> model.addAttribute("marca", value));
        return "marca/marca-update";
    }
    @PostMapping("/{id}")
    public String updateMarca(@ModelAttribute Marca marca){
        marcaService.updateMarca(marca);
        return "redirect:/marcas/all";
    }

}
