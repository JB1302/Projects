package Productos.Categorias;

import Productos.Producto;

public class Electronico extends Producto {

    double margenDeGananciaBase = 0.15;
    double margenAltaPrioridad = 0.10;

    public Electronico(int codigo, String nombre, String descripcion, double precioCosto, double precioVenta, Producto.condicion condicion, boolean altaPrioridad) {
        super(codigo, nombre, descripcion, precioCosto, precioVenta, condicion, altaPrioridad);
    }

    @Override
    public void calcularPrecioVenta() {
        double margenGanancia = super.getPrecioCosto() * margenDeGananciaBase;

        if (isAltaPrioridad()) {
            margenGanancia += super.getPrecioCosto() * margenAltaPrioridad;
        }
        double precioVenta = super.getPrecioVenta() + margenGanancia;
    }
}