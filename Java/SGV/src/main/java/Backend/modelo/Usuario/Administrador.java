package Backend.modelo.Usuario;

public class Administrador extends Usuario {

    public Administrador(String nombre, String correo, String password) {
        super(nombre, correo, password, Role.ADMIN);
    }

    public void iniciarSesion(){}
    public void cerrarSesion(){}

}
