/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinal;

import java.io.File;

/**
 *
 * @author jstev
 */
public class ProyectoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*   Configuracion configuracion = new Configuracion();

        //Verificar El banco
        // Verificar si el archivo de configuración existe
        File archivo = new File("configuracion.txt");
        if (archivo.exists()) {
            // Si el archivo existe, cargar configuración desde él
            configuracion.cargarConfiguracion();
        } else {
            // Si el archivo no existe, solicitar configuración al usuario y luego crear el archivo
            configuracion.configuracion();
            configuracion.crearTxt();
        }

        System.out.println("Nombre del Banco: " + configuracion.nombreBanco);
        System.out.println("Cantidad de Cajas: " + configuracion.cantidadCajas);
        System.out.println("Caja Preferencial: " + configuracion.cajaPreferencial);
        System.out.println("Caja Rápida: " + configuracion.cajaRapida);
        System.out.println("Cajas Regulares: " + configuracion.cajasRegulares); */

 /*
        //Configuración para Verificar Usuario
        Usuario usuario = new Usuario();

        // Verificar si el archivo de configuración existe
        File archivo = new File("Usuarios.txt");
        if (archivo.exists()) {
            // Si el archivo existe, cargar configuración desde él
            usuario.cargarConfiguracion();
        } else {
            // Si el archivo no existe, solicitar configuración al usuario y luego crear el archivo
            usuario.añadirUsuario();
            usuario.crearTxt();
        }
        
         */
        //   usuario.validarUsuario();
        Cola cola = new Cola(3);  // Supongamos que esta es la caja número 1

        cola.encolar(new Tiquete("Cliente1", 1, 25, "10:00", "Trámite1", "Tipo1"));

        cola.encolar(new Tiquete("Cliente2", 2, 30, "10:05", "Trámite2", "Tipo2"));

        cola.encolar(new Tiquete("Cliente3", 3, 35, "10:10", "Trámite3", "Tipo3"));

        // Imprime el estado de la cola mostrando cuántas personas están delante de cada cliente
     //   cola.imprimirEstadoCola();

        // Simula la atención de un cliente
        System.out.print("\n");
        cola.desencolar();  // Atiende al Cliente1

        // Vuelve a imprimir el estado de la cola después de atender al primer cliente

        cola.imprimirEstadoCola();

    }
}
