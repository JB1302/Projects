package Backend.modelo.Inventario;

import Backend.util.DatabaseUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pieza extends DatabaseUtil {
    private int id;
    private int cantidad;
    private int precioUnitario;

    private String nombre;
    private String descripcion;

    public Pieza() {
    }

    public Pieza(String nombre, String descripcion, int cantidad, int precioUnitario) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
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

    public void setDescripcion(String descripción) {
        this.descripcion = descripción;
    }

    @Override
    protected String getQuery() {
        return "INSERT INTO taller_mecanico.piezas (nombre,descripcion,cantidad,precio_unitario) VALUES (?,?,?,?)";
    }

    @Override
    protected void setParametros(PreparedStatement statement) throws SQLException {
        statement.setString(1, getNombre());
        statement.setString(2, getDescripcion());
        statement.setInt(3, getCantidad());
        statement.setInt(4, getPrecioUnitario());
    }
}
