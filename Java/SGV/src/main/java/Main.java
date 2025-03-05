import Backend.controlador.UsuarioController;
import Backend.controlador.VehiculoController;
import Backend.modelo.Usuario.Administrador;
import Backend.modelo.Usuario.Cliente;
import Backend.modelo.Usuario.Mecanico;
import Backend.modelo.Usuario.Usuario;
import Backend.modelo.Vehiculo.Vehiculo;

public class Main {
    public static void main(String[] args) {

        /* Manejar Ingreso de Datos
        Usuario cliente = new Cliente("Trump Doe", "Trump@example.com", "123");
        Usuario Mecanico = new Mecanico("Jonathan", "johnB@gmail.com","123");
        Usuario Admin = new Administrador("Steven", "jstevenbarrantes@gmail.com","Clave");

        UsuarioController ControllerCliente = new UsuarioController(cliente);
        UsuarioController ControllerMecanico = new UsuarioController(Mecanico);
        UsuarioController ControllerAdmin = new UsuarioController(Admin);

        ControllerCliente.insertarObjeto();
        ControllerMecanico.insertarObjeto(); */

        Vehiculo vehiculo = new Vehiculo("blk500","spark",2017,"Steven","n/a");
        VehiculoController vehiculoController = new VehiculoController(vehiculo);

        vehiculoController.insertarObjeto();
    }
}