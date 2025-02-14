/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author jstev
 */
public class Pila {
    private NodoP cima;
 
    public Pila() {
        this.cima = null;
    }
 
    public void apilar(Tiquete tiquete) {
        NodoP nuevoNodo = new NodoP(tiquete);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
    }
 
    public Tiquete desapilar() {
        if (cima == null) {
            return null;
        }
        Tiquete tiquete = cima.getTiquete();
        cima = cima.getSiguiente();
        return tiquete;
    }
 
    public boolean estaVacia() {
        return cima == null;
    }
}