package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.entities.Empresa;
import com.eoi.ejemplospringboot.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Controller
@RequestMapping("/empresas")
public class EmpresaController {
    private final EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    // Index
    @GetMapping("all")
    public String getAllEmpresas(
            Model model) {
        model.addAttribute("entities",empresaService.findAll());
        return "empresas/all-empresas";
    }

    // Delete
    @GetMapping("{id}/delete")
    public String deleteEmpresaById(
            @PathVariable("id") Integer id) {
        empresaService.deleteEmpresaById(id);
        return "redirect:/empresas/all";
    }

    // Create
    @GetMapping("new")
    public String addEmpresaForm(Model model) {
        model.addAttribute("empresa", new Empresa());
        return "empresas/empresa-create";
    }

    @PostMapping("/create")
    public String createEmpresa(
            @ModelAttribute("empresa") Empresa empresa) {
        empresaService.createEmpresa(empresa);
        return "redirect:/empresas/all";
    }

    // Update & Show
    @GetMapping("/{id}")
    public String updateEmpresaForm(
            @PathVariable("id") Integer id, Model model) {
        model.addAttribute("entity", empresaService.findById(id));
        Optional<Empresa> empresa = empresaService.findById(id);
        empresa.ifPresent(value -> model.addAttribute("empresa", value));
        return "empresas/empresa-update";
    }
    @PostMapping("/{id}")
    public String updateEmpresa(@ModelAttribute Empresa empresa) {
        empresaService.updateEmpresa(empresa);
        return "redirect:/empresas/all";
    }
}
