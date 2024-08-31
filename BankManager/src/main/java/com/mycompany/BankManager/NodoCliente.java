/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BankManager;

/**
 *
 * @author Personal
 */
import java.time.LocalDateTime;

public class NodoCliente {
    private String nombre;
    private String id;
    private int edad;
    private LocalDateTime horaCreacion; // Hora en la que se creó el nodo (cliente llegó al banco)
    private LocalDateTime horaAtencion = null; // Hora en la que el cliente fue atendido
    private String tramite; // Tipo de trámite que el cliente necesita realizar
    private char tipo; // 'P' = preferencial, 'A' = un solo trámite, 'B' = dos o más trámites
    private NodoCliente siguiente;

    public NodoCliente(String nombre, String id, int edad, String tramite, char tipo) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.horaCreacion = LocalDateTime.now();
        this.tramite = tramite;
        this.tipo = tipo;
    }

    // Métodos getters y setters...

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDateTime getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(LocalDateTime horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    public LocalDateTime getHoraAtencion() {
        return horaAtencion;
    }

    public void setHoraAtencion(LocalDateTime horaAtencion) {
        this.horaAtencion = horaAtencion;
    }

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public NodoCliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCliente siguiente) {
        this.siguiente = siguiente;
    }

  
    
}

