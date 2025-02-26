package DB;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class BaseDeDatos {
    String rutaArchivo = "DB.txt";
    ;

    public void escribirProducto(productoEspecifico producto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(producto.toString());
            writer.newLine();
            writer.flush();
            System.out.println("Producto guardado en el archivo: " + producto.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public List<productoEspecifico> leerProductos() {
        List<productoEspecifico> productos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 7) {
                    int codigo = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    String descripcion = partes[2];
                    double precioCosto = Double.parseDouble(partes[3]);
                    double precioVenta = Double.parseDouble(partes[4]);
                    String condicion = partes[5];
                    boolean altaPrioridad = Boolean.parseBoolean(partes[6]);

                    productoEspecifico producto = new productoEspecifico(codigo, nombre, descripcion, precioCosto, precioVenta, condicion, altaPrioridad);
                    productos.add(producto);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productos;
    }
}
