/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BankManager;

/**
 *
 * @author Personal
 */
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.math.BigInteger; //Leer numeros muy grandes

public class ConfiguracionBanco {

    String nombreBanco; 
    int cantidadCajas, cajasRegulares, minimoCajas; // Parámetros de configuración de las cajas
    int cajaPreferencial = 1; // Siempre hay una caja preferencial
    int cajaRapida = 1; // Siempre hay una caja rápida

    // Método configurar banco solicitando datos al usuario
    public void configuracion() {
        // Definir parámetros del banco

        // Solicitar el nombre del banco
        nombreBanco = JOptionPane.showInputDialog("Ingrese el nombre del banco");

        // Asegurarse de que el banco tenga al menos 3 cajas
        while (minimoCajas < 3) { // Mientras el mínimo de cajas no sea al menos 3
            try { // Intentar pedirle al usuario un número válido
                minimoCajas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad total de cajas (minimo 3)"));

                if (minimoCajas < 3) { // Si el número es menor a 3
                    JOptionPane.showMessageDialog(null, "El mínimo deben ser 3 cajas. ingreselo de nuevo.");
                } else if (minimoCajas >= 3) { // Si el número es válido
                    cantidadCajas = minimoCajas;
                }
            } catch (NumberFormatException e) { // excepción caso que no se ingrese un número
                JOptionPane.showMessageDialog(null, "Ocurrió un error, ingrese un número válido.");
            }
        }
    }

    // Método para crear un archivo de configuración del banco
    public void crearTxt() {
        try {
            // Crear el archivo de configuración y escribir los parámetros
            FileWriter fileWriter = new FileWriter("configuracion.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribir la configuración en el archivo
            bufferedWriter.write("Nombre del Banco: " + nombreBanco);
            bufferedWriter.newLine(); // Salto de línea después de cada dato
            bufferedWriter.write("Cantidad de Cajas: " + cantidadCajas);
            bufferedWriter.newLine();
            bufferedWriter.write("Caja Preferencial: " + cajaPreferencial); // Siempre es uno
            bufferedWriter.newLine();
            bufferedWriter.write("Caja Rápida: " + cajaRapida); // Siempre es uno
            bufferedWriter.newLine();

            cajasRegulares = cantidadCajas - 2; // Cajas regulares son las totales menos la preferencial y la rápida
            bufferedWriter.write("Cajas Regulares: " + cajasRegulares);
            bufferedWriter.newLine();

            // Cerrar los recursos
            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Archivo creado.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
            e.printStackTrace(); // Muestra los métodos que se estaban ejecutando cuando falló
        }
    }

    // cargar configuración desde un archivo de texto
    public void cargarConfiguracion() {
        try {
            // Leer el archivo de configuración
            FileReader fileReader = new FileReader("configuracion.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Leer, asignar cada línea del archivo a las variables correspondientes
            nombreBanco = bufferedReader.readLine().replace("Nombre del Banco: ", "");
            cantidadCajas = Integer.parseInt(bufferedReader.readLine().replace("Cantidad de Cajas: ", ""));
            cajaPreferencial = Integer.parseInt(bufferedReader.readLine().replace("Caja Preferencial: ", ""));
            cajaRapida = Integer.parseInt(bufferedReader.readLine().replace("Caja Rápida: ", ""));
            cajasRegulares = Integer.parseInt(bufferedReader.readLine().replace("Cajas Regulares: ", ""));

            // Cerrar los recursos
            bufferedReader.close();
            fileReader.close();

            
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ocurrió un error al leer el archivo o convertir datos.");
            e.printStackTrace();
        }
    }

    // Método para analizar transacciones desde un archivo
    public void analizarTransacciones() {
        try {
            // Leer archivo de transacciones
            FileReader fileReader = new FileReader("transacciones.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;

            int cajaPreferencialClientes = 0; // Contador clientes atendidos por caja preferencial
            int cajaRapidaClientes = 0; // Contador clientes atendidos por caja rápida
            int caja1Clientes = 0; // Contador clientes atendidos por caja 1

            // Acumuladores para tiempo de atención en cada caja
            BigInteger cajaPreferencialTotalTiempo = BigInteger.ZERO;
            BigInteger cajaRapidaTotalTiempo = BigInteger.ZERO;
            BigInteger caja1TotalTiempo = BigInteger.ZERO;

            int cajaPreferencialContador = 0; // Contador de transacciones en la caja preferencial
            int cajaRapidaContador = 0; // Contador de transacciones en la caja rápida
            int caja1Contador = 0; // Contador de transacciones en la caja 1

            while ((linea = bufferedReader.readLine()) != null) {
                // Separar datos de cada transacción
                String[] partes = linea.split(", ");
                String caja = partes[0].split(": ")[1];
                String horaAtencionStr = partes[3].split(": ")[1];
                String horaCreacionStr = partes[2].split(": ")[1];

                // Convertir horas a BigInteger para manejar tiempos largos
                BigInteger horaAtencion = new BigInteger(horaAtencionStr.replaceAll("[^0-9]", "")); //Elegir solo los elementos numericos,
                BigInteger horaCreacion = new BigInteger(horaCreacionStr.replaceAll("[^0-9]", ""));
                BigInteger tiempoAtencion = horaAtencion.subtract(horaCreacion); // Calcular tiempo de atención

                // Sumar tiempo de atención y contar número clientes atendidos por cada caja
                if (caja.equals("Caja Preferencial")) {
                    cajaPreferencialClientes++;
                    cajaPreferencialTotalTiempo = cajaPreferencialTotalTiempo.add(tiempoAtencion);
                    cajaPreferencialContador++;
                } else if (caja.equals("Caja Rápida")) {
                    cajaRapidaClientes++;
                    cajaRapidaTotalTiempo = cajaRapidaTotalTiempo.add(tiempoAtencion);
                    cajaRapidaContador++;
                } else if (caja.equals("Caja 1")) {
                    caja1Clientes++;
                    caja1TotalTiempo = caja1TotalTiempo.add(tiempoAtencion);
                    caja1Contador++;
                }
            }

            // Calcular tiempo promedio de atención en cada caja
            BigInteger cajaPreferencialPromedio = cajaPreferencialTotalTiempo.divide(BigInteger.valueOf(cajaPreferencialClientes));
            BigInteger cajaRapidaPromedio = cajaRapidaTotalTiempo.divide(BigInteger.valueOf(cajaRapidaClientes));
            BigInteger caja1Promedio = caja1TotalTiempo.divide(BigInteger.valueOf(caja1Clientes));

            // Mostrar resultados
            System.out.println("Caja Preferencial: Atendió " + cajaPreferencialClientes + " clientes, tiempo promedio de atención: " + cajaPreferencialPromedio + " milisegundos.");
            System.out.println("Caja Rápida: Atendió " + cajaRapidaClientes + " clientes, tiempo promedio de atención: " + cajaRapidaPromedio + " milisegundos.");
            System.out.println("Caja 1: Atendió " + caja1Clientes + " clientes, tiempo promedio de atención: " + caja1Promedio + " milisegundos.");

            // Cerrar los recursos
            bufferedReader.close();
            fileReader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ocurrió un error al leer el archivo ");
            e.printStackTrace();
        }
    }
}