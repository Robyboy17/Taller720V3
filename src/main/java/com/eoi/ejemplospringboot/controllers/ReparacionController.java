package com.eoi.ejemplospringboot.controllers;


import com.eoi.ejemplospringboot.entities.Cliente;
import com.eoi.ejemplospringboot.entities.Empleado;
import com.eoi.ejemplospringboot.entities.Reparacion;
import com.eoi.ejemplospringboot.entities.TipoReparacion;
import com.eoi.ejemplospringboot.repositories.ClienteRepository;
import com.eoi.ejemplospringboot.repositories.EmpleadoRepository;
import com.eoi.ejemplospringboot.repositories.TipoReparacionRepository;
import com.eoi.ejemplospringboot.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reparaciones")
public class ReparacionController {

    private final ReparacionService reparacionService;
    private final TipoReparacionRepository tipoReparacionRepository;
    private final ClienteRepository clienteRepository;
    private final EmpleadoRepository empleadoRepository;
    private final ClienteService clienteService;
    private final EmpleadoService empleadoService;
    private final TipoReparacionService tipoReparacionService;
    private final CocheService cocheService;

    @Autowired
    public ReparacionController(ReparacionService reparacionService, TipoReparacionRepository tipoReparacionRepository, ClienteRepository clienteRepository, EmpleadoRepository empleadoRepository, ClienteService clienteService, EmpleadoService empleadoService, TipoReparacionService tipoReparacionService, CocheService cocheService) {
        this.reparacionService = reparacionService;
        this.tipoReparacionRepository = tipoReparacionRepository;
        this.clienteRepository = clienteRepository;
        this.empleadoRepository = empleadoRepository;
        this.clienteService = clienteService;
        this.empleadoService = empleadoService;
        this.tipoReparacionService = tipoReparacionService;
        this.cocheService = cocheService;
    }

    // Index
    @GetMapping("/all")
    public String getAllReparaciones(Model model) {
        model.addAttribute("entities",reparacionService.findAll());
        return "reparaciones/all-reparaciones";
    }

    // Delete
    @GetMapping("{id}/delete")
    public String deleteReparacionById(
            @PathVariable("id") Integer id) {
        reparacionService.deleteReparacionById(id);
        return "redirect:/reparaciones/all";
    }

    // Update
    @GetMapping("/{id}")
    public String updateReparacionForm(@PathVariable("id") Integer id, Model model) {
        Optional<Reparacion> reparacion = reparacionService.findById(id);
        if (reparacion.isPresent()) {
            model.addAttribute("reparacion", reparacion.get());
            model.addAttribute("clientes", clienteService.getAllClientes());
            model.addAttribute("empleados", empleadoService.getAllEmpleados());
            model.addAttribute("tiposReparaciones", tipoReparacionService.getAllTiposReparaciones());
            return "reparaciones/reparacion-update";
        } else {
            return "redirect:/reparaciones/all";
        }
    }

    @PostMapping("/{id}")
    public String updateReparacion(@PathVariable("id") Integer id, @ModelAttribute Reparacion reparacion) {
        reparacion.setId(id);
        reparacionService.updateReparacion(reparacion);
        return "redirect:/reparaciones/all";
    }

    // Create
    @GetMapping("new")
    public String addReparacionForm(Model model) {
        List<TipoReparacion> tipoReparaciones = tipoReparacionRepository.findAll();
        List<Empleado> empleados = empleadoRepository.findAll();
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("empleados", empleados);
        model.addAttribute("tiposReparaciones", tipoReparaciones);
        model.addAttribute("clientes", clientes);
        model.addAttribute("reparacion", new Reparacion());
        return "reparaciones/reparacion-create";
    }

    @PostMapping("/create")
    public String createReparacion(
            @ModelAttribute("reparacion") Reparacion reparacion,
            @RequestParam("empleadoId") Integer empleadoId,
            @RequestParam("clienteId") Integer clienteId,
            @RequestParam("tipoReparacionId") Integer tipoReparacionId) {

        Cliente cliente = clienteService.findById(clienteId).orElse(null);
        Empleado empleado = empleadoService.findById(empleadoId).orElse(null);
        TipoReparacion tipoReparacion = tipoReparacionService.findById(tipoReparacionId).orElse(null);

        if (cliente != null && empleado != null && tipoReparacion != null) {
            reparacion.setCliente(cliente);
            reparacion.setEmpleado(empleado);
            reparacion.setTipoReparacion(tipoReparacion);
            reparacionService.createReparacion(reparacion);
        }

        return "redirect:/reparaciones/all";
    }

}
