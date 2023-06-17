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
        //model.addAttribute("nombreVista", "principal");
        log.trace("Entrando en el metodo del index");
        return "home";
    }


    @GetMapping(value={"/usuarios/login","/login"})
    public String login(Model model) {
        return "usuarios/login";
    }

    @GetMapping(value={"/usuarios/register","/register"})
    public String register(Model model) {
        return "usuarios/register";
    }

    @GetMapping(value={"/FAQs"})
    public String FAQs(Model model) {
        return "/FAQs";
    }

    @GetMapping(value={"/avisoLegal"})
    public String avisoLegal(Model model) {
        return "/avisoLegal";
    }

    @GetMapping(value={"/sobreNosotros"})
    public String sobreNosotros(Model model) {
        return "/sobreNosotros";
    }
}
