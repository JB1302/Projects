package Backend.modelo.Usuario;

public class Administrador extends Usuario {

    public Administrador(String nombre, String correo, String password, Role role) {
        super(nombre, correo, password, role);
    }

    public void iniciarSesion(){}
    public void cerrarSesion(){}

}
