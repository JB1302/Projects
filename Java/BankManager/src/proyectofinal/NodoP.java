/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author jstev
 */
public class NodoP {

    private Tiquete tiquete;
    private NodoP siguiente;

    // Constructor
    public NodoP(Tiquete tiquete) {
        this.tiquete = tiquete;
        this.siguiente = null;
    }

    // Getters y Setters
    public Tiquete getTiquete() {
        return tiquete;
    }

    public void setTiquete(Tiquete tiquete) {
        this.tiquete = tiquete;
    }

    public NodoP getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoP siguiente) {
        this.siguiente = siguiente;
    }
}
