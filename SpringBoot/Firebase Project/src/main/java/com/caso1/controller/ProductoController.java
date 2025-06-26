package com.caso1.controller;

import com.caso1.domain.Producto;
import com.caso1.service.FirebaseStorageService;
import com.caso1.service.ProductoService;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource; // <-- Falta este import
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private FirebaseStorageService firebaseStorageService;
    
    @Autowired
    private MessageSource messageSource; 

    @GetMapping("/listado") 
    public String listado(Model model) {
        var lista = productoService.getProductos(false);
        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());
        return "producto/listado"; 
    }

    @PostMapping("/guardar")
    public String guardar(Producto producto,
            @RequestParam(required = false) MultipartFile imagenFile,
            RedirectAttributes redirectAttributes) {

        productoService.save(producto);

        // Si tiene imagen, subir y actualizar
        if (imagenFile != null && !imagenFile.isEmpty()) {
            String rutaImagen = firebaseStorageService.cargaImagen(
                    imagenFile, "producto", producto.getId_producto());
            producto.setImagen_producto(rutaImagen);
            productoService.save(producto); 
        }

        redirectAttributes.addFlashAttribute("todoOk",
                messageSource.getMessage("mensaje.actualizado", null, Locale.getDefault()));

        return "redirect:/producto/listado";
    }

    @PostMapping("/eliminar")
    public String eliminar(Producto producto,
            RedirectAttributes redirectAttributes) {

        producto = productoService.getProducto(producto);

        if (producto == null) {
            redirectAttributes.addFlashAttribute("error",
                    messageSource.getMessage("producto.error01", null, Locale.getDefault()));
        } else if (false) {
            // Aquí podrías validar si tiene asociaciones antes de eliminar
            redirectAttributes.addFlashAttribute("error",
                    messageSource.getMessage("producto.error02", null, Locale.getDefault()));
        } else if (productoService.delete(producto)) {
            redirectAttributes.addFlashAttribute("todoOk",
                    messageSource.getMessage("mensaje.eliminado", null, Locale.getDefault()));
        } else {
            redirectAttributes.addFlashAttribute("error",
                    messageSource.getMessage("producto.error03", null, Locale.getDefault()));
        }

        return "redirect:/producto/listado";
    }

    @PostMapping("/modificar")
    public String modificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "producto/modifica"; 
    }
}
