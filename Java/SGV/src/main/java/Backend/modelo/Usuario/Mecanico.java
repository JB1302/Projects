package Backend.modelo.Usuario;

import Backend.util.MySQLConnection;

public class Mecanico extends Usuario {

    public Mecanico() {
    }

    public Mecanico(String nombre, String correo, String password) {
        super(nombre, correo, password, Role.MECANICO);
    }

    public boolean iniciarSesion(String correo, String contraseña) {

        boolean autenticado = MySQLConnection.autenticarLogin("taller_mecanico.usuarios", correo, contraseña, Role.MECANICO);

        if (autenticado) {
            System.out.println("Sesión mecanico iniciada correctamente");
        } else {
            System.out.println("Error: Credenciales incorrectas");
        }
        MySQLConnection.closeConnection();
        return autenticado;
    }

    public void cerrarSesion() {
        System.out.println("Sesión cerrada correctamente.");
        MySQLConnection.closeConnection();
    }
}

