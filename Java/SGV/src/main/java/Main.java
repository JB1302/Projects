import Backend.util.MySQLConnection;

public class Main {
    public static void main(String[] args) {
        MySQLConnection mySQLConnection = new MySQLConnection();

        mySQLConnection.conexion();
        mySQLConnection.closeConnection();

    }
}
