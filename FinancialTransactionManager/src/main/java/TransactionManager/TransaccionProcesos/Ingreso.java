

package TransactionManager.TransaccionProcesos;

import TransactionManager.Transaccion;

public class Ingreso extends Transaccion {

    @Override
    public double calcularImpuestos(double monto) {
        double impuesto = 0.18;
        double impuestosCalculados = monto * impuesto;

        return impuestosCalculados;
    }

}
