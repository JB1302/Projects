import Backend.controlador.UsuarioController;
import Backend.modelo.Usuario.Cliente;
import Backend.modelo.Usuario.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario cliente = new Cliente("Lucy Doe", "Lucy@example.com", "123");

        UsuarioController usuarioController = new UsuarioController(cliente);
        usuarioController.insertarObjeto();
    }
}