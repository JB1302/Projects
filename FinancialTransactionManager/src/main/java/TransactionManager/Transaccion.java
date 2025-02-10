package TransactionManager;
import java.util.Map;
import menu.Menu;
import java.util.Date;

public abstract class Transaccion extends Menu {

    // Variable para almacenar el capital (saldo) actual
    private double capitalActual = 1500.0;

    private double monto;
    private String descripcion;
    private String fecha;

    public class RegistroTransaccion {
        private double monto;
        private String descripcion;
        private String fecha;

        public RegistroTransaccion(double monto, String descripcion, String fecha){
            this.monto = monto;
            this.descripcion = descripcion;
            this.fecha = fecha;
         }
    }





    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Transaccion(){
        Date fechaHoraActual = new Date();
        String fechaString = fechaHoraActual.toString();
        // Insertamos una transacción inicial con ID 1 que representa el capital base
        baseDeDatos.put(1, new RegistroTransaccion(1500.0, "Capital Base", fechaString));
    }


    public double calcularImpuestos(double monto){

        double impuesto = 16.0;
        double impuestosCalculados = monto *  impuesto;

        return impuestosCalculados;
    }

    public void procesarTransacción(double monto, String descripcion){

        Date fechaHoraActual = new Date();
        String fechaString = fechaHoraActual.toString();

        // Usar un ID o contador para la clave del HashMap, por ejemplo, un contador simple
        int id = baseDeDatos.size() + 1;

        baseDeDatos.put(id,new RegistroTransaccion(monto,descripcion,fechaString));

        // Imprimir la anotación añadida
        System.out.println("Anotación añadida con ID: " + id);
        System.out.println("Monto: $" + monto);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Fecha: " + fechaString);

    }

    // Método para mostrar todas las transacciones registradas
    public void mostrarTransacciones() {
        if (baseDeDatos.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
            return;
        }

        System.out.println("\nListado de Transacciones:");
        for (Map.Entry<Integer, RegistroTransaccion> entry : baseDeDatos.entrySet()) {
            Integer id = entry.getKey();
            RegistroTransaccion registro = entry.getValue();
            System.out.println("ID: " + id);
            System.out.println("Monto: $" + registro.monto);
            System.out.println("Descripción: " + registro.descripcion);
            System.out.println("Fecha: " + registro.fecha);
            System.out.println("------------");
        }
    }


}

