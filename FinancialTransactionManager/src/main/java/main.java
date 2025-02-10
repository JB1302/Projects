import TransactionManager.Transaccion;


public class main {
    public static void main(String[] args) {
        Transaccion sistemaDeTransacciones = new Transaccion();

        sistemaDeTransacciones.procesarTransacción(5000.0,"Sinpe");

        sistemaDeTransacciones.procesarTransacción(300.0,"Sinpe");

        sistemaDeTransacciones.procesarTransacción(1590.15,"Sinpe");
        
        System.out.println("\n");
        System.out.println("\n");

        sistemaDeTransacciones.mostrarTransacciones();

    }
}
