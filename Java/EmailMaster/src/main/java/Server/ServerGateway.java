package Server;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServerGateway extends Credentials {

    protected Connection connection;

    public ServerGateway() {
        try {
            //Conectar a base de Datos
            connection = DriverManager.getConnection(super.url, super.username, super.password);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la base de Datos", e);
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexíon Cerrada");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al cerrar la conexion", e);
        }
    }

}

