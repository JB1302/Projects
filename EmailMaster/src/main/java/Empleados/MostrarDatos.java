package Empleados;

import Logic.EmailHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MostrarDatos extends EmailHandler {

    public void mostrarDatos(Integer ID) {
        String query = "SELECT * from empleados where id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, ID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Si encontramos un resultado, lo mostramos
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    String correo = resultSet.getString("correo");

                    // Mostrar los datos
                    System.out.println("\n\nEmpleado encontrado:");
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Apellido: " + apellido);
                    System.out.println("Correo: " + correo);
                } else {
                    System.out.println("Empleado con ID " + ID + " no encontrado.");
                }

            } catch (SQLException e) {
                throw new RuntimeException("No se ha podido mostrar los datos", e);
            }

        } catch (SQLException e) {
            throw new RuntimeException("No se ha podido mostrar los datos", e);
        }
    }
}
