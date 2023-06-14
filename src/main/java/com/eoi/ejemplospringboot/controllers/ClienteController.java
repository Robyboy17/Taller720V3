package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.entities.Cliente;
import com.eoi.ejemplospringboot.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    // Index
    @GetMapping("all")
    public String getAllClientes(
            Model model) {
        model.addAttribute("entities",clienteService.findAll());
        return "clientes/all-clientes";
    }

    // Delete
    @GetMapping("{id}/delete")
    public String deleteClienteById(
            @PathVariable("id") Integer id) {
        clienteService.deleteClienteById(id);
        return "redirect:/clientes/all";
    }

    // Create
    @GetMapping("new")
    public String addClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/cliente-create";
    }

    @PostMapping("/create")
    public String createCliente(
            @ModelAttribute("cliente") Cliente cliente) {
        clienteService.createCliente(cliente);
        return "redirect:/clientes/all";
    }

    // Update & Show
    @GetMapping("/{id}")
    public String updateClienteForm(
            @PathVariable("id") Integer id, Model model) {
        model.addAttribute("entity", clienteService.findById(id));
        Optional<Cliente> cliente = clienteService.findById(id);
        cliente.ifPresent(value -> model.addAttribute("cliente", value));
        return "clientes/cliente-update";
    }
    @PostMapping("/{id}")
    public String updateCliente(@ModelAttribute Cliente cliente) {
        clienteService.updateCliente(cliente);
        return "redirect:/clientes/all";
    }

}
