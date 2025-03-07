package Backend.modelo;

import Backend.util.MySQLConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Notificacion {

    private int id;
    private String destinario;
    private String mensaje;
    private String fechaEnvio;

    // Constructor sin parámetros
    public Notificacion() {
    }

    // Obtener fecha actual en formato adecuado
    private String obtenerFechaActual() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    // Consulta y envía notificaciones a las órdenes abiertas
    public void enviarNotificacionesOrdenesAbiertas() {
        // Consulta para obtener todas las órdenes abiertas
        String query = "SELECT vehiculo_id, cliente_id, descripcion_problema, estado " + "FROM orden_reparacion " + "WHERE estado = 'PENDIENTE' OR estado = 'CANCELADA'";

        // Establecer conexión con la base de datos
        MySQLConnection.conexion();
        try (PreparedStatement statement = MySQLConnection.getConnection().prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();

            // Verificar si hay resultados
            if (!resultSet.next()) {
                System.out.println("No se encontraron órdenes abiertas.");
                return;
            }

            // Procesa cada orden abierta y envía la notificación
            do {
                String vehiculoId = resultSet.getString("vehiculo_id");
                String clienteId = resultSet.getString("cliente_id");
                String descripcionProblema = resultSet.getString("descripcion_problema");
                String estado = resultSet.getString("estado");

                // Verificar los valores obtenidos
                System.out.println("---------------------------");
                System.out.println("\nVehículo ID: " + vehiculoId);
                System.out.println("Cliente ID: " + clienteId);
                System.out.println("Descripción: " + descripcionProblema);
                System.out.println("Estado: " + estado);
                System.out.println("\n---------------------------");


                // Crear el mensaje para la notificación
                String mensaje = "Su orden de reparación para el vehículo " + vehiculoId + " está en estado: " + estado + ". Descripción: " + descripcionProblema;

                // Crear la notificación
                Notificacion notificacion = new Notificacion();
                notificacion.setDestinario(clienteId);
                notificacion.setMensaje(mensaje);
                notificacion.setFechaEnvio(obtenerFechaActual());

                // Enviar la notificación
                enviarNotificacion(notificacion);

            } while (resultSet.next());  //do-while para procesar el primer resultado

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error enviando notificación", e);
        } finally {
            MySQLConnection.closeConnection();
        }
    }

    // Enviar la notificación
    public void enviarNotificacion(Notificacion notificacion) {

        System.out.println("\nEnviando notificación a: " + notificacion.getDestinario());
        System.out.println("Mensaje: " + notificacion.getMensaje());
        System.out.println("Fecha de envío: " + notificacion.getFechaEnvio());
        System.out.println("\n---------------------------");

    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestinario() {
        return destinario;
    }

    public void setDestinario(String destinario) {
        this.destinario = destinario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}
