package com.caso2.domain;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Data;

@Data
public class Carro {

    private int idCarro;
    private String descripcion;
    private int cilindros;
    private Date modelo;

    public Carro() {
    }

    public Carro(int idCarro, String descripcion, int cilindros) {
        this.idCarro = idCarro;
        this.descripcion = descripcion;
        this.cilindros = cilindros;
        this.modelo = new Date();
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCilindros() {
        return cilindros;
    }

    public void setCilindros(int cilindros) {
        this.cilindros = cilindros;
    }

    public String getModelo() {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");        
        return formatter.format(modelo);
    }

    public void setModelo(String modelo) {
        this.modelo = getDateFormat("yyyy-mm-dd", modelo);
    }

    private Date getDateFormat(String formatPattern, String date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(formatPattern);
            return formatter.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Carro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
