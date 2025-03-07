package Backend.modelo;

import Backend.modelo.Inventario.Pieza;

import java.util.List;

public class Factura {
    private int id;
    private String cliente;
    private int ordenDeReparación;
    private List<Pieza> piezasUtilizadas;
    private double totalPagar;
    private String fecha;

    public void generarFactura(){

    }

    public void registrarPago(){

    }
}
