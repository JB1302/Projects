package Modelo;

public class Artista {

    String nombre;
    String estilo;
    Integer edad;
    String galeria;
    Double valoracion;

    public Artista(String nombre, String estilo, Integer edad, String galeria, Double valoracion) {
        this.nombre = nombre;
        this.estilo = estilo;
        this.edad = edad;
        this.galeria = galeria;
        this.valoracion = valoracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGaleria() {
        return galeria;
    }

    public void setGaleria(String galeria) {
        this.galeria = galeria;
    }

    public Double getValoracion() {
        return valoracion;
    }

    public void setValoracion(Double valoracion) {
        this.valoracion = valoracion;
    }
}
