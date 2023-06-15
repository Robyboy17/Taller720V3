package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.entities.Cliente;
import com.eoi.ejemplospringboot.entities.Coche;
import com.eoi.ejemplospringboot.services.ClienteService;
import com.eoi.ejemplospringboot.services.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final CocheService cocheService;

    @Autowired
    public ClienteController(ClienteService clienteService, CocheService cocheService) {
        this.clienteService = clienteService;
        this.cocheService = cocheService;
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

    // Añadir coche
    @GetMapping("/asignar-coche")
    public String mostrarFormularioAsignarCoche(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("coches", cocheService.findAll());
        return "clientes/asignar-coche-form";
    }
    @PostMapping("/asignar-coche")
    public String asignarCocheACliente(
            @RequestParam("clienteId") Integer clienteId,
            @RequestParam("cocheId") Long cocheId) {
        Cliente cliente = clienteService.findById(clienteId).orElse(null);
        Coche coche = cocheService.findById(cocheId).orElse(null);

        if (cliente != null && coche != null) {
            Set<Coche> cochesCliente = cliente.getCoches();
            cochesCliente.add(coche);
            clienteService.updateCliente(cliente);
        }

        return "redirect:/clientes/all";
    }

}
