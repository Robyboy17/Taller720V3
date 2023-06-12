package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.entities.Coche;
import com.eoi.ejemplospringboot.entities.Combustible;
import com.eoi.ejemplospringboot.entities.Marca;
import com.eoi.ejemplospringboot.entities.Modelo;
import com.eoi.ejemplospringboot.repositories.CombustibleRepository;
import com.eoi.ejemplospringboot.repositories.MarcaRepository;
import com.eoi.ejemplospringboot.repositories.ModeloRepository;
import com.eoi.ejemplospringboot.services.CocheService;
import com.eoi.ejemplospringboot.services.CombustibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/coches")
public class CocheController {

    private final CocheService cocheService;

    private final ModeloRepository modeloRepository;

    private final MarcaRepository marcaRepository;

    private final CombustibleRepository combustibleRepository;

    @Autowired
    public CocheController(ModeloRepository modeloRepository, MarcaRepository marcaRepository, CocheService cocheService,
                           CombustibleRepository combustibleRepository) {
        this.modeloRepository = modeloRepository;
        this.marcaRepository = marcaRepository;
        this.cocheService = cocheService;
        this.combustibleRepository = combustibleRepository;
    }

    // Index
    @GetMapping("all")
    public String getAllCoches(
            Model model) {
        model.addAttribute("entities", cocheService.findAll());
        return "coches/all-coches";
    }

    // Delete
    @GetMapping("{id}/delete")
    public String deleteCocheByid(
            @PathVariable("id") Long id) {
        cocheService.deleteCocheById(id);
        return "redirect:/coches/all";
    }

    // Create
    @GetMapping("new")
    public String addCocheForm(
            Model model) {
        List<Modelo> modelos = modeloRepository.findAll();
        List<Marca> marcas = marcaRepository.findAll();
        List<Combustible> combustibles = combustibleRepository.findAll();
        model.addAttribute("coche", new Coche());
        model.addAttribute("modelos", modelos);
        model.addAttribute("marcas", marcas);
        model.addAttribute("combustibles", combustibles);
        return "coches/coche-create";
    }

    @PostMapping("/create")
    public String createCoche(
            @ModelAttribute("coche") Coche coche) {
        cocheService.createCoche(coche);
        return "redirect:/coches/all";
    }

    // Update & Show

    @GetMapping("/modelos")
    @ResponseBody
    public List<Modelo> getModelos(Long marcaId){
        return modeloRepository.findByMarcaId(marcaId);
    }

    private List<Integer> getYears() {
        int currentYear = Year.now().getValue();
        List<Integer> years = new ArrayList<>();
        for (int year = currentYear; year >= 1900; year--) {
            years.add(year);
        }
        return years;
    }

    @GetMapping("/{id}")
    public String updateCocheForm(
            @PathVariable("id") Long id, Model model) {
        Optional<Coche> coche = cocheService.findById(id);
        if (coche.isPresent()) {
            model.addAttribute("coche", coche.get());
            List<Modelo> modelos = modeloRepository.findByMarcaId(Long.valueOf(coche.get().getMarca().getId()));
            List<Marca> marcas = marcaRepository.findAll();
            List<Combustible> combustibles = combustibleRepository.findAll();
            List<Integer> years = getYears();
            model.addAttribute("modelos", modelos);
            model.addAttribute("marcas", marcas);
            model.addAttribute("combustibles", combustibles);
            model.addAttribute("years", years);
            return "coches/coche-update";
        } else {
            // Manejar el caso en el que el coche no existe
            // TODO pantalla not found
            return "redirect:/coches/all";
        }
    }

    @PostMapping("/{id}")
    public String updateCoche(@ModelAttribute Coche coche) {
        cocheService.updateCoche(coche);
        return "redirect:/coches/all";
    }
}
