package POJO;

public class Reserva {

    //Definir el ENUM
    public enum EstadoEspacio {
        Disponible,
        Reservado
    }

    //Definir Atributos
    private int ID;
    private String Nombre;
    private Double CostPerHour;
    private Double horas;
    private EstadoEspacio estado;


    //Definir Constructor
    public Reserva(int ID, String nombre, Double costPerHour,Double horas, EstadoEspacio estado) {
        this.ID = ID;
        this.Nombre = nombre;
        this.CostPerHour = costPerHour;
        this.horas = horas;
        this.estado = estado;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Double getCostPerHour() {
        return CostPerHour;
    }

    public void setCostPerHour(Double costPerHour) {
        CostPerHour = costPerHour;
    }

    public EstadoEspacio getEstado() {
        return estado;
    }

    public void setEstado(EstadoEspacio estado) {
        this.estado = estado;
    }

    public Double getHoras() {
        return horas;
    }

    public void setHoras(Double horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return  "\n--------------------------\n" +
                "Datos de la reserva:" + "\n" +
                "--------------------------\n" +
                "ID: " + ID + "\n" +
                "Nombre: '" + Nombre + "\n" +
                "Costo por Hora: " + CostPerHour + "\n" +
                "Estado: " + estado + "\n" +
                "--------------------------\n";
    }
}

