import DB.productoEspecifico;
import DB.BaseDeDatos;
import Productos.Categorias.Electronico;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BaseDeDatos db = new BaseDeDatos();

        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Agregar Producto");

            System.out.println("2. Ver todos los productos");
            System.out.println("3. Ver costos Electronico");
            System.out.println("4. Ver Costos de Ropa");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            if (opcion == 1) {
                // Solicitar datos para crear un nuevo producto
                System.out.print("Ingrese el código del producto: ");
                int codigo = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                System.out.print("Ingrese el nombre del producto: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese la descripción del producto: ");
                String descripcion = scanner.nextLine();
                System.out.print("Ingrese el precio de costo: ");
                double precioCosto = scanner.nextDouble();
                System.out.print("Ingrese el precio de venta: ");
                double precioVenta = scanner.nextDouble();
                System.out.print("Ingrese la condición del producto (NUEVO,USADO,REMANUFACTURADO): ");
                String condicion = scanner.next(); // Condición como String (e.g. NUEVO, USADO)
                System.out.print("¿Es alta prioridad? (true/false): ");
                boolean altaPrioridad = scanner.nextBoolean();

                // Crear el producto
                productoEspecifico producto = new productoEspecifico(codigo, nombre, descripcion, precioCosto, precioVenta, condicion, altaPrioridad);

                // Guardar el producto en la base de datos (archivo)
                db.escribirProducto(producto);
                System.out.println("Producto agregado exitosamente.");

            } else if (opcion == 2) {
                // Leer y mostrar todos los productos
                List<productoEspecifico> productos = db.leerProductos();
                if (productos.isEmpty()) {
                    System.out.println("No hay productos registrados.");
                } else {
                    System.out.println("Productos registrados:");
                    for (productoEspecifico p : productos) {
                        System.out.println("Código: " + p.getCodigo());
                        System.out.println("Nombre: " + p.getNombre());
                        System.out.println("Descripción: " + p.getDescripcion());
                        System.out.println("Precio de Costo: " + p.getPrecioCosto());
                        System.out.println("Precio de Venta: " + p.getPrecioVenta());
                        System.out.println("Condición: " + p.getCondicion());
                        System.out.println("Alta Prioridad: " + p.isAltaPrioridad());
                        System.out.println("------------");
                    }
                }


            } else if (opcion == 3) {
                // Salir del programa
                System.out.println("Saliendo del programa...");
                break;
            } else {
                System.out.println("Opción no válida, intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
