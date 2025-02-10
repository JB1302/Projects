package menu;

import TransactionManager.Transaccion;
import TransactionManager.TransaccionProcesos.Ingreso;

import java.util.HashMap;

public class Menu {

    public static HashMap<Integer, Transaccion.RegistroTransaccion> baseDeDatos = new HashMap<>();

    public static void main(String[] args) {
        Transaccion transaccion = new Transaccion() {
        };
        Ingreso ingreso = new Ingreso();

        // Procesamos la transacción
        transaccion.procesarTransacción(500, "Sinpe");

        // Imprimir en consola
        System.out.println("\n");
        System.out.println("\n");

        transaccion.mostrarTransacciones();

        transaccion.calcularImpuestos(150);

        ingreso.calcularImpuestos(150);


    }
}
