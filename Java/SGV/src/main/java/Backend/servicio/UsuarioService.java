package Backend.servicio;

import Backend.modelo.Usuario.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Backend.util.MySQLConnection.*;


public class UsuarioService {


    public void buscarCliente(String nombre) {
        String sql = "SELECT nombre,correo,role from taller_mecanico.usuarios WHERE nombre LIKE ? and role = 'cliente'";

        conexion();
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + nombre + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                StringBuilder sb = new StringBuilder();
                boolean encontrado = false;

                while (resultSet.next()) {
                    encontrado = true;


                    sb.append("\n-----------------------------\n");
                    sb.append("Usuario: ").append(resultSet.getString("nombre")).append("\n");
                    sb.append("Correo: ").append(resultSet.getString("correo")).append("\n");
                    sb.append("Tipo: ").append(resultSet.getString("role")).append("\n");
                    sb.append("\n-----------------------------\n");

                }

                if (encontrado) {
                    System.out.println(sb);
                } else {
                    System.out.println("no se han encontrado un ususario");
                }

            } catch (SQLException e) {
                throw new RuntimeException("Error al buscar cliente", e);
            } finally {
                closeConnection();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al utilizar la tabla", e);
        }
    }

    public void actualizarCliente(Cliente cliente) {

    }

    public void eliminarCliente(String correo) {

    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();

        return clientes;
    }

}
