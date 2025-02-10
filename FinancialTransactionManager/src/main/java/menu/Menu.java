package menu;

import TransactionManager.Transaccion;

import java.util.HashMap;

public class Menu {

    public static HashMap<Integer, Transaccion.RegistroTransaccion> baseDeDatos = new HashMap<>();

    public static void main(String[] args) {
        Transaccion transaccion = new Transaccion() {};

        // Procesamos la transacción
        transaccion.procesarTransacción(500, "Sinpe");

        transaccion.mostrarTransacciones();

        // Imprimir en consola
        System.out.println("\n");
        System.out.println("\n");
    }
}
