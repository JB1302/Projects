/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author jstev
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Caja {

    private int idCaja;
    private String tipoCaja; // "preferencial", "rápida", "regular"
    private Queue<NodoC> colaTiquetes;
    private Stack<NodoC> historialAtencion;

    // Constructor
    public Caja(int idCaja, String tipoCaja) {
        this.idCaja = idCaja;
        this.tipoCaja = tipoCaja;
        this.colaTiquetes = new LinkedList<>();
        this.historialAtencion = new Stack<>();
    }

    // Métodos
    public void atenderTiquete() {
        if (!colaTiquetes.isEmpty()) {
            NodoC tiquete = colaTiquetes.poll();
            historialAtencion.push(tiquete);
            
  
            // Lógica de atención al tiquete
        }
    }

    public void agregarTiquete(NodoC nodoC) {
        colaTiquetes.add(nodoC);
    }

    public String generarReporte() {
        String reporte = "Reporte de Atención:\n";
        for (NodoC tiquete : historialAtencion) {
            reporte += tiquete.toString() + "\n";
        }
        return reporte;
    }

    // Getters y Setters
    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public String getTipoCaja() {
        return tipoCaja;
    }

    public void setTipoCaja(String tipoCaja) {
        this.tipoCaja = tipoCaja;
    }

    public Queue<NodoC> getColaTiquetes() {
        return colaTiquetes;
    }

    public void setColaTiquetes(Queue<NodoC> colaTiquetes) {
        this.colaTiquetes = colaTiquetes;
    }

    public Stack<NodoC> getHistorialAtencion() {
        return historialAtencion;
    }

    public void setHistorialAtencion(Stack<NodoC> historialAtencion) {
        this.historialAtencion = historialAtencion;
    }
}