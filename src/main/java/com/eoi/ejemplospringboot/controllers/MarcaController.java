package com.eoi.ejemplospringboot.controllers;


import com.eoi.ejemplospringboot.entities.Cliente;
import com.eoi.ejemplospringboot.entities.Marca;
import com.eoi.ejemplospringboot.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    // Index AHORA ESTÁN PAGINADOS, USAMOS LA DEL FINAL
//    @GetMapping("all")
//    public String getAllMarcas(
//            Model model) {
//        model.addAttribute("entities",marcaService.findAll());
//        return "marcas/all-marcas";
//    }
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
    public String createMarca(
            @ModelAttribute("marca") Marca marca) {
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
        return "marcas/marca-update";
    }
    @PostMapping("/{id}")
    public String updateMarca(@ModelAttribute Marca marca){
        marcaService.updateMarca(marca);
        return "redirect:/marcas/all";
    }
    //PAGEABLE
    @GetMapping("all")
    public String getAllMarcasPageable(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size,
                                         Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Marca> marcaPage = marcaService.getAllMarcasPageable(pageable);

        model.addAttribute("entities", marcaPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", marcaPage.getTotalPages());

        return "marcas/all-marcas";
    }
}
