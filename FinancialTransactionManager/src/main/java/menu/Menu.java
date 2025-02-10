package menu;

import TransactionManager.Transaccion;
import TransactionManager.TransaccionProcesos.Ingreso;

import java.util.HashMap;

public class Menu {

    // Crear HashMap para base de Datos
    public static HashMap<Integer, Transaccion.RegistroTransaccion> baseDeDatos = new HashMap<>();

    public static void main(String[] args) {
        // Crear objeto Transtaccioón
        Transaccion transaccion = new Transaccion() {};
        // Crear objeto Ingreso
        Ingreso ingreso = new Ingreso();

        // Procesamos la transacción
        transaccion.procesarTransacción(500, "Sinpe");

        // Imprimir en consola
        System.out.println("\n");

        // Mostrar Transacciones
        transaccion.mostrarTransacciones();

        //Calcular Impuestos con Transacciones
        transaccion.calcularImpuestos(150);
        //Calcular Impuestos de Ingreso
        ingreso.calcularImpuestos(150);


    }
}
