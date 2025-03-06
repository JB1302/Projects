import Backend.controlador.UsuarioController;
import Backend.controlador.VehiculoController;
import Backend.modelo.Inventario.Pieza;
import Backend.modelo.Usuario.Administrador;
import Backend.modelo.Usuario.Cliente;
import Backend.modelo.Usuario.Mecanico;
import Backend.modelo.Usuario.Usuario;
import Backend.modelo.Vehiculo.Vehiculo;
import Backend.modelo.Inventario.Inventario;
import Backend.servicio.UsuarioService;

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


        UsuarioService usuarioService = new UsuarioService();
        usuarioService.buscarCliente("tR");
    }
}