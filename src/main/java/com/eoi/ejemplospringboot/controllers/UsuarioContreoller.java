package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioContreoller {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("entities",usuarioService.findAll());
        return "usuarios";
    }

    @GetMapping("/{id}")
    public String all(@PathVariable Integer id, Model model) {
        model.addAttribute("entity",usuarioService.findById(id));
        return "usuarios/entity-details";
    }

}
