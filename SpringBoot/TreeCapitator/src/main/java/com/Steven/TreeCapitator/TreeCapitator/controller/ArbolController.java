package com.Steven.TreeCapitator.TreeCapitator.controller;

import com.Steven.TreeCapitator.TreeCapitator.domain.Arbol;
import com.Steven.TreeCapitator.TreeCapitator.service.ArbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("arboles", arbolService.getArboles());
        model.addAttribute("arbol", new Arbol());

        return "index";
    }

    @PostMapping("/guardar")
    public String guardar(Arbol arbol) {
        arbolService.save(arbol);
        //Un redirect para recargar la DB
        return "redirect:/";
    }

    @PostMapping("/actualizar")
    public String actualizar(Arbol arbol) {
        arbolService.save(arbol);
        return "redirect:/";
    }

    @PostMapping("/eliminar")
    public String eliminar(Arbol arbol) {
        arbolService.delete(arbol);
        //Un redirect para recargar la DB
        return "redirect:/";
    }
}
