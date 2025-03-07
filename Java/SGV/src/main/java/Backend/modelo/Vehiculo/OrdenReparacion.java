package Backend.modelo.Vehiculo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrdenReparacion {
    private int id;
    private String placa;
    private String cliente;
    private String descripcionProblema;
    private int mecanicoAsignado;
    LocalDateTime fechaInicio = LocalDateTime.now();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String fechaFormateada = fechaInicio.format(formatter);

    public enum estado {
        PENDIENTE, TRABAJANDO, FINALIZADO
    }

    public OrdenReparacion(String placa, String cliente, String descripcionProblema, String fechaFormateada, int mecanicoAsignado) {
        this.placa = placa;
        this.cliente = cliente;
        this.descripcionProblema = descripcionProblema;
        this.fechaFormateada = fechaFormateada;
        this.mecanicoAsignado = mecanicoAsignado;
    }



    //Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    public int getMecanicoAsignado() {
        return mecanicoAsignado;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFormateada() {
        return fechaFormateada;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setMecanicoAsignado(int mecanicoAsignado) {
        this.mecanicoAsignado = mecanicoAsignado;
    }
}
