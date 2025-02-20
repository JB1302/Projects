package org.example.TransactionManager;
import java.util.Date;

public abstract class Transaccion {

    private double monto;
    private String descripcion;
    private String fecha;



    public Transaccion(double monto, String descripcion){
        this.monto = monto;
        this.descripcion = descripcion;
        Date fechaHoraActual = new Date();
        this.fecha = fechaHoraActual.toString();
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public abstract double calcularImpuesto(double monto);

    public abstract void procesarTransaccion();

    @Override
    public String toString() {
        return String.format("Fecha: %s \n Descripción: %s \n Monto: $%s", fecha, descripcion, monto);
    }
}
