package Productos;

public abstract class Producto {
    private int codigo;
    private String nombre;
    private String descripcion;
    private double precioCosto;
    private double precioVenta;


    private condicion condicion;
    public enum condicion{
        NUEVO,USADO,REMANUFACTURADO
    }

    private boolean altaPrioridad;

    public Producto() {
    }

    public Producto(int codigo, String nombre, String descripcion, double precioCosto, double precioVenta, Producto.condicion condicion, boolean altaPrioridad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.condicion = condicion;
        this.altaPrioridad = altaPrioridad;
    }

    public Producto.condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Producto.condicion condicion) {
        this.condicion = condicion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrevioVenta(double previoVenta) {
        this.precioVenta = previoVenta;
    }

    public boolean isAltaPrioridad() {
        return altaPrioridad;
    }

    public void setAltaPrioridad(boolean altaPrioridad) {
        this.altaPrioridad = altaPrioridad;
    }

    @Override
    public String toString() {
        return codigo + "," + nombre + "," + descripcion + "," + precioCosto + "," + precioVenta + "," + condicion + "," + altaPrioridad;
    }

    public abstract void calcularPrecioVenta();
}

