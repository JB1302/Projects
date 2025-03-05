package Backend.modelo.Usuario;

public class Cliente extends  Usuario{

    public Cliente(String nombre, String correo, String password) {
        super(nombre, correo, password, Role.CLIENTE);
    }

    public void iniciarSesion(){}
    public void cerrarSesion(){}

}
