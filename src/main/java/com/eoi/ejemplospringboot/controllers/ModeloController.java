package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.entities.Marca;
import com.eoi.ejemplospringboot.entities.Modelo;
import com.eoi.ejemplospringboot.repositories.MarcaRepository;
import com.eoi.ejemplospringboot.services.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/modelos")
public class ModeloController {

    private final ModeloService modeloService;
    private final MarcaRepository marcaRepository;

    @Autowired
    public ModeloController(ModeloService modeloService,
                            MarcaRepository marcaRepository) {
        this.modeloService = modeloService;
        this.marcaRepository = marcaRepository;
    }

    // Index
    @GetMapping("all")
    public String getAllModelos(Model model) {
        model.addAttribute("entities", modeloService.findAll());
        return "modelos/all-modelos";
    }

    // Show

    // Delete
    @GetMapping("/{id}/delete")
    public String deleteModeloById(@PathVariable("id") Integer id) {
        modeloService.deleteModeloById(id);
        return "redirect:/modelos/all";
    }

    // Create
    @GetMapping("/new")
    public String addModeloForm(Model model) {
        List<Marca> marcas = marcaRepository.findAll();
        model.addAttribute("marcas", marcas);
        model.addAttribute("modelo", new Modelo());
        return "modelos/modelo-create";
    }

    @PostMapping("/create")
    public String createModelo(@ModelAttribute("modelo") Modelo modelo) {
        modeloService.createModelo(modelo);
        return "redirect:/modelos/all";
    }

    // Update & Show
    @GetMapping("/{id}")
    public String updateModeloForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("entity", modeloService.findById(id));
        List<Marca> marcas = marcaRepository.findAll();
        Optional<Modelo> modelo = modeloService.findById(id);
        modelo.ifPresent(value -> model.addAttribute("modelo", value));
        model.addAttribute("marcas", marcas);
        return "modelos/modelo-update";
    }

    @PostMapping("/{id}")
    public String updateModelo(@ModelAttribute("modelo") Modelo modelo) {
        modeloService.updateModelo(modelo);
        return "redirect:/modelos/all";
    }
}
