package Backend.modelo.Usuario;


import Backend.util.MySQLConnection;

public class Administrador extends Usuario {

    public Administrador() {
    }

    public Administrador(String nombre, String correo, String password) {
        super(nombre, correo, password, Role.ADMIN);
    }

    public void iniciarSesion(String correo, String contraseña) {

        boolean autenticado = MySQLConnection.autenticarLogin("taller_mecanico.usuarios", correo, contraseña, Role.ADMIN);

        if (autenticado) {
            System.out.println("Sesión Admin iniciada correctamente");
        } else {
            System.out.println("Error: Credenciales incorrectas");
        }
        MySQLConnection.closeConnection();

    }

    public void cerrarSesion() {
        System.out.println("Sesión cerrada correctamente.");
        MySQLConnection.closeConnection();
    }
}
