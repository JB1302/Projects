package com.caso2.controller;

import com.caso2.domain.Producto;
import com.caso2.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    
    @GetMapping("/producto/agregar/{idProducto}")
    public String agregarProducto(Model model,  Producto producto) {
        productoService.save(producto);     
        return "redirect:/producto/listado";
    }

    @GetMapping("/producto/listado")
    public String listado(Model model) {
        var productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos",productos.size());
        model.addAttribute("producto", new Producto());
        return "/producto/listado";
    }
    
     @PostMapping("/producto/guardar")
    public String guardarProducto(Producto producto, Model model) {
        productoService.save(producto);
        return "redirect:/producto/listado";
    }
    
    @GetMapping("/producto/modificar/{idProducto}")
    public String modificarProducto(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto",producto);
        return "/producto/modificar";
    }
 
    @GetMapping("/producto/eliminar/{idProducto}")
    public String eliminarProducto(Producto producto, Model model) {
        productoService.delete(producto);        
        var productos=productoService.getProductos();
        return "redirect:/producto/listado";
    }
}
