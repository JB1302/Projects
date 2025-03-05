package Backend.modelo.Usuario;

public class Mecanico  extends Usuario {

    public Mecanico(String nombre, String correo, String password) {
        super(nombre, correo, password, Role.MECANICO);
    }

    public void iniciarSesion(){}
    public void cerrarSesion(){}

}
