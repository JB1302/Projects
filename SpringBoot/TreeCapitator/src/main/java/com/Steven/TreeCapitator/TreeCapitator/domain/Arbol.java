/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Steven.TreeCapitator.TreeCapitator.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data //Getters and Setters
@Entity //Definir como Entidad
@Table(name = "arbol") //Definir la tabla a usar
public class Arbol implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    //Atributos de la tabla
    
    //Llave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Identidad definida por el valor
    private long id_especie;
    
    private int edad;
    private String nombre_comun1;
    private String nombre_comun2;
    private String nombre_cientifico1;
    private String nombre_cientifico2;
    private String ruta_imagen;
    
}
