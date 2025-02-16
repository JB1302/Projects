package Server;

import Logic.EmailHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ServerInteractions extends EmailHandler {

    public void actualizarCorreo(Integer ID){

        String query = "Update empleados SET correo = ? where id = ?";

        try (PreparedStatement statement =  connection.prepareStatement(query)){
            EmailHandler emailHandler = new EmailHandler();

            String correo = emailHandler.correo(1);

            statement.setString(1,correo);
            statement.setInt(2,ID);

            int filasAfectads = statement.executeUpdate();

            if (filasAfectads > 0){
                System.out.println("Correo Actualizado");
            }else {
                System.out.println("No se ha encontrado el empleado "+ ID);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el correo", e);
        }
    }

    public void actualizarInformación(String campo,String valorNuevo, Integer ID){
        String query = "UPDATE empleados SET " + campo + " = ? WHERE id = ?";  // No concatenamos el valorNuevo directamente

        try (PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1,valorNuevo);
            statement.setInt(2,ID);


            int filasAfectads = statement.executeUpdate();

            if (filasAfectads > 0){
                System.out.printf("\n%s Actualizado",campo);
            }else {
                System.out.println("No se ha encontrado el empleado "+ ID);
            }
        }catch (SQLException e){
            throw new RuntimeException("Error actualizando informacion", e);
        }
    }




}
