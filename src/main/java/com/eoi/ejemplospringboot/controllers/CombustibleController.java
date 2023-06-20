package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.entities.Cliente;
import com.eoi.ejemplospringboot.entities.Combustible;
import com.eoi.ejemplospringboot.services.CombustibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/combustibles")
public class CombustibleController {

    private final CombustibleService combustibleService;

    @Autowired
    public CombustibleController(CombustibleService combustibleService) {
        this.combustibleService = combustibleService;
    }

    // Index AHORA ESTÁN PAGINADOS, USAMOS LA DEL FINAL
//    @GetMapping("all")
//    public String getAllCombustibles(
//            Model model) {
//        model.addAttribute("entities", combustibleService.findAll());
//        return "combustibles/all-combustibles";
//    }

    // Delete
    @GetMapping("{id}/delete")
    public String deleteCombustibleById(
            @PathVariable("id") Long id) {
        combustibleService.deleteCombustibleById(id);
        return "redirect:/combustibles/all";
    }

    // Create
    @GetMapping("new")
    public String addCombutibleForm(
            Model model) {
        model.addAttribute("combustible", new Combustible());
        return "combustibles/combustible-create";
    }

    @PostMapping("/create")
    public String createCombustible(
            @ModelAttribute("combustible") Combustible combustible) {
        combustibleService.createCombustible(combustible);
        return "redirect:/combustibles/all";
    }

    // Update & Show
    @GetMapping("/{id}")
    public String updateCombustibleForm(
            @PathVariable("id") Long id, Model model) {
        model.addAttribute("entity", combustibleService.findById(id));
        Optional<Combustible> combustible = combustibleService.findById(id);
        combustible.ifPresent(value -> model.addAttribute("combustible", value));
        return "combustibles/combustible-update";
    }

    @PostMapping("/{id}")
    public String updateCombustible(@ModelAttribute Combustible combustible) {
        combustibleService.updateCombustible(combustible);
        return "redirect:/combustibles/all";
    }
    //PAGEABLE
    @GetMapping("all")
    public String getAllCombustiblesPageable(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size,
                                         Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Combustible> combustiblePage = combustibleService.getAllCombustiblesPageable(pageable);

        model.addAttribute("entities", combustiblePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", combustiblePage.getTotalPages());

        return "combustibles/all-combustibles";
    }

}
