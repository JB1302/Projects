/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Banco {
    private String nombreBanco;
    private List<Caja> cajas;

    // Constructor
    public Banco() {
        this.cajas = new LinkedList<>();
    }

    // Métodos
    public void agregarCaja(Caja caja) {
        this.cajas.add(caja);
    }

    public void cargarConfiguracion() {
        try {
            // Leer el archivo de texto
            FileReader fileReader = new FileReader("configuracion.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Leer y asignar cada línea del archivo a las variables correspondientes
            nombreBanco = bufferedReader.readLine().replace("Nombre del Banco: ", "");
            int cantidadCajas = Integer.parseInt(bufferedReader.readLine().replace("Cantidad de Cajas: ", ""));
            
            // Leer cajas del archivo
            for (int i = 0; i < cantidadCajas; i++) {
                String tipoCaja = bufferedReader.readLine().replace("Caja: ", "");
                Caja caja = new Caja(i + 1, tipoCaja);
                agregarCaja(caja);
            }

            // Cerrar el BufferedReader y FileReader
            bufferedReader.close();
            fileReader.close();

            System.out.println("Configuración cargada correctamente desde el archivo.");

        } catch (IOException | NumberFormatException e) {
            System.out.println("Ocurrió un error al leer el archivo o convertir datos.");
            e.printStackTrace();
        }
    }

    public void guardarConfiguracion() {
        try {
            // Crear el archivo de configuración
            FileWriter fileWriter = new FileWriter("configuracion.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribir datos en el archivo
            bufferedWriter.write("Nombre del Banco: " + nombreBanco);
            bufferedWriter.newLine();

            bufferedWriter.write("Cantidad de Cajas: " + cajas.size());
            bufferedWriter.newLine();

            for (Caja caja : cajas) {
                bufferedWriter.write("Caja: " + caja.getTipoCaja());
                bufferedWriter.newLine();
            }

            // Cerrar los escritores
            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Configuración guardada correctamente en el archivo.");

        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }

    // Getters y Setters
    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public List<Caja> getCajas() {
        return cajas;
    }

    public void setCajas(List<Caja> cajas) {
        this.cajas = cajas;
    }
}

