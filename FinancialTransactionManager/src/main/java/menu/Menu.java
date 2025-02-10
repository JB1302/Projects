package menu;

import TransactionManager.Transaccion;
import TransactionManager.TransaccionProcesos.Ingreso;

import java.util.HashMap;

public class Menu {

    public static HashMap<Integer, Transaccion.RegistroTransaccion> baseDeDatos = new HashMap<>();

    public static void main(String[] args) {
        Transaccion transaccion = new Transaccion() {};

        // Procesamos la transacción
        transaccion.procesarTransacción(500, "Sinpe");

        // Imprimir en consola
        System.out.println("\n");
        System.out.println("\n");

        transaccion.mostrarTransacciones();

        double impuestoCalculado_Transaccion = transaccion.calcularImpuestos(150.00);
        System.out.printf("\nEl impuesto calculado es de : $%.1f", impuestoCalculado_Transaccion);

        Ingreso ingreso = new Ingreso();
        double impuestoCalculado_Ingreso = ingreso.calcularImpuestos(150.00);
        System.out.printf("\nEl impuesto calculado es de : $%.1f", impuestoCalculado_Ingreso);


    }
}
