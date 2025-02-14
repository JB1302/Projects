package com.mycompany.BankManager;

import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;
import java.time.Duration;
import java.io.File;

/**
 * Clase principal del Proyecto Final.
 * Gestiona la interacción del usuario con el sistema bancario.
 * 
 * Autor: Personal
 */
public class BankManager {

    public static void main(String[] args) {

        // Configuración inicial del sistema bancario
        ConfiguracionBanco configuracion = new ConfiguracionBanco();
        WebScraper webScraper = new WebScraper();

        // Verificar si el archivo de configuración existe
        File archivo = new File("configuracion.txt");
        if (archivo.exists()) {
            configuracion.cargarConfiguracion();  // Cargar configuración existente
        } else {
            configuracion.configuracion();  // Configurar sistema si el archivo no existe
            configuracion.crearTxt();       // Crear archivo de configuración
        }

        // Solicitar número de cajas regulares al usuario
        int numeroCajasRegulares = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de cajas regulares:"));
        SistemaBanco banco = new SistemaBanco(numeroCajasRegulares);
        Registro registro = new Registro();

        while (true) {

            // Opciones del menú principal
            String[] opciones = {"Agregar Cliente", "Atender Siguiente Cliente", "Generar Reporte", 
                                 "Cambio del Dolar", "Salir"};
            
            // Mostrar el menú al usuario
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Sistema Banco",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            // Procesar la opción seleccionada
            switch (opcion) {
                case 0: // Agregar Cliente
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                    char tipo = JOptionPane.showInputDialog("Ingrese el tipo de cliente (P: Preferencial, A: Rápido, R: Regular):").charAt(0);
                    String id = JOptionPane.showInputDialog("Ingrese el id del cliente");
                    String tramite = JOptionPane.showInputDialog("Ingrese el tramite a realizar");
                    NodoCliente nuevoCliente = new NodoCliente(nombre,id , 5, tramite, tipo);
                    banco.asignarClienteACaja(nuevoCliente);
                    break;

                case 1: // Atender Siguiente Cliente
                    int numeroCaja = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la caja que va a atender:"));
                    banco.atenderSiguienteCliente(numeroCaja);
                    break;

                case 2: // Generar Reporte
                    banco.generarReporte();
                    break;

                

                

                case 3: // Cambio del Dolar
                    webScraper.cambioDolar();
                    break;
                    
                    

                case 4: // Salir
                    JOptionPane.showMessageDialog(null, "Gracias por usar el Sistema Banco.");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
