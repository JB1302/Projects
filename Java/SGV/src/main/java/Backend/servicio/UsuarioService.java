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

    public void mostrarClientes() {
        preCargarClientes();
        imprimirClientes();
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

    private void imprimirClientes() {
        List<Cliente> clientes = getClientes();

        if (clientes == null || clientes.isEmpty()) {
            System.out.println("No hay clientes añadidos");
        } else {
            System.out.println("Contactos: ");

            for (Cliente cliente : clientes) {
                System.out.println("--------------------------------");
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Correo: " + cliente.getCorreo());

            }
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
