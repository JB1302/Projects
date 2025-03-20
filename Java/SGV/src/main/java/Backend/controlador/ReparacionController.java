package Backend.controlador;

import Backend.modelo.Usuario.Mecanico;
import Backend.modelo.Vehiculo.OrdenReparacion;
import Backend.util.DatabaseUtil;
import Backend.util.MySQLConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReparacionController extends DatabaseUtil {

    public enum Estado {
        PROGRAMADA,
        CANCELADA,
        COMPLETADA
    }

    public ReparacionController() {
    }

    private OrdenReparacion ordenReparacion;

    public ReparacionController(OrdenReparacion ordenReparacion){
        this.ordenReparacion = ordenReparacion;
    }

    @Override
    protected String getQuery() {
        return "INSERT INTO taller_mecanico.orden_reparacion (vehiculo_id, cliente_id, descripcion_problema, estado, fecha_inicio, fecha_fin, mecanico_id) VALUES (?,?,?,?,?,?,?)";
    }

    @Override
    protected void setParametros(PreparedStatement statement) throws SQLException {
        statement.setString(1, ordenReparacion.getPlaca());
        statement.setString(2, ordenReparacion.getCliente());
        statement.setString(3, ordenReparacion.getDescripcionProblema());
        statement.setString(4, Estado.PROGRAMADA.name()); // Set a valid enum value
        statement.setString(5, ordenReparacion.getFechaFormateada());
        statement.setString(6, null);
        statement.setInt(7, ordenReparacion.getMecanicoAsignado());
    }

    public void actualizarEstado(String placa, Estado estado) {
        String sql = "UPDATE taller_mecanico.orden_reparacion SET estado = ? WHERE vehiculo_id = ?";
        MySQLConnection.conexion();
        try (PreparedStatement statement = MySQLConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, estado.name());
            statement.setString(2, placa);

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Se ha actualizado el estado del vehiculo");
            } else {
                System.out.println("No se encontro un vehiculo con placa: " + placa);
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo actualizar el estado", e);
        } finally {
            MySQLConnection.closeConnection();
        }
    }

    public void asignarMecanico(String placa, int mecanicoID) {
        String sql = "UPDATE taller_mecanico.orden_reparacion SET mecanico_id = ? WHERE vehiculo_id = ?";
        MySQLConnection.conexion();
        try (PreparedStatement statement = MySQLConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, mecanicoID);
            statement.setString(2, placa);

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Se ha actualizado el mecanico asignado");
            } else {
                System.out.println("No se encontro un vehiculo con placa: " + placa);
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo actualizar el mecanico", e);
        } finally {
            MySQLConnection.closeConnection();
        }
    }
}