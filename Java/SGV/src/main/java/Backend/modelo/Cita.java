package Backend.modelo;

public class Cita {
    private int id;
    private String cliente;
    private String vehiculo;
    private String fecha;
    private String hora;
    private enum estado{
        PROGRAMADA,CANCELADA,COMPLETADA
    }

    public void agendarCita(){

    }

    public void cancelarCita(){

    }

    public void reprogramarCita(){

    }

    //Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
