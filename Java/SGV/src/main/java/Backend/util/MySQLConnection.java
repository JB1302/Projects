package Backend.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    static String url = "jdbc:mysql://localhost:3306/taller_mecanico";
    static String user = "root";
    static String password = "130213";

    private static Connection connection;

    public static void conexion(){
        try {
            connection = DriverManager.getConnection(getUrl(),getUser(),getPassword());
            System.out.println("Conexion exitosa a base de datos MySQL");
        } catch(SQLException e){
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
        }
    }

    public static void closeConnection(){
        try {
            if (connection != null && !connection.isClosed()){
                connection.close();
                System.out.println("Conexión Cerrada");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al cerrar la conexion", e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        MySQLConnection.url = url;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        MySQLConnection.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        MySQLConnection.password = password;
    }
}
