package PC;

//Nivel 2
public class Laptop extends componentesPrincipales {
    // Variables
    int ssdSize;
    String tipoDePantalla;
    int tamanoDePantalla;

    // Constructor de laptop
    public Laptop(String hostName, String CPU, int RAM) {
        super(hostName, CPU, RAM);
    }

    // Constructor de Laptop - Sobreescritura
    public Laptop(String hostName, String CPU, int RAM, String tipoDePantalla, int tamanoDePantalla) {
        super(hostName, CPU, RAM);
        this.tipoDePantalla = tipoDePantalla;
        this.tamanoDePantalla = tamanoDePantalla;
    }

    // Prueba del Super y Mostrar configuracion de la Laptop
    public void mostrarConfiguracionLaptop() {
        super.mostrarDetalles();
    }

}
