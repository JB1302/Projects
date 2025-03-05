package Backend.controlador;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Backend.util.DatabaseUtil;
import Backend.modelo.Vehiculo.Vehiculo;

public class VehiculoController extends DatabaseUtil{

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
}
