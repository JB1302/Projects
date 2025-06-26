package com.caso1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data //Getters y Setters
@Entity //Definir como una Entidad
@Table(name = "producto") //Definir el nombre de la tabla
public class Producto implements Serializable {
    
    //Si la tabla esta vacia e insertamos un registro categoria
    //El primer valor sera uno para el ID
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_producto;

    private String detalle;
    private String fecha_vence;
    private int cantidad;

    private String imagen_producto;

}
