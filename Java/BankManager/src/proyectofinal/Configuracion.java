/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;
//Funciones Principales

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
public class Configuracion {

    String nombreBanco;
    int cantidadCajas, cajasRegulares, minimoCajas;

    int cajaPreferencial = 1;
    int cajaRapida = 1;

    public void configuracion() {
        //Definir parametros del banco

        //Strings
        nombreBanco = JOptionPane.showInputDialog("Ingrese el nombre del banco");

        //Revisar que almenos existan 3 cajas
        while (minimoCajas < 3) { // Mientras el minimo no pase de 3
            try { //Intenta pedirle al usuario un numero
                minimoCajas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad total de cajas (Mínimo 3)"));

                if (minimoCajas < 3) { //Si el minimo es menor a 3
                    JOptionPane.showMessageDialog(null, "El mínimo deben ser 3 cajas. Inténtelo de nuevo.");

                } else if (minimoCajas >= 3) { //Si el numero es mayor o igual a 3
                    cantidadCajas = minimoCajas;

                }
            } catch (NumberFormatException e) { // En caso de que no sean numeros
                JOptionPane.showMessageDialog(null, "Ocurrió un error, ingrese un número válido.");
            }
        }

    }

    public void crearTxt() {
        try {
            //Crear el txt.
            FileWriter fileWriter = new FileWriter("prod.txt");

            //Crear un canal para mejorar el rendimiento al crear el texto
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //Transcribir el String a texto
            bufferedWriter.write("Nombre del Banco: " + nombreBanco);
            bufferedWriter.newLine(); // Salto de línea después de cada dato

            bufferedWriter.write("Cantidad de Cajas: " + cantidadCajas); // Maximo de cajas
            bufferedWriter.newLine();

            bufferedWriter.write("Caja Preferencial: " + cajaPreferencial); // Simpre va a ser uno
            bufferedWriter.newLine();

            bufferedWriter.write("Caja Rápida: " + cajaRapida);  // Simpre va a ser uno
            bufferedWriter.newLine();

            cajasRegulares = cantidadCajas - 2;
            bufferedWriter.write("Cajas Regulares: " + cajasRegulares); // Cajas normales - Maximo de cajas - 2 == Cajas regulares
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
            FileReader fileReader = new FileReader("configuracion.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Leer y asignar cada línea del archivo a las variables correspondientes
            nombreBanco = bufferedReader.readLine().replace("Nombre del Banco: ", "");
            cantidadCajas = Integer.parseInt(bufferedReader.readLine().replace("Cantidad de Cajas: ", ""));
            cajaPreferencial = Integer.parseInt(bufferedReader.readLine().replace("Caja Preferencial: ", ""));
            cajaRapida = Integer.parseInt(bufferedReader.readLine().replace("Caja Rápida: ", ""));
            cajasRegulares = Integer.parseInt(bufferedReader.readLine().replace("Cajas Regulares: ", ""));

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
