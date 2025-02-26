package DB;

public class productoEspecifico {
    private int codigo;
    private String nombre;
    private String descripcion;
    private double precioCosto;
    private double precioVenta;
    private String condicion;
    private boolean altaPrioridad;

    public productoEspecifico(int codigo, String nombre, String descripcion, double precioCosto, double precioVenta, String condicion, boolean altaPrioridad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.condicion = condicion;
        this.altaPrioridad = altaPrioridad;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public String getCondicion() {
        return condicion;
    }

    public boolean isAltaPrioridad() {
        return altaPrioridad;
    }

    @Override
    public String toString() {
        return codigo + "," + nombre + "," + descripcion + "," + precioCosto + "," + precioVenta + "," + condicion + "," + altaPrioridad;
    }
}
