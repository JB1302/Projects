/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author jstev
 */
public class NodoC {

    private Tiquete tiquete;
    private NodoC siguiente;
    private NodoC anterior;

    // Constructor
    public NodoC(Tiquete tiquete) {
        this.tiquete = tiquete;
        this.siguiente = null;
        this.anterior = null;
    }

    // Getters y Setters
    public Tiquete getTiquete() {
        return tiquete;
    }

    public void setTiquete(Tiquete tiquete) {
        this.tiquete = tiquete;
    }

    public NodoC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoC siguiente) {
        this.siguiente = siguiente;

    }

    public NodoC getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoC anterior) {
        this.anterior = anterior;
    }
}
