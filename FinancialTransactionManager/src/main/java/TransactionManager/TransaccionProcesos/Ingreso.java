

package TransactionManager.TransaccionProcesos;

import TransactionManager.Transaccion;

public class Ingreso extends Transaccion {


    public double calcularImpuestos(double monto, double impuesto){

        double impuestosCalculados = monto * impuesto;

        return impuestosCalculados;

    }


}
