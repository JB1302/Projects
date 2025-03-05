package Backend.modelo.Usuario;

public class Mecanico  extends Usuario {

    public Mecanico(String nombre, String correo, String password, Role role) {
        super(nombre, correo, password, role);
    }

    public void iniciarSesion(){}
    public void cerrarSesion(){}

}
