/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author jstev
 */
public class Cola {
 
    private NodoC frente;
    private NodoC fin;
    private int numCaja;
 
    public Cola(int numCaja) {
        this.frente = null;
        this.fin = null;
        this.numCaja = numCaja;
    }
 
    public void encolar(Tiquete tiquete) {
        NodoC nuevoNodo = new NodoC(tiquete);
        if (fin != null) {
            fin.setSiguiente(nuevoNodo);
        }
        fin = nuevoNodo;
        if (frente == null) {
            frente = fin;
        }
    }
 
    public Tiquete desencolar() {
        if (frente == null) {
            return null;
        }
        Tiquete tiquete = frente.getTiquete();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return tiquete;
    }
 
    public void imprimirEstadoCola() {
        NodoC actual = frente;
        int count = 0;
        while (actual != null) {
            actual.getTiquete().atenderTiquete(count, numCaja);
            actual = actual.getSiguiente();
            count++;
        }
    }
}