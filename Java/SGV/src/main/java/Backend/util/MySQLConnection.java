package Backend.util;

import Backend.modelo.Usuario.Usuario;

import java.sql.*;

public class MySQLConnection {

    static String url = "jdbc:mysql://localhost:3306/taller_mecanico";
    static String user = "root";
    static String password = "130213";

    private static Connection connection;

    public static void conexion() {
        try {
            connection = DriverManager.getConnection(getUrl(), getUser(), getPassword());
            System.out.println("Conexion exitosa a base de datos MySQL");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
        }
    }


    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión Cerrada");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al cerrar la conexion", e);
        }
    }


    public static boolean autenticarLogin(String tabla, String correo, String password, Usuario.Role role) {
        boolean autenticado = false;
        conexion();

        String sql = "SELECT * FROM " + tabla + " WHERE correo = ? AND contrasena = ? AND role =?";


        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, correo);
            statement.setString(2, password);
            statement.setString(3, String.valueOf(role));


            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Inicio de sesión exitoso");
                    autenticado = true;
                } else {
                    System.out.println("Error: Credenciales Incorrectas");
                }
            }

        } catch (SQLException e) {
            System.out.println("No se pudo conectar a SQL");
            e.printStackTrace();
        }

        return autenticado;
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
