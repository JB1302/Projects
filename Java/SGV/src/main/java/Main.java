import Backend.controlador.*;
import Backend.modelo.Cita;
import Backend.modelo.Factura;
import Backend.modelo.Inventario.Pieza;
import Backend.modelo.Notificacion;
import Backend.modelo.Usuario.Administrador;
import Backend.modelo.Usuario.Cliente;
import Backend.modelo.Usuario.Mecanico;
import Backend.modelo.Usuario.Usuario;
import Backend.modelo.Vehiculo.OrdenReparacion;
import Backend.modelo.Vehiculo.Vehiculo;
import Backend.modelo.Inventario.Inventario;
import Backend.servicio.UsuarioService;
import Backend.controlador.ReparacionController;
import Backend.controlador.ReparacionController.estado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        //--Manejo de Usuarios
        // Crear Usuarios (Clientes, Mecánicos, Administradores)
        Usuario cliente = new Cliente("Trump Doe", "Trump@example.com", "123");
        Usuario Mecanico = new Mecanico("Jonathan", "johnB@gmail.com", "123");
        Usuario Admin = new Administrador("Steven", "jstevenbarrantes@gmail.com", "Clave");

        // Controladores de Usuarios
        UsuarioController ControllerCliente = new UsuarioController(cliente);
        UsuarioController ControllerMecanico = new UsuarioController(Mecanico);
        UsuarioController ControllerAdmin = new UsuarioController(Admin);

        // Insertar Usuarios
        ControllerCliente.insertarObjeto();
        ControllerMecanico.insertarObjeto();


        //-- Manejo de Vehículos
        // Crear Vehículo
        Vehiculo vehiculo = new Vehiculo("blk500", "spark", 2017, "Steven", "n/a");

        // Controlador de Vehículo
        VehiculoController vehiculoController = new VehiculoController(vehiculo);

        // Insertar Vehículo
        vehiculoController.insertarObjeto();

        // --Inicio de Sesión
        // Crear Instancias para Administrador, Mecánico y Cliente
        Administrador administrador = new Administrador();
        Mecanico mecanico = new Mecanico();
        Cliente cliente = new Cliente();

        // Iniciar sesión para Administrador, Mecánico y Cliente
        administrador.iniciarSesion("jstevenbarrantes@gmail.com", "Clave");
        mecanico.iniciarSesion("johnB@gmail.com", "123");
        cliente.iniciarSesion("john@example.com", "123");

        //Cerrar Sesión
        administrador.cerrarSesion();
        mecanico.cerrarSesion();
        cliente.cerrarSesion();


        // --Manejo de Piezas
        // Crear Pieza
        Pieza pieza = new Pieza("Arandela", "Arandela Basica", 5, 70);

        // Insertar Pieza
        pieza.insertarObjeto();

        //--Manejo de Inventario
        // Crear Inventario
        Inventario inventario = new Inventario();

        // Mostrar Inventario
        inventario.mostrarInventario();

        // Otras operaciones de inventario
        // inventario.actualizarCantidad("Tornillo", 50);
        // inventario.revisarDisponibilidad("Tornillo", 15);
        // inventario.buscarPieza("Tornillo");

         */


       // UsuarioService usuarioService = new UsuarioService();
        //usuarioService.buscarCliente("tR");
        //Scanner sb = new Scanner("Ingrese correo a buscar:");
        // String correo = sb.toString();
        //String correo = "Lucy@example.com";
        //String nombre = "Lucy Doe";
        //String password = "123";
        //Cliente clienteActualizar = new Cliente(nombre,correo,password);
       // usuarioService.actualizarCliente(clienteActualizar);

        //usuarioService.mostrarClientes();
       // usuarioService.eliminarCliente("Trump@example.com");

        //VehiculoController vehiculoController = new VehiculoController();

        //vehiculoController.actualizarVehiculo("BLK500","Revisado");
        //vehiculoController.consultarHistorial("blk500");

        /*
        LocalDateTime fechaActual = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaFormateada = fechaActual.format(formatter);

        OrdenReparacion ordenReparacion = new OrdenReparacion("BLK500","Steven","chillido",fechaFormateada,12);
        ReparacionController reparacionController = new ReparacionController(ordenReparacion);
        reparacionController.insertarObjeto(); */

      //  ReparacionController reparacionController = new ReparacionController();
      //  reparacionController.actualizarEstado("blk500", estado.TRABAJANDO);
      //  reparacionController.asignarMecanico("blk500",12);

        //String fechaConvertida = String.valueOf(new Cita().convertirStringADate("6-3-2025"));

        //Cita cita = new Cita("StevenB", "blk500",fechaConvertida,"9:47");
        //cita.insertarObjeto();

        //Cita cita = new Cita();
        //cita.cancelarCita("StevenB");
        //String fechaConvertida = String.valueOf(new Cita().convertirStringADate("9-3-2025"));
        //cita.reprogramarCita("StevenB",fechaConvertida,"10:15");


        Notificacion notificacion = new Notificacion();

        notificacion.enviarNotificacionesOrdenesAbiertas();
    }
}