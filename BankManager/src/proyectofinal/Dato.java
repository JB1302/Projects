/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author jstev
 */
public class Dato {

    private int valor;

    public Dato(int valor) {

        this.valor = valor;

    }

    public int getValor() {

        return valor;

    }

    public void setValor(int valor) {

        this.valor = valor;

    }

    @Override

    public String toString() {

        return "Dato{" + "valor=" + valor + '}';

    }

}
