package com.caso2.service;

import com.caso2.domain.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

/**
 *
 * @author wmolina
 */
@Service
public class ProductoService {

    public List<Producto> listaProductos = new ArrayList<>();

    public ProductoService() {
        listaProductos.add(new Producto(1, 4));
        listaProductos.add(new Producto(3, 4));
    }

    public void save(Producto producto) {
        var indice = -1;
        for (var a : listaProductos) {
            indice++;
            if (Objects.equals(a.getIdProducto(), producto.getIdProducto())) {
                listaProductos.remove(indice);
                break;
            }
        }
        listaProductos.add(producto);
    }

    public void delete(Producto producto) {
        int indice = -1;
        for (var a : listaProductos) {
            indice++;
            if (Objects.equals(a.getIdProducto(), producto.getIdProducto())) {
                listaProductos.remove(indice);
                break;
            }
        }
    }

    public Producto getProducto(Producto producto) {
        for (var a : listaProductos) {
            if (Objects.equals(a.getIdProducto(), producto.getIdProducto())) {
                return a;
            }
        }
        return null;
    }

    public List<Producto> getProductos() {
        return listaProductos;
    }
}
