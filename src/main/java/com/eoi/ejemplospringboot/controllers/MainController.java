package com.eoi.ejemplospringboot.controllers;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class MainController {


    @GetMapping(value={"","/"})
    public String mostrarIndex(Model model)
    {
        model.addAttribute("nombreVista", "principal");
        log.trace("Entrando en el metodo del index");
        return "index";
    }

    @GetMapping("/holamundo")
    public String holaMundo(Model model)
    {
        log.trace("Entrando en el método del holamundo");
        model.addAttribute("saludo", "Hola qué tal");
        return "holamundo.html";
    }

    @GetMapping(value={"/usuarios/login","/login"})
    public String login(Model model) {
        return "usuarios/login";
    }

}
