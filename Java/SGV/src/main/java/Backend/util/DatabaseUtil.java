package Backend.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class DatabaseUtil {

    //Metodo abstracto para insertar objetos
    public void insertarObjeto() {
        //Conexión a MySQL
        MySQLConnection.conexion();
        Connection connection = MySQLConnection.getConnection();
        //utilizar un statement abstracto
        //Utilizar un Query Abstracto
        //Construir un PrepareStatement con variables Abstractas
        try (PreparedStatement statement = connection.prepareStatement(getQuery())) {
            //Definir los parametros de la tabla
            setParametros(statement);
            //Por cara columna afectada guardarlo en un int
            int rowsAffected = statement.executeUpdate();
            //Si se ajusto algo
            if (rowsAffected > 0) {
                System.out.println("Objeto insertado correctamente.");
                //Si no se ajusto nada
            } else {
                System.out.println("No se pudo insertar el objeto.");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo insertar el objeto");
            e.printStackTrace();
            //Cerrar conexión
        } finally {
            MySQLConnection.closeConnection();

        }
    }

    //Metodo para obtener la consulta SQL
    protected abstract String getQuery();

    //Metodo abstracto para establecer los parametros
    protected abstract void setParametros(PreparedStatement statement) throws SQLException;
}
