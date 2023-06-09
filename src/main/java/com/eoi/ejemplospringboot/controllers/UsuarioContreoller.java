package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.entities.Usuario;
import com.eoi.ejemplospringboot.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioContreoller {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioContreoller(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Index
    @GetMapping("all")
    public String getAllUsers(
            Model model) {
        model.addAttribute("entities",usuarioService.findAll());
        return "usuarios/all-users";
    }
    // Show
    @GetMapping("{id}")
    public String getUsuarioById(
            @PathVariable Integer id, Model model) {
        model.addAttribute("entity", usuarioService.findById(id));
        return "usuarios/user-create";
    }
    // Delete
    @GetMapping("delete/{id}")
    public String deleteUsuarioById(
            @PathVariable("id") Integer id) {
        usuarioService.deleteUsuarioById(id);
        return "redirect:/usuarios/all";
    }
    // Create

//    @GetMapping("addUsuarioForm")
//    public String addUsuarioForm() {
//
//    }

    // Update
//    @GetMapping("/update/{id}")
//    public String updateUsuarioPage(
//            @PathVariable("id") Integer id, Model model) {
//        model.addAttribute("entity", usuarioService.findById(id));
//        return "usuarios/user-update";
//    }
//
//    @PutMapping("")
//    public String updateUsuario(@ModelAttribute Usuario usuario, Model model) {
//        Usuario updatedEntity = usuarioService.updateUsuario(usuario);
//        model.addAttribute("entity", updatedEntity);
//        return "usuarios/user-update";
//    }


}
