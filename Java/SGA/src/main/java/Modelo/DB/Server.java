package Modelo.DB;

import java.sql.*;

public class Server {

    Connection connection = null;
    PreparedStatement query = null;
    ResultSet result = null;

    Credentials credentials = new Credentials();
    String url = credentials.url;
    String user = credentials.user;
    String password = credentials.pass;

    public void setConnection(){
        try {
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Se ha conectado a la base de datos exitosamente\n");
        } catch (SQLException e) {
            throw new RuntimeException("No se ha podido conectar a la DB", e);
        }
    }

    public void closeConnection(){
        try{
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se logro cerrar la conexion", e);
        }
    }

    public void setQuery(String Query){
        try {
           query = connection.prepareStatement(Query);

        } catch (SQLException e) {
            throw new RuntimeException("No se ha cargado el Query", e);
        }
    }

    public PreparedStatement getQuery() {
        return query;
    }
}
