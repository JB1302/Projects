package Backend.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class DatabaseUtil {

    public void insetarObjecto(){
        Connection connection = MySQLConnection.getConnection();

       try (PreparedStatement statement = connection.prepareStatement(getQuery())){
           setParametros(statement);


           int rowsAffected = statement.executeUpdate();

           if (rowsAffected > 0){
               System.out.println("Objeto insertado correctamente.");
           }else{
               System.out.println("No se pudo insertar el objeto.");
           }

       }catch (SQLException e){
           System.out.println("No se pudo insertar el objeto");
           e.printStackTrace();

       }finally {
           MySQLConnection.closeConnection();

       }
    }

    //Metodo para obtener la consulta SQL
    protected abstract String getQuery();

    //Metodo abstracto para establecer los parametros
    protected abstract void setParametros(PreparedStatement statement) throws SQLException;
}
