package TransactionManager;

import java.util.HashMap;

public class Transaccion {

    HashMap<Integer,String> map = new HashMap<>();

    double monto;
    String descripcion;
    String fecha;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public double calcularImpuestos(double monto){

        double tax = 0.16;
        double montoDespuesImpuesto = monto * tax;

        return montoDespuesImpuesto;
    }

    public void procesarTransacción(double monto, String descripcion){

    }
}
