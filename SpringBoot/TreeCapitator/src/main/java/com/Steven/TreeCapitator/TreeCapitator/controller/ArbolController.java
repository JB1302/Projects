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
    public String index(Model model) {
        var arboles = arbolService.getArboles();
        model.addAttribute("arboles", arboles);
        return "index";
    }

    @PostMapping("/guardar")
    public String guardar(Arbol arbol) {
        arbolService.save(arbol);
        //Un redirect para recargar la DB
        return "redirect:/";
    }

    @PostMapping("/eliminar")
    public String eliminar(Arbol arbol) {
        arbolService.delete(arbol);
        //Un redirect para recargar la DB
        return "redirect:/";
    }
}
