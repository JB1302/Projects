/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanager;

/**
 *
 * @author jstev
 */
public class Empleado {
    
    //Definir Variables Privadas para que no se alteren fuera de aqui
    private String nombre;
    private int edad;
    private String departamento;
    private double salario;
    
    //Definir Setters
    public String getNombre(){
        return this.nombre;
    }
    
    public int getEdad(){
        return this.edad;
    }
    
    public String getDepartamento(){
        return this.departamento;
    }
    
    public double getSalario(){
        return this.salario;
    }
    
    //Constructor
    public Empleado(String nombre, int edad, String departamento, double salario) {
    this.nombre = nombre;
    this.edad = edad;
    this.departamento = departamento;
    this.salario = salario;
}
    
    //Definir como se mostrara el texto:
    public String toString(){
        return "El empleado " + this.nombre + " Edad: " + this.edad + " del departamento " + this.departamento + " tiene un salario de " + this.salario;
    }
    
}
