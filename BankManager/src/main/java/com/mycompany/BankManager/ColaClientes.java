/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BankManager;

import java.time.LocalDateTime;

/**
 *
 * @author Personal
 */
public class ColaClientes {
    private NodoCliente frente; // Primer cliente en la cola
    private NodoCliente fin; // Ultimo cliente en la cola
    private int tamaño; // Cantidad de clientes en la cola

    // Constructor de la clase
   public ColaClientes() {
        this.frente = null; // La cola inicia vacía, sin clientes en el frente
        this.fin = null; // La cola inicia vacía, sin clientes en el fin
        this.tamaño = 0; // El tamaño inicial es cero
    }

    // Método para agregar un cliente a la cola
    public void encolarCliente(NodoCliente nuevoCliente) {
        if (fin == null) { // Si la cola está vacía
            frente = fin = nuevoCliente; // El nuevo cliente es el único, es frente y fin
        } else {
            fin.setSiguiente(nuevoCliente); // El nuevo cliente se coloca al final de la cola
            fin = nuevoCliente; // El nuevo cliente ahora es el último en la cola
        }
        tamaño++; // Incrementar el tamaño de la cola
    }

    // Método para atender al cliente al frente de la cola
    public NodoCliente atenderCliente() {
        if (frente == null) { // Si la cola está vacía
            System.out.println("La cola está vacía.");
            return null; 
        }
        NodoCliente clienteAtendido = frente; // El cliente al frente es el que será atendido
        frente = frente.getSiguiente(); // El siguiente cliente convierte en el nuevo frente de la cola
        if (frente == null) { // 
            fin = null; // La cola ahora está vacía
        }
        tamaño--; // Reducir el tamaño de la cola
        clienteAtendido.setHoraAtencion(LocalDateTime.now()); // Registrar hora en que fue atendido el cliente
        return clienteAtendido; // Retornar el cliente que fue atendido
    }

   
    public int getTamaño() {
        return tamaño;
    }
}

