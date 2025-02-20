package org.example.TransactionManager.ProcesosTransaccion;

import org.example.TransactionManager.Transaccion;

public class Ingreso extends Transaccion {

    public Ingreso(double monto, String descripcion) {
    super(monto, descripcion);
    }

    public Ingreso(double monto, String descripcion,String fecha) {
        super( monto,descripcion);
        this.setFecha(fecha);
    }

    @Override
    public double calcularImpuesto(double monto){
        double impuesto = 0.18;

        return monto * impuesto;
    }

    @Override
    public void procesarTransaccion() {
      System.out.println("Procesando ingreso: " + getDescripcion());
    }
}
