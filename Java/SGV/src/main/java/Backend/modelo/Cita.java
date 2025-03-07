package Backend.modelo;

import Backend.util.DatabaseUtil;
import Backend.util.MySQLConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cita extends DatabaseUtil {
    private int id;
    private String cliente;
    private String vehiculo;
    private String fecha;
    private String hora;
    private enum estado {
        PROGRAMADA, CANCELADA, COMPLETADA
    }
    private estado estado;

    public Cita() {
    }

    public Cita(String cliente, String vehiculo, String fecha, String hora) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado.PROGRAMADA;
    }

    public static String convertirStringADate(String fechaString){
        SimpleDateFormat format = new SimpleDateFormat("d-M-yyyy");
        try {
            Date date = format.parse(fechaString);
            SimpleDateFormat formatoMysql = new SimpleDateFormat("yyyy-MM-dd");
            return formatoMysql.format(date);
        } catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }


    public void cancelarCita(String cliente) {
        String sql = "UPDATE taller_mecanico.citas SET estado = ? WHERE cliente_id = ?";
        MySQLConnection.conexion();

        try (PreparedStatement statement = MySQLConnection.getConnection().prepareStatement(sql)){
            statement.setString(1, estado.CANCELADA.name());
            statement.setString(2, cliente);

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0){
                System.out.println("Se ha cancelado la cita de " + cliente);
            }else {
                System.out.println("No se encontraron citas de " + cliente);
            }

        }catch (SQLException e){
            throw new RuntimeException("No se logro cancelar la cita", e);
        }finally {
            MySQLConnection.closeConnection();
        }

    }

    public void reprogramarCita(String cliente, String nuevaFecha, String nuevaHora) {
        // Usamos el estado 'PROGRAMADA' para cuando se reprograma la cita
        String sql = "UPDATE taller_mecanico.citas SET fecha = ?, hora = ?, estado = ? WHERE cliente_id = ?";

        MySQLConnection.conexion();

        try (PreparedStatement statement = MySQLConnection.getConnection().prepareStatement(sql)) {
            // Establecemos los parámetros en la consulta
            statement.setString(1, nuevaFecha);
            statement.setString(2, nuevaHora);
            statement.setString(3, estado.PROGRAMADA.name());
            statement.setString(4, cliente); //

            // Ejecutamos la actualización
            int filasAfectadas = statement.executeUpdate();

            // Verificamos si se afectaron filas (es decir, si se encontró una cita para el cliente)
            if (filasAfectadas > 0) {
                System.out.println("La cita de " + cliente + " ha sido reprogramada a la fecha " + nuevaFecha + " y hora " + nuevaHora);
            } else {
                System.out.println("No se encontró una cita cancelada para " + cliente + " para reprogramar.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se logró reprogramar la cita", e);
        } finally {
            MySQLConnection.closeConnection();
        }
    }


    @Override
    protected String getQuery() {
        return "INSERT INTO taller_mecanico.citas (cliente_id,vehiculo_id,fecha,hora,estado) VALUES (?,?,?,?,?)";

    }

    @Override
    protected void setParametros(PreparedStatement statement) throws SQLException {
        statement.setString(1, this.cliente); // Usamos 'this' para acceder a los atributos de la instancia actual
        statement.setString(2, this.vehiculo);
        statement.setString(3, this.fecha); // Si decides mantener 'String' para fecha
        statement.setString(4, this.hora);
        statement.setString(5, this.estado.name());


    }
//Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Cita.estado getEstado() {
        return estado;
    }

    public void setEstado(Cita.estado estado) {
        this.estado = estado;
    }


}
