package com.eoi.ejemplospringboot.controllers;

import com.eoi.ejemplospringboot.entities.Cliente;
import com.eoi.ejemplospringboot.entities.Coche;
import com.eoi.ejemplospringboot.services.ClienteService;
import com.eoi.ejemplospringboot.services.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // Index AHORA ESTÁN PAGINADOS, USAMOS LA DEL FINAL
//    @GetMapping("all")
//    public String getAllClientes(
//            Model model) {
//        model.addAttribute("entities",clienteService.findAll());
//        return "clientes/all-clientes";
//    }

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
            cliente.addCoche(coche);
            clienteService.updateCliente(cliente);
        }

        return "redirect:/clientes/all";
    }

    // Ver coches del cliente
    @GetMapping("/{id}/coches")
    public String viewClienteCoches(@PathVariable("id") Integer id, Model model) {
        Cliente cliente = clienteService.findById(id).orElse(null);

        if (cliente != null) {
            Set<Coche> cochesCliente = cliente.getCoches();
            model.addAttribute("cliente", cliente);
            model.addAttribute("coches", cochesCliente);
            return "clientes/cliente-coches";
        } else {
            // Manejar el caso en el que el cliente no existe si eso
            // TODO pantalla not found
            return "redirect:/clientes/all";
        }
    }
    //PAGEABLE
    @GetMapping("all")
    public String getAllClientesPageable(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size,
                              Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Cliente> clientePage = clienteService.getAllClientesPageable(pageable);

        model.addAttribute("entities", clientePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", clientePage.getTotalPages());

        return "clientes/all-clientes";
    }

}
