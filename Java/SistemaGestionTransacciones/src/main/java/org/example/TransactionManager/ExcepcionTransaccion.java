package org.example.TransactionManager;

public class ExcepcionTransaccion extends Exception {

    public ExcepcionTransaccion(String mensaje) {
        super(mensaje);
    }

    public static void validarMontoPositivo(double monto) throws ExcepcionTransaccion {
        if (monto < 0) {
            throw new ExcepcionTransaccion("El monto no puede ser negativo para un ingreso.");
        }
    }

    public static void validarEgresoValido(double monto, double capital) throws ExcepcionTransaccion {
        if (monto > capital) {
            throw new ExcepcionTransaccion("El egreso excede el capital disponible: "+ capital);
        }
    }
}
