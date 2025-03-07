package Backend.modelo;

import Backend.modelo.Inventario.Pieza;
import Backend.util.MySQLConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Factura {
    private int id;
    private String cliente;
    private int ordenDeReparación;
    private List<Pieza> piezasUtilizadas;
    private double totalPagar;
    private String fecha;

    public enum estado {
        PROGRAMADA, CANCELADA, COMPLETADA
    }

    public void generarFactura(String Placa) {

        MySQLConnection.conexion();

        String sql = "SELECT cliente_id, descripcion_problema, estado, fecha_inicio, mecanico_id, vehiculo_id FROM taller_mecanico.orden_reparacion WHERE vehiculo_id = ?";

        try (PreparedStatement statement = MySQLConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, Placa);

            ResultSet resultSet = statement.executeQuery();
            StringBuilder sb = new StringBuilder();

            if (resultSet.next()) {
                sb.append("\n-----------------------------\n");
                sb.append("FACTURA DE SERVICIOS");
                sb.append("\n-----------------------------\n");
                sb.append(resultSet.getString("fecha_inicio")).append("\n");
                sb.append("Taller {nombre}\n");
                sb.append("-----------------------------\n");
                sb.append("Cliente: ").append(resultSet.getString("cliente_id")).append("\n");
                sb.append("Placa: ").append(Placa).append("\n");
                sb.append("Problema: ").append(resultSet.getString("descripcion_problema")).append("\n");
                sb.append("Mecanico: ").append(resultSet.getString("mecanico_id"));
                sb.append("\n-----------------------------\n");
                sb.append("Gracias por su preferencia!");
                sb.append("\n-----------------------------");
                sb.append("\n" + Garantia.obtenerGarantia());
                sb.append("\n-----------------------------\n");

                System.out.println(sb);

            } else {
                System.out.println("No se ha encontrado un vehículo con placa " + Placa);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error generando Factura", e);
        } finally {
            MySQLConnection.closeConnection();
        }
    }

    public void registrarPago(String placa) {
        String sql = "UPDATE taller_mecanico.orden_reparacion SET estado = ? WHERE estado NOT LIKE ? AND vehiculo_id = ?";

        MySQLConnection.conexion();

        try (PreparedStatement statement = MySQLConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, estado.COMPLETADA.name()); //
            statement.setString(2, "FINALIZADO");
            statement.setString(3, placa);

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Se ha registrado el pago de la reparación para el vehículo con placa " + placa);
            } else {
                System.out.println("No se encontró una reparación pendiente para el vehículo con placa " + placa);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error registrando pago", e);
        } finally {
            MySQLConnection.closeConnection();
        }
    }

}
