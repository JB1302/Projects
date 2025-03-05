package Backend.modelo.Inventario;

public class Pieza {
    private int id;
    private int cantidad;
    private int precioUnitario;

    private void actualizarCantidad(){

    }

    private void revisarDisponibilidad(){

    }

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
}
