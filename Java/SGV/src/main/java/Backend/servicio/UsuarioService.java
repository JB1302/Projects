package Backend.servicio;

import Backend.modelo.Usuario.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Backend.util.MySQLConnection.*;


public class UsuarioService {


    public String buscarCliente(String nombre) {
        String sql = "SELECT nombre,correo,role from taller_mecanico.usuarios WHERE correo LIKE ? and role = 'cliente'";

        StringBuilder sb = new StringBuilder();

        conexion();
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + nombre + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                boolean encontrado = false;

                while (resultSet.next()) {
                    encontrado = true;



                    sb.append("Usuario: ").append(resultSet.getString("nombre")).append("\n");
                    sb.append("Correo: ").append(resultSet.getString("correo")).append("\n");
                    sb.append("Tipo: ").append(resultSet.getString("role")).append("\n");


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
        return sb.toString();
    }

    public void actualizarCliente(Cliente cliente) {
        String sql = "UPDATE taller_mecanico.usuarios set nombre = ?, role = ? WHERE correo = ?";
        conexion();

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getRol().name());
            statement.setString(3, cliente.getCorreo());

            int filasActualizadas = statement.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Cliente Actualizado correctamente");
            } else {
                System.out.println("No se encontro el cliente con el correo" + cliente.getCorreo());
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el cliente", e);
        } finally {
            closeConnection();
        }

    }

    public void eliminarCliente(String correo) {
        String sql = "DELETE from taller_mecanico.usuarios WHERE correo = ?";
        conexion();

        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setString(1,correo);

            int filasActualizadas = statement.executeUpdate();

            if (filasActualizadas > 0){
                System.out.println("El usuario con correo: " + correo + " ha sido eliminado");
            }else {
                System.out.println("No se ha encontrado un usuario con " + correo);
            }

        }catch (SQLException e){
            throw new RuntimeException("Error al eliminar Cliente", e);
        }finally {
            closeConnection();
        }
    }

    List<Cliente> clientes = new ArrayList<>();

    public String mostrarClientes() {
        preCargarClientes();
        return imprimirClientes();
    }

    private void preCargarClientes() {
        String sql = "SELECT nombre,correo FROM taller_mecanico.usuarios WHERE role = 'cliente'";

        conexion();

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correo");

                Cliente cliente = new Cliente(nombre, correo, "###");
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al pre-cargar clientes");
        } finally {
            closeConnection();
        }
        setClientes(clientes);
    }

    private String imprimirClientes() {
        List<Cliente> clientes = getClientes();
        StringBuilder sb = new StringBuilder();

        if (clientes == null || clientes.isEmpty()) {
            sb.append("No hay clientes añadidos");
        } else {
            sb.append("Contactos: \n");

            for (Cliente cliente : clientes) {
                sb.append("--------------------------------\n");
                sb.append("Nombre: ").append(cliente.getNombre()).append("\n");
                sb.append("Correo: ").append(cliente.getCorreo()).append("\n");
            }
        }

        return sb.toString();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
