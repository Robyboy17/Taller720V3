package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.entities.Usuario;
import com.eoi.ejemplospringboot.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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


    @GetMapping("prueba")
    public String prueba(
            Model model) {
        return "prueba";
    }
    // Index AHORA ESTÁN PAGINADOS, USAMOS LA DEL FINAL
//    @GetMapping("all")
//    public String getAllUsers(
//            Model model) {
//        model.addAttribute("entities",usuarioService.findAll());
//        return "usuarios/all-users";
//    }

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
    @GetMapping("all")
    public String getAllUsers(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size,
                              Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Usuario> usuarioPage = usuarioService.findAll(pageable);

        model.addAttribute("entities", usuarioPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", usuarioPage.getTotalPages());

        return "usuarios/all-users";
    }
}
