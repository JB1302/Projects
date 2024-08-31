/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author jstev
 */
import java.util.Queue;

public class GestionTiquetes {

    private NodoC frente;
    private NodoC fin;

    private NodoC Tiquete;

    // Métodos
    public NodoC crearTiquete(int id, String descripcion) {
        // Crear el nuevo Tiquete con los parámetros proporcionados
        Tiquete nuevoTiquete = new Tiquete("Cliente", id, 0, "", "", descripcion);

        // Si la lista está vacía, inicializarla con el nuevo Tiquete
        if (frente == null) {
            frente = new NodoC(nuevoTiquete);
            fin = frente;
            frente.setSiguiente(frente);
            frente.setAnterior(frente);
        } else if (frente.getTiquete().getIdCliente() > nuevoTiquete.getIdCliente()) {
            // Insertar el nuevo Tiquete al inicio de la lista
            NodoC nuevoNodo = new NodoC(nuevoTiquete);
            nuevoNodo.setSiguiente(frente);
            frente.setAnterior(nuevoNodo);
            frente = nuevoNodo;
            fin.setSiguiente(frente);
            frente.setAnterior(fin);
        } else if (fin.getTiquete().getIdCliente() <= nuevoTiquete.getIdCliente()) {
            // Insertar el nuevo Tiquete al final de la lista
            NodoC nuevoNodo = new NodoC(nuevoTiquete);
            fin.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(fin);
            fin = nuevoNodo;
            fin.setSiguiente(frente);
            frente.setAnterior(fin);
        } else {
            // Insertar el nuevo Tiquete en el medio de la lista
            NodoC aux = frente;
            while (aux.getSiguiente() != frente && aux.getSiguiente().getTiquete().getIdCliente() < nuevoTiquete.getIdCliente()) {
                aux = aux.getSiguiente();
            }
            NodoC nuevoNodo = new NodoC(nuevoTiquete);
            nuevoNodo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(aux);
            if (nuevoNodo.getSiguiente() != null) {
                nuevoNodo.getSiguiente().setAnterior(nuevoNodo);
            }
        }
        return frente; // O retornar el nodo recién creado si es necesario
    }

    public void atenderTiquete(Caja caja) {
        caja.atenderTiquete();
    }

    public void llenarColas(Queue<NodoC> cola, NodoC tiquete) {
        cola.add(tiquete);
    }

    public String generarReportes(Caja caja) {
        return caja.generarReporte();
    }

}
