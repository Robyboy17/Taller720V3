package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.entities.Usuario;
import com.eoi.ejemplospringboot.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Index
    @GetMapping("all")
    public String getAllUsers(
            Model model) {
        model.addAttribute("entities",usuarioService.findAll());
        return "usuarios/all-users";
    }

    // Delete
    @GetMapping("{id}/delete")
    public String deleteUsuarioById(
            @PathVariable("id") Integer id) {
        usuarioService.deleteUsuarioById(id);
        return "redirect:/usuarios/all";
    }

    // Create
    @GetMapping("new")
    public String addUsuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/user-create";
    }

    @PostMapping("/create")
    public String createUsuario(
            @ModelAttribute("usuario") Usuario usuario) {
        usuarioService.createUsuario(usuario);
        return "redirect:/usuarios/all";
    }

    // Update & Show
    @GetMapping("/{id}")
    public String updateUsuarioForm(
            @PathVariable("id") Integer id, Model model) {
        model.addAttribute("entity", usuarioService.findById(id));
        Optional<Usuario> usuario = usuarioService.findById(id);
        usuario.ifPresent(value -> model.addAttribute("usuario", value));
        return "usuarios/user-update";
    }
    @PostMapping("/{id}")
    public String updateUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.updateUsuario(usuario);
        return "redirect:/usuarios/all";
    }

}
