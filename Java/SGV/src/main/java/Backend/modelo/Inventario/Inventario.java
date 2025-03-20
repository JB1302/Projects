package Backend.modelo.Inventario;

import Backend.util.MySQLConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Backend.util.MySQLConnection.closeConnection;
import static Backend.util.MySQLConnection.getConnection;

public class Inventario {
    List<Pieza> piezas = new ArrayList<>();

    public String mostrarInventario() {
        preCargarInventario();
       return imprimirInventario();
    }

    private void preCargarInventario() {

        String sql = "SELECT nombre,descripcion,cantidad,precio_unitario FROM taller_mecanico.piezas";

        MySQLConnection.conexion();
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                int cantidad = resultSet.getInt("cantidad");
                int precio = resultSet.getInt("precio_unitario");

                Pieza pieza = new Pieza(nombre, descripcion, cantidad, precio);
                piezas.add(pieza);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al cargar el inventario de piezas");
        } finally {
            closeConnection();
        }
        setPiezas(piezas);
    }

    private String imprimirInventario() {
        List<Pieza> piezas = getPiezas();
        StringBuilder inventario = new StringBuilder();
        if (piezas == null || piezas.isEmpty()) {
            inventario.append("El inventario está vacío");
        } else {
            inventario.append("Inventario de Piezas\n");
            for (Pieza pieza : piezas) {
                inventario.append("--------------------------------\n");
                inventario.append("Nombre: ").append(pieza.getNombre()).append("\n");
                inventario.append("Descripción: ").append(pieza.getDescripcion()).append("\n");
                inventario.append("Cantidad: ").append(pieza.getCantidad()).append("\n");
                inventario.append("Precio: ₡").append(pieza.getPrecioUnitario()).append("\n");
            }
        }
        return inventario.toString();
    }

    public String buscarPieza(String nombre) {

        MySQLConnection.conexion();
        String sql = "SELECT nombre,descripcion,cantidad,precio_unitario FROM taller_mecanico.piezas where nombre = ?";

        StringBuilder sb = new StringBuilder();
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setString(1, nombre);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {

                    String descripcion = resultSet.getString("descripcion");
                    int cantidad = resultSet.getInt("cantidad");
                    double precio = resultSet.getDouble("precio_unitario");



                    sb.append("--------------------------------").append("\n");
                    sb.append("Detalles de la pieza: \n").append("\n");
                    sb.append("Nombre: " + nombre).append("\n");
                    sb.append("Descripción: " + descripcion).append("\n");
                    sb.append("Cantidad: " + cantidad).append("\n");
                    sb.append("Precio: ₡" + precio).append("\n");
                    sb.append("--------------------------------");


                    System.out.println(sb);
                } else {
                    System.out.println("La pieza no esta en inventario");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar Pieza", e);
        } finally {
            closeConnection();
        }
        return sb.toString();
    }

    public String actualizarCantidad(String nombre, int cantidad) {

        MySQLConnection.conexion();
        String sql = "UPDATE taller_mecanico.piezas SET cantidad = cantidad + ? WHERE nombre = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, cantidad);
            statement.setString(2, nombre);

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                return "Se ha actualizado la cantidad de inventario de " + nombre;
            } else {
                return "Error, no se encontró una pieza con ese nombre";
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar cantidad", e);
        } finally {
            MySQLConnection.closeConnection();
        }
    }

    public String revisarDisponibilidad(String nombre, int cantidadNecesitada) {
        MySQLConnection.conexion();

        String sql = "SELECT CANTIDAD FROM taller_mecanico.piezas WHERE nombre = ? and cantidad >= ?";

        StringBuilder sb = new StringBuilder();
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setInt(2, cantidadNecesitada);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int cantidad = resultSet.getInt("cantidad");
                    int sobrante = cantidad - cantidadNecesitada;


                    sb.append("\nActualmente hay " + cantidad + " " + nombre + " en inventario");
                    sb.append("\nSobrarian " + sobrante + " " + nombre + "\n");

                    System.out.println(sb);
                } else {
                    System.out.println("No hay suficiente inventario");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al verificar disponibilidad", e);
        } finally {
            MySQLConnection.closeConnection();
        }
        return sb.toString();
    }

    public List<Pieza> getPiezas() {
        return piezas;
    }

    public void setPiezas(List<Pieza> piezas) {
        this.piezas = piezas;
    }
}

