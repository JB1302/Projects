package PC;
//Nivel 1
public class componentesPrincipales {
    //Definir variables
    private String hostName;
    private String CPU;
    private int RAM;
    final String ipAddress = "192.168.45.123";

    //Constructor base de componentes
    public componentesPrincipales(String hostName, String CPU, int RAM) {
        this.hostName = hostName;
        this.CPU = CPU;
        this.RAM = RAM;
    }

    //Getters & Setters
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    //Mostrar componentes con texto texturizado
    public void mostrarDetalles(){
        System.out.printf("\nNueva conexión; %s\n|Host: %s | CPU: %s | Ram: %d GB|\n", ipAddress, hostName, CPU, RAM);
    }

    //Main
    public static void main(String[] args){

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Configurando las laptops");

        //Construir Laptops
        Laptop laptop1 = new Laptop("Maria", "Intel I5", 16, "LED", 11 );
        //Sobreescritura
        Laptop laptop2 = new Laptop("Juan", "Intel I9", 64);

        //cargar laptops construidas
        laptop1.mostrarConfiguracionLaptop();
        laptop2.mostrarConfiguracionLaptop();

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Ejecutando el Software");

        //Configurar software - Caso Aprovado
        Software software1 = new Software(laptop1,"Teams",1);
        software1.haySuficienteRam();
        software1.mostrarConfiguracionDeSoftware();

        //Configurar software - Caso Fallido
        Software software2 = new Software(laptop2,"Warzone",500);
        software2.haySuficienteRam();
        software2.mostrarConfiguracionDeSoftware();

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");

    }
}
