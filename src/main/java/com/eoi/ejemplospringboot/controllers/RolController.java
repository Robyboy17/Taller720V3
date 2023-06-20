package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.entities.Cliente;
import com.eoi.ejemplospringboot.entities.Rol;
import com.eoi.ejemplospringboot.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/roles")
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    // Index AHORA ESTÁN PAGINADOS, USAMOS LA DEL FINAL
//    @GetMapping("all")
//    public String getAllRoles(
//            Model model) {
//        model.addAttribute("entities",rolService.findAll());
//        return "roles/all-roles";
//    }

    // Delete
    @GetMapping("{id}/delete")
    public String deleteRolById(
            @PathVariable("id") String id) {
        rolService.deleteRolById(id);
        return "redirect:/roles/all";
    }

    // Create
    @GetMapping("new")
    public String addRolForm(Model model) {
        model.addAttribute("rol", new Rol());
        return "roles/rol-create";
    }

    @PostMapping("/create")
    public String createRoles(
            @ModelAttribute("rol") Rol rol) {
        rolService.createRol(rol);
        return "redirect:/roles/all";
    }

    // Update & Show
    @GetMapping("/{id}")
    public String updateRolForm(
            @PathVariable("id") String id, Model model) {
        model.addAttribute("entity", rolService.findById(id));
        Optional<Rol> rol = rolService.findById(id);
        rol.ifPresent(value -> model.addAttribute("rol", value));
        return "roles/rol-update";
    }
    @PostMapping("/{id}")
    public String updateRol(@ModelAttribute Rol rol) {
        rolService.updateRol(rol);
        return "redirect:/roles/all";
    }
    //PAGEABLE
    @GetMapping("all")
    public String getAllRolesPageable(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size,
                                         Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Rol> rolPage = rolService.getAllRolesPageable(pageable);

        model.addAttribute("entities", rolPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", rolPage.getTotalPages());

        return "roles/all-roles";
    }
}
