package PC;

//Nivel 3
public class Software extends Laptop {
    // Variables
    public String nombreDelSoftware;
    public int memoriaUsada;
    public int memoriaSobrante;
    public boolean esCompatible = false;
    public boolean memoriaSuficiente = false;

    // Constructor de software cargando laptop configuradas
    public Software(Laptop laptop, String nombreDelSoftware, int memoriaUsada) {
        super(laptop.getHostName(), laptop.getCPU(), laptop.getRAM());
        this.nombreDelSoftware = nombreDelSoftware;
        this.memoriaUsada = memoriaUsada;
    }

    // Meotodo para verificar compatibilidad
    public void haySuficienteRam() {
        int RAMInstalled = getRAM();

        memoriaSobrante = 0;
        memoriaSobrante = RAMInstalled - memoriaUsada;

        if (RAMInstalled > memoriaUsada) {
            memoriaSuficiente = true;
            esCompatible = true;

            System.out.println("Hay memoria suficiente. Aun quedan " + memoriaSobrante + "GB");
        } else if (RAMInstalled < memoriaUsada) {
            memoriaSuficiente = false;
            esCompatible = false;

            System.out.println("No hay suficiente memoria disponible");
        }
    }

    // Mostrar software verificado
    public void mostrarConfiguracionDeSoftware() {
        super.mostrarConfiguracionLaptop();
        System.out.println("El software utilizado es: " + nombreDelSoftware);
        System.out.println("Es compatible: " + (esCompatible ? "Si" : "No"));
        System.out.println("Tiene suficiente ram? " + (memoriaSuficiente ? "Si" : "No"));

    }

}
