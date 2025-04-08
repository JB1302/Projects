package Controlador;

import Modelo.Artista;
import Modelo.DB.Server;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class CRUDcontroller {

    Server server = new Server();

    //Cargar y Mostrar todos los artistas al iniciar el sistema
    public DefaultTableModel mostrarArtista() throws SQLException {
        DefaultTableModel model = new DefaultTableModel();

        server.setConnection();

        try {
            server.setQuery("SELECT * FROM galeriadb.artistas1b2");
            ResultSet rs = server.getQuery().executeQuery();

            ResultSetMetaData rsMetaData = rs.getMetaData();
            int columnCount = rsMetaData.getColumnCount();

            // Añadir columnas al modelo
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rsMetaData.getColumnName(i));
            }

            // Añadir filas al modelo
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

            return model;

        } catch (SQLException e) {
            throw new RuntimeException("No se ha podido cargar la tabla \n", e);
        } finally {
            // Cerrar la conexión al finalizar
            server.closeConnection();
        }
    }


    //Agregar artista a la base de datos
    public void agregarArtista(String nombre, String estilo, Integer edad, String galeria, Double valoracion) {
        try {

            server.setConnection();
            server.setQuery("INSERT INTO galeriadb.artistas1b2 (NombreC3D,EstiloE4F,EdadG5H,GaleriaI6J,ValoracionK7L)\n" + "VALUES(?,?,?,?,?)");

            server.getQuery().setString(1, nombre);
            server.getQuery().setString(2, estilo);
            server.getQuery().setInt(3, edad);
            server.getQuery().setString(4, galeria);
            server.getQuery().setDouble(5, valoracion);

            if (server.getQuery().executeUpdate() > 0) {
                System.out.println("Se ha insertado el cantante: " + nombre);
            }

        } catch (SQLException e) {
            throw new RuntimeException("No se ha podido insertar " + nombre + "\n", e);
        } finally {
            server.closeConnection();
        }
    }


    public void actualizarArtista(String nombre, String estilo, Integer edad, String galeria, Double valoracion) {
        server.setConnection();
        try {
            server.setQuery("UPDATE galeriadb.artistas1b2 SET EstiloE4F = ?, EdadG5H = ?, GaleriaI6J = ?,  ValoracionK7L = ? WHERE NombreC3D = ?");

            server.getQuery().setString(5, nombre);

            server.getQuery().setString(1, estilo);
            server.getQuery().setInt(2, edad);
            server.getQuery().setString(3, galeria);
            server.getQuery().setDouble(4, valoracion);

            if (server.getQuery().executeUpdate() > 0) {
                System.out.println("Se ha actualizo el cantante: " + nombre);
            }

        } catch (SQLException e) {
            throw new RuntimeException("No se ha podido eliminar " + nombre + "\n", e);
        } finally {
            server.closeConnection();
        }
    }

    public void eliminarArtista(String nombre) {
        try {
            server.setConnection();
            server.setQuery("DELETE FROM galeriadb.artistas1b2 WHERE NombreC3D = ?");

            server.getQuery().setString(1, nombre);

            if (server.getQuery().executeUpdate() > 0) {
                System.out.println("Se ha eliminado el cantante: " + nombre);
            }

        } catch (SQLException e) {
            throw new RuntimeException("No se ha podido eliminar " + nombre + "\n", e);
        } finally {
            server.closeConnection();
        }
    }
}
