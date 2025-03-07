package Backend.modelo;

public class Garantia {
    public static StringBuilder obtenerGarantia() {
        StringBuilder sb = new StringBuilder();
        sb.append("Garantia valida por 30 dias").append("\n");
        sb.append("Despues del servicio.");
        return sb;
    }
}
