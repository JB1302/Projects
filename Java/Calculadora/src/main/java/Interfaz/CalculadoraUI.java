package Interfaz;

import javax.swing.*;

public class CalculadoraUI extends JFrame {
    private JButton CalculadoraBTN7;
    private JButton CalculadoraBTN4;
    private JButton CalculadoraBTN1;
    private JButton CalculadoraBTN8;
    private JButton CalculadoraBTN2;
    private JButton CalculadoraBTN5;
    private JButton CalculadoraBTN3;
    private JButton CalculadoraBTN6;
    private JButton CalculadoraBTN9;
    private JTextField Output;
    private JButton CalculadoraBTN0;
    private JButton CalculadoraTotalBtn;
    private JButton CalculadoraBorrarBtn;
    private JButton CalculadoraSuma;
    private JButton CalculadoraResta;
    private JButton CalculadoraMultiplica;
    private JPanel Calculadora;


    private String numeroActual = "";
    private double primerOperador;
    private String operadorActual = null;


    private void AddDigitToNumber(String numero) {
        numeroActual += numero;
        Output.setText(Output.getText() + numero);
    }

    private void limpiarCalculadora() {
        numeroActual = "";
        primerOperador = 0;
        operadorActual = null;
        Output.setText(""); // Clear the output when clearing calculator
    }


    private void setOperador(String operador) {
        if (!numeroActual.isEmpty()) {
            if (operadorActual != null) {
                // Si ya hay un operador, calcula el resultado parcial
                double segundoOperador = Double.parseDouble(numeroActual);
                switch (operadorActual) {
                    case "+":
                        primerOperador = primerOperador + segundoOperador;
                        break;
                    case "-":
                        primerOperador = primerOperador - segundoOperador;
                        break;
                    case "*":
                        primerOperador = primerOperador * segundoOperador;
                        break;
                }
            } else {
                // Si es la primera operación
                primerOperador = Double.parseDouble(numeroActual);
            }
            operadorActual = operador;
            numeroActual = ""; // Reinicia el número actual para la próxima entrada
            Output.setText(Output.getText() + operador);
        }
    }


    private void calcularResultado() {
        if (operadorActual != null && !numeroActual.isEmpty()) {
            double segundoOperador = Double.parseDouble(numeroActual);
            double resultado = 0;

            switch (operadorActual) {
                case "+":
                    resultado = primerOperador + segundoOperador;
                    break;
                case "-":
                    resultado = primerOperador - segundoOperador;
                    break;
                case "*":
                    resultado = primerOperador * segundoOperador;
                    break;
            }
            numeroActual = String.valueOf(resultado);
            Output.setText(numeroActual);  // Update output with result
            operadorActual = null;  // Reset operator for next calculation
        }
    }



    public CalculadoraUI() {


        setContentPane(Calculadora);
        setTitle("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(295, 258);
        setLocationRelativeTo(null);
        setVisible(true);

        //Configurar botones numericos
        CalculadoraBTN0.addActionListener(e -> AddDigitToNumber("0"));
        CalculadoraBTN1.addActionListener(e -> AddDigitToNumber("1"));
        CalculadoraBTN2.addActionListener(e -> AddDigitToNumber("2"));
        CalculadoraBTN3.addActionListener(e -> AddDigitToNumber("3"));
        CalculadoraBTN4.addActionListener(e -> AddDigitToNumber("4"));
        CalculadoraBTN5.addActionListener(e -> AddDigitToNumber("5"));
        CalculadoraBTN6.addActionListener(e -> AddDigitToNumber("6"));
        CalculadoraBTN7.addActionListener(e -> AddDigitToNumber("7"));
        CalculadoraBTN8.addActionListener(e -> AddDigitToNumber("8"));
        CalculadoraBTN9.addActionListener(e -> AddDigitToNumber("9"));

        //Configurar Operadores
        CalculadoraSuma.addActionListener(e -> setOperador("+"));
        CalculadoraResta.addActionListener(e -> setOperador("-"));
        CalculadoraMultiplica.addActionListener(e -> setOperador("*"));

        //Resultado
        CalculadoraTotalBtn.addActionListener(e -> calcularResultado());

        //Borrar
        CalculadoraBorrarBtn.addActionListener(e -> limpiarCalculadora());


    }
}
