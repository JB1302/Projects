package Backend.modelo.Vehiculo;

public class OrdenReparacion {
    private int id;
    private String vehiculo;
    private String cliete;
    private String descripcionProblema;
    private String fechaInicio;
    private String mecanicoAsignado;

    private enum estado {
        PENDIENTE, TRABAJANDO, FINALIZADO
    }

    public void actualizarEstado() {

    }

    public void asignarMecanico() {

    }

    //Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getCliete() {
        return cliete;
    }

    public void setCliete(String cliete) {
        this.cliete = cliete;
    }

    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getMecanicoAsignado() {
        return mecanicoAsignado;
    }

    public void setMecanicoAsignado(String mecanicoAsignado) {
        this.mecanicoAsignado = mecanicoAsignado;
    }
}
