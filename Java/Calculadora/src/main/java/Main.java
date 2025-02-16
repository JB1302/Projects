import Interfaz.CalculadoraUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //Cargar interfaz de calculadora
        SwingUtilities.invokeLater(() -> new CalculadoraUI());

        System.out.println("Iniciando Calculadora...");

    }
}
