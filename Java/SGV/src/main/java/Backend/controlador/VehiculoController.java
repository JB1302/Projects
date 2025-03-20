package Backend.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Backend.util.DatabaseUtil;
import Backend.modelo.Vehiculo.Vehiculo;
import Backend.util.MySQLConnection;

import static Backend.util.MySQLConnection.*;

public class VehiculoController extends DatabaseUtil{

    public VehiculoController() {
    }

    private Vehiculo vehiculo;

    public VehiculoController(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    @Override
    protected String getQuery() {
        return "INSERT INTO taller_mecanico.vehiculos (placa,modelo,ano,historial,propietario) VALUES (?,?,?,?,?)";

    }

    @Override
    protected void setParametros(PreparedStatement statement) throws SQLException {;
        statement.setString(1,vehiculo.getPlaca());
        statement.setString(2,vehiculo.getModelo());
        statement.setInt(3,vehiculo.getAño());
        statement.setString(4,vehiculo.getHistorial());
        statement.setString(5,vehiculo.getPropietario());


    }

    public void actualizarVehiculo(String placa, String historial) {
    //    public Vehiculo(String placa, String modelo, int año, String propietario, String historial) {

       conexion();
        String sql = "UPDATE taller_mecanico.vehiculos Set historial = ? WHERE placa = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setString(1,historial);
            statement.setString(2, placa);

            int filasAfectadas = statement.executeUpdate();

            if(filasAfectadas > 0){
                System.out.println("Se ha actualizado el historial de " + placa);
            }else {
                System.out.println("No se ha encontrado la placa: " + placa);
            }


        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar vehiculo", e);
        }
    }

    public String consultarHistorial(String Placa) {

        conexion();

        String sql = "SELECT historial from Taller_mecanico.vehiculos WHERE placa = ?";

        String response = "";

        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setString(1, Placa);

            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    String historial = resultSet.getString("historial");
                    response = "La ultima revision fue: " + historial;
                }

            }catch (SQLException e){
                throw new RuntimeException("No se ha encontrado la placa", e);
            }

        }catch (SQLException e){
            throw new RuntimeException("No se pudo consultar el historial", e);
        }finally {
            closeConnection();
        }
        return  response;
    }
}
