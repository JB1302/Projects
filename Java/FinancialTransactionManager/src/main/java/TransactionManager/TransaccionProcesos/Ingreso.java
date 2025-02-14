

package TransactionManager.TransaccionProcesos;

import TransactionManager.Transaccion;

public class Ingreso extends Transaccion {

    @Override
   public void calcularImpuestos(double monto) {

    double impuesto = 0.18;
    double impuestosCalculados = monto * impuesto;

    System.out.printf("\nEl impuesto calculado para Ingreso es de : $%.1f", impuestosCalculados);

    }

}
