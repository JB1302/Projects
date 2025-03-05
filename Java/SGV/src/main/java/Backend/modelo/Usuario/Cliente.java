package Backend.modelo.Usuario;

import Backend.util.MySQLConnection;

public class Cliente extends  Usuario{

    public Cliente() {
    }

    public Cliente(String nombre, String correo, String password) {
        super(nombre, correo, password, Role.CLIENTE);
    }

    public void iniciarSesion(String correo, String contraseña){

        boolean autenticado = MySQLConnection.autenticarLogin("taller_mecanico.usuarios", correo, contraseña,Role.CLIENTE);


        if (autenticado){
            System.out.println("Sesión Cliente iniciada correctamente");
        }else {
            System.out.println("Error: Credenciales incorrectas");
        }
        MySQLConnection.closeConnection();

    }
    public void cerrarSesion(){
        System.out.println("Sesión cerrada correctamente.");
        MySQLConnection.closeConnection();
    }
}

