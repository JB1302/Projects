package org.example.TransactionManager.ProcesosTransaccion;

import org.example.TransactionManager.Transaccion;

public class Egreso extends Transaccion {

    public Egreso(double monto, String descripcion) {
        super(monto, descripcion);

    }

    public Egreso(double monto, String descripcion,String fecha) {
      super(monto,descripcion);
      this.setFecha(fecha);
    }

    @Override
    public double calcularImpuesto(double monto) {
        double impuesto = 0.13;

        return monto * impuesto;
    }

    @Override
    public void procesarTransaccion() {
        System.out.println("Procesando egreso: " + getDescripcion());

    }
}
