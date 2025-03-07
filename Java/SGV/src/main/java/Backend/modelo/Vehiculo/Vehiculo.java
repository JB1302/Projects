package Backend.modelo.Vehiculo;

public class Vehiculo {

    //Variables
    private int id;
    private String placa;
    private String modelo;
    private int año;
    private String propietario;
    private String historial;

    //Constructor


    public Vehiculo(String placa, String modelo, int año, String propietario, String historial) {
        this.placa = placa;
        this.modelo = modelo;
        this.año = año;
        this.propietario = propietario;
        this.historial = historial;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }
}

