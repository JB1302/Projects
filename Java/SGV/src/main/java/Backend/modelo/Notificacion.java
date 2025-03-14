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
    public String enviarNotificacionesOrdenesAbiertas() {
        StringBuilder mensajes = new StringBuilder();

        // Consulta para obtener todas las órdenes abiertas
        String query = "SELECT vehiculo_id, cliente_id, descripcion_problema, estado " +
                "FROM orden_reparacion " +
                "WHERE estado = 'PENDIENTE' OR estado = 'CANCELADA'";

        // Establecer conexión con la base de datos
        MySQLConnection.conexion();
        try (PreparedStatement statement = MySQLConnection.getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            // Verificar si hay resultados
            if (!resultSet.next()) {
                return "No se encontraron órdenes abiertas.";
            }

            // Procesar cada orden abierta y generar la notificación
            do {
                String vehiculoId = resultSet.getString("vehiculo_id");
                String clienteId = resultSet.getString("cliente_id");
                String descripcionProblema = resultSet.getString("descripcion_problema");
                String estado = resultSet.getString("estado");

                // Crear el mensaje para la notificación
                String mensaje = "Su orden de reparación para el vehículo " + vehiculoId +
                        " está en estado: " + estado + ". Descripción: " + descripcionProblema;

                mensajes.append("Enviando notificación a: ").append(clienteId).append("\n")
                        .append("Mensaje: ").append(mensaje).append("\n")
                        .append("Fecha de envío: ").append(obtenerFechaActual()).append("\n")
                        .append("---------------------------\n");
            } while (resultSet.next());  // Repite para las siguientes órdenes
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error enviando notificación.";
        } finally {
            MySQLConnection.closeConnection();
        }

        return mensajes.toString();  // Retorna el mensaje completo
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
