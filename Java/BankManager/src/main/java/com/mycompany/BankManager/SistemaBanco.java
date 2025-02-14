/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BankManager;

/**
 *
 * @author Personal
 */

import javax.swing.JOptionPane;


import java.util.HashMap;
import java.util.Map;

public class SistemaBanco {
    private Map<Integer, ColaClientes> cajasRegulares = new HashMap<>(); // Mapa que contiene las colas de clientes para las cajas regulares
    private ColaClientes cajaPreferencial = new ColaClientes(); // Cola clientes preferenciales
    private ColaClientes cajaRapida = new ColaClientes(); // Cola clientes con un solo trámite
    private Registro registroTransacciones = new Registro();
    
    // Crear cola de clientes para cada caja regular
    public SistemaBanco(int numeroCajasRegulares) {
        for (int i = 1; i <= numeroCajasRegulares; i++) {
            cajasRegulares.put(i, new ColaClientes());
        }
    }
    
    public void asignarClienteACaja(NodoCliente cliente) {
        // Si cliente es preferencial se asigna a cola preferencial y se atiende de inmediato
        if (cliente.getTipo() == 'P') {
            cajaPreferencial.encolarCliente(cliente);
            atenderClientePreferencial();
          // Si cliente tiene un solo trámite se asigna a la cola rápida y se atiende de inmediato
        } else if (cliente.getTipo() == 'A') {
            cajaRapida.encolarCliente(cliente);
            atenderClienteRapido();
          // Si cliente tiene dos o más trámites se asigna a la caja regular menos ocupada
        } else {
            int numeroCaja = obtenerCajaMenosLlena();
            cajasRegulares.get(numeroCaja).encolarCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente asignado a la caja " + numeroCaja + ". Personas por delante: " + (cajasRegulares.get(numeroCaja).getTamaño() - 1));
        }
    }

    private int obtenerCajaMenosLlena() {
        int numeroCaja = 1;  // Inicia con la primera caja
        int menorTamaño = Integer.MAX_VALUE; // Inicializa el menor tamaño con un valor muy grande

        for (Map.Entry<Integer, ColaClientes> entry : cajasRegulares.entrySet()) {
            int tamañoActual = entry.getValue().getTamaño();
            if (tamañoActual < menorTamaño) {
                menorTamaño = tamañoActual;
                numeroCaja = entry.getKey();
            }
        }

        return numeroCaja; // Devuelve el número de la caja menos ocupada
    }

    private void atenderClientePreferencial() {
        NodoCliente clienteAtendido = cajaPreferencial.atenderCliente();  // Extrae al cliente de la cola preferencial
        if (clienteAtendido != null) {
            JOptionPane.showMessageDialog(null, "Cliente preferencial " + clienteAtendido.getNombre() + " está siendo atendido.");
            registroTransacciones.registrarTransaccion("Caja Preferencial", clienteAtendido);
        }
    }

    private void atenderClienteRapido() {
        NodoCliente clienteAtendido = cajaRapida.atenderCliente(); // Extrae al cliente de la cola rápida
        if (clienteAtendido != null) {
            JOptionPane.showMessageDialog(null, "Cliente rápido " + clienteAtendido.getNombre() + " está siendo atendido.");
            registroTransacciones.registrarTransaccion("Caja Rápida", clienteAtendido); // Registra transacción en el archivo
        }
    }

    public void atenderSiguienteCliente(int numeroCaja) {
        NodoCliente clienteAtendido = cajasRegulares.get(numeroCaja).atenderCliente();
        if (clienteAtendido != null) {
            JOptionPane.showMessageDialog(null, "Cliente " + clienteAtendido.getNombre() + " de la caja " + numeroCaja + " está siendo atendido.");
            registroTransacciones.registrarTransaccion("Caja " + numeroCaja, clienteAtendido);
        }
    }

    public void generarReporte() {
        registroTransacciones.generarReporte();
    }
}
