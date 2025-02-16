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


    //Variable para almacenar numeros, por ejemplo
    // 1 + 2 seria  12 no "1" y "2"
    private String numeroActual = "";
    private double primerOperador;
    private String operadorActual = null;

    //Metodo para agregar Numeros basado en los botones
    private void AddDigitToNumber(String numero) {
        //Manejar el numero total
        numeroActual += numero;
        //Actualizar la interfaz
        Output.setText(Output.getText() + numero);
    }

    //Metodo para reiniciar la operacion
    private void limpiarCalculadora() {
        //Actualizar variables a vacio
        numeroActual = "";
        primerOperador = 0;
        operadorActual = null;
        Output.setText("");
    }

    //Metodo para manejar operadores
    private void setOperador(String operador) {
        //Si el numero actual tiene un valor
        if (!numeroActual.isEmpty()) {
            //Y el operador no es nulo
            if (operadorActual != null) {
                // Convertir el numero actual en el segundo operador de tipo Double
                double segundoOperador = Double.parseDouble(numeroActual);

                //Swich dependiendo del operador
                switch (operadorActual) {
                    case "+":
                        //Sumar
                        primerOperador = primerOperador + segundoOperador;
                        break;
                    case "-":
                        //Restar
                        primerOperador = primerOperador - segundoOperador;
                        break;
                    case "*":
                        //Multiplicar
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

    //Calcular Opreación
    private void calcularResultado() {
        //Si el operador no es nulo y el numero actual no esta vacio
        if (operadorActual != null && !numeroActual.isEmpty()) {
            //Convertir el valor actual en un Double.
            double segundoOperador = Double.parseDouble(numeroActual);
            //Definir variable para el resultado
            double resultado = 0;

            //Manejar operadores
            switch (operadorActual) {
                case "+":
                    //Sumar
                    resultado = primerOperador + segundoOperador;
                    break;
                case "-":
                    //Restar
                    resultado = primerOperador - segundoOperador;
                    break;
                case "*":
                    //Multiplicar
                    resultado = primerOperador * segundoOperador;
                    break;
            }
            //Cambiar pantalla a el resultado
            numeroActual = String.valueOf(resultado);
            Output.setText(numeroActual);
            operadorActual = null;
        }
    }


    public CalculadoraUI() {

        //Configurar Calculadora
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
