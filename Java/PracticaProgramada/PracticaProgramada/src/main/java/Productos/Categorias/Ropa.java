package Productos.Categorias;

import Productos.Producto;

public class Ropa extends Producto {

    double comision = 0;

    public Ropa(int codigo, String nombre, String descripcion, double precioCosto, double precioVenta, Producto.condicion condicion, boolean altaPrioridad) {
        super(codigo, nombre, descripcion, precioCosto, precioVenta, condicion, altaPrioridad);
    }

    @Override
    public void calcularPrecioVenta() {
        switch (getCondicion()){
            case NUEVO -> {
                comision = super.getPrecioCosto() * (1 + 0.05);
            }case USADO -> {
                comision = super.getPrecioCosto() * (1 + 0.03);
            }case REMANUFACTURADO -> {
                comision = super.getPrecioCosto() * (1 + 0.02);
            }default -> {
                throw new IllegalArgumentException("Condicion de producto invalida" + super.getCondicion());
            }

        }
    }
}
