/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BankManager;

/**
 *
 * @author Personal
 */import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Registro {
    private static final String NOMBRE_ARCHIVO = "transacciones.txt";

    public void registrarTransaccion(String nombreCaja, NodoCliente cliente) {
        try (FileWriter writer = new FileWriter(NOMBRE_ARCHIVO, true)) {
            writer.write("Caja: " + nombreCaja + ", Cliente: " + cliente.getNombre() + ", ID: " + cliente.getId() +
                    ", Hora Creación: " + cliente.getHoraCreacion() + ", Hora Atención: " + cliente.getHoraAtencion() +
                    "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la transacción.");
            e.printStackTrace();
        }
    }

    public void generarReporte() {
        Map<String, Integer> cantidadClientesPorCaja = new HashMap<>();
        Map<String, Duration> tiempoTotalPorCaja = new HashMap<>();
        int totalClientes = 0;
        Duration tiempoTotalGeneral = Duration.ZERO;

        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                totalClientes++;
                procesarLinea(linea, cantidadClientesPorCaja, tiempoTotalPorCaja);
                Duration tiempoAtencion = calcularTiempoAtencion(linea);
                tiempoTotalGeneral = tiempoTotalGeneral.plus(tiempoAtencion);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de transacciones.");
            e.printStackTrace();
        }

        String cajaMayorClientes = obtenerCajaMayorClientes(cantidadClientesPorCaja);
        String cajaMejorTiempo = obtenerCajaMejorTiempo(tiempoTotalPorCaja, cantidadClientesPorCaja);
        double tiempoPromedioGeneral = calcularTiempoPromedioGeneral(tiempoTotalGeneral, totalClientes);

       mostrarResultados(cajaMayorClientes, totalClientes, cajaMejorTiempo, tiempoPromedioGeneral);
    }

    private void procesarLinea(String linea, Map<String, Integer> cantidadClientesPorCaja, Map<String, Duration> tiempoTotalPorCaja) {
        String[] partes = linea.split(", ");
        String nombreCaja = partes[0].split(": ")[1];
        Duration tiempoAtencion = calcularTiempoAtencion(linea);

        cantidadClientesPorCaja.put(nombreCaja, cantidadClientesPorCaja.getOrDefault(nombreCaja, 0) + 1);
        tiempoTotalPorCaja.put(nombreCaja, tiempoTotalPorCaja.getOrDefault(nombreCaja, Duration.ZERO).plus(tiempoAtencion));
    }

    public Duration calcularTiempoAtencion(String linea) {
        String[] partes = linea.split(", ");
        LocalDateTime horaCreacion = LocalDateTime.parse(partes[3].split(": ")[1]);
        LocalDateTime horaAtencion = LocalDateTime.parse(partes[4].split(": ")[1]);

        return Duration.between(horaCreacion, horaAtencion);
    }

    private String obtenerCajaMayorClientes(Map<String, Integer> cantidadClientesPorCaja) {
        return Collections.max(cantidadClientesPorCaja.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public String obtenerCajaMejorTiempo(Map<String, Duration> tiempoTotalPorCaja, Map<String, Integer> cantidadClientesPorCaja) {
        String cajaMejorTiempo = "";
        double mejorTiempoPromedio = Double.MAX_VALUE;

        for (Map.Entry<String, Duration> entry : tiempoTotalPorCaja.entrySet()) {
            String caja = entry.getKey();
            Duration tiempoTotal = entry.getValue();
            int cantidadClientes = cantidadClientesPorCaja.get(caja);
            double tiempoPromedio = (double) tiempoTotal.toMillis() / cantidadClientes;

            if (tiempoPromedio < mejorTiempoPromedio) {
                mejorTiempoPromedio = tiempoPromedio;
                cajaMejorTiempo = caja;
            }
        }

        return cajaMejorTiempo;
    }

    private double calcularTiempoPromedioGeneral(Duration tiempoTotalGeneral, int totalClientes) {
        return (double) tiempoTotalGeneral.toMillis() / totalClientes;
    }

    public void mostrarResultados(String cajaMayorClientes, int totalClientes, String cajaMejorTiempo, double tiempoPromedioGeneral) {
        
        
        
        
        while (true) {

            String[] opciones = {"Caja con mayor cantidad de clientes", "Total de clientes atendidos","Caja con mejor tiempo", "Tiempo promedio de atencion general", 
                                "Salir"};
            
            
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Reportes",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            // Procesar la opción seleccionada
            switch (opcion) {
                case 0: 
                    JOptionPane.showMessageDialog(null,"Caja con mayor cantidad de clientes: " + cajaMayorClientes);
                  
                    break;

                case 1: 
                      JOptionPane.showMessageDialog(null,"Total de clientes atendidos: " + totalClientes );
                    
                    break;
                    
                case 2:
                    JOptionPane.showMessageDialog(null,"Caja con el mejor tiempo de atencion es: " + cajaMejorTiempo );
                    break;

                case 3: 
                    
                      JOptionPane.showMessageDialog(null,"Tiempo promedio de atención en general: " + tiempoPromedioGeneral + " ms");
                    
                    break;

           

                case 4: // Salir
                    JOptionPane.showMessageDialog(null, "Salir de la seccion de ver el reporte.");
                    return;
              

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                    break;
            }
        }
        
        
    }
}