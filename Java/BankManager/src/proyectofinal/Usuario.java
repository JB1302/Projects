/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import javax.swing.JOptionPane;

import javax.swing.JOptionPane; //Manejar entradas de texto
import java.io.IOException; //Para manejar exepciones en caso de que no funcionen
//Import de Salida
import java.io.BufferedWriter; //Almacena los datos antes de crear el documento
import java.io.FileWriter; //Se usa para escribir datos a un txt 
//Import de Entrada
import java.io.File; //Cargar el archivo txt
import java.io.BufferedReader; //Mejorar el rendimiento al cargar txt
import java.io.FileReader; // Leer el archivo txt

/**
 *
 * @author jstev
 */
public class Usuario {

    String nombreUsuario, contraseñaUsuario;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseñaUsuario;
    }

    public void setContraseña(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }

    public void añadirUsuario() {

        try {
            //Definir Nombre
            String nombre = null;
            while (nombre == null || nombre.isEmpty()) {
                nombre = JOptionPane.showInputDialog(null, "Favor Digitar su nombre de Usuario");
                if (nombre == null || nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se ha ingresado ningún valor. Por favor, ingrese su nombre de usuario.");
                }
                if (nombre != null || !nombre.isEmpty()) {
                    setNombreUsuario(nombre);
                }
            }

            //Definir Contraseña
            String password = null;
            while (password == null || password.isEmpty()) {
                password = JOptionPane.showInputDialog(null, "Favor Digitar la Contraseña de Usuario");
                if (password == null || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se ha ingresado ningún valor. Por favor, ingrese la contraseña de usuario.");
                }
                if (password != null || !password.isEmpty()) {
                    setContraseña(password);
                }
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }

    public void validarUsuario() {
        String passwordAxuliar = null;
        String usuarioAuxiliar = null;
        boolean usuarioVerificado = false;
        while (usuarioVerificado == false) {

            usuarioAuxiliar = JOptionPane.showInputDialog(null, "Favor digite su nombre de Usuario"); //Pedir Usuario
            if (usuarioAuxiliar == null || usuarioAuxiliar.isEmpty()) { //Si esta vacio re intentar
                JOptionPane.showMessageDialog(null, "Debe ingresar un nombre de usuario");
                continue; //Saltar a la siguiente ejecución del codigo, en este caso el IF
            }

            passwordAxuliar = JOptionPane.showInputDialog(null, "Favor digite su contraseña"); //Pedir Contraseña
            if (passwordAxuliar == null || passwordAxuliar.isEmpty()) { // Si esta vacio re intentar
                JOptionPane.showMessageDialog(null, "Debe ingresar una contraseña");
                continue; //Saltar a la siguiente ejecución del codigo, en este caso el IF
            }

            if (!contraseñaUsuario.equals(passwordAxuliar)) { //Si la contraseña esta mal reiniciar.
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                continue;
            }

            usuarioVerificado = true; // Cerrar el While
            JOptionPane.showMessageDialog(null, "Usuario verificado");
        }
    }

    public void crearTxt() {
        try {
            //Crear el txt.
            FileWriter fileWriter = new FileWriter("usuarios.txt");

            //Crear un canal para mejorar el rendimiento al crear el texto
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //Transcribir el String a texto
            bufferedWriter.write("Nombre de Usuario: " + nombreUsuario);
            bufferedWriter.newLine(); // Salto de línea después de cada dato

            bufferedWriter.write("Contraseña de Usuario: " + contraseñaUsuario);
            bufferedWriter.newLine();

            //Cierra los imports
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) { //El parametro e, es una referncia al error 
            System.out.println("Ocurrió un error al escribir en el archivo.");
            e.printStackTrace(); //Muestra los metodos que se estaban ejecuntado cuando fallo

        }
    }

    public void cargarConfiguracion() {
        try {
            // Leer el archivo de texto
            FileReader fileReader = new FileReader("usuarios.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Leer y asignar cada línea del archivo a las variables correspondientes
            nombreUsuario = bufferedReader.readLine().replace("Nombre de Usuario: ", "");
            contraseñaUsuario = bufferedReader.readLine().replace("Contraseña de Usuario: ", "");

            // Cerrar el BufferedReader y FileReader
            bufferedReader.close();
            fileReader.close();

            System.out.println("Configuración cargada correctamente desde el archivo." + "\n");

        } catch (IOException | NumberFormatException e) {
            System.out.println("Ocurrió un error al leer el archivo o convertir datos.");
            e.printStackTrace();
        }
    }

}
