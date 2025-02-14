/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author jstev
 */
public class Tiquete {
    private String nombreCliente;
    private int idCliente;
    private int edadCliente;
    private String horaCreacion;
    private String horaAtencion;
    private String tramite;
    private String tipo;

    // Constructor
    public Tiquete(String nombreCliente, int idCliente, int edadCliente, String horaCreacion, String tramite, String tipo) {
        this.nombreCliente = nombreCliente;
        this.idCliente = idCliente;
        this.edadCliente = edadCliente;
        this.horaCreacion = horaCreacion;
        this.tramite = tramite;
        this.tipo = tipo;
        this.horaAtencion = "";
    }

    // Getters y Setters
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getEdadCliente() {
        return edadCliente;
    }

    public void setEdadCliente(int edadCliente) {
        this.edadCliente = edadCliente;
    }

    public String getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(String horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    public String getHoraAtencion() {
        return horaAtencion;
    }

    public void setHoraAtencion(String horaAtencion) {
        this.horaAtencion = horaAtencion;
    }

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void atenderTiquete(int numPersonasDelante, int numCaja) {
        if (numPersonasDelante > 0) {
            System.out.println("Caja " + numCaja + " - Clientes delante de usted: " + numPersonasDelante);
        } else {
            System.out.println("Caja " + numCaja + " - Es su turno para ser atendido.");
        }
    }
}
