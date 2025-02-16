package Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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


    private int contador = 0;
    private HashMap<Integer, Integer> calculo = new HashMap<>();

    public CalculadoraUI(){




        setContentPane(Calculadora);
        setTitle("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(295,258);
        setLocationRelativeTo(null);
        setVisible(true);

        CalculadoraBTN0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculo.put(contador, 0);
                contador++;
            }
        });

        CalculadoraBTN1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculo.put(contador, 1);
                contador++;
            }
        });
        CalculadoraBTN2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculo.put(contador, 2);
                contador++;
            }
        });

        CalculadoraBTN3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculo.put(contador, 3);
                contador++;
            }
        });
        CalculadoraBTN4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculo.put(contador, 4);
                contador++;
            }
        });


        CalculadoraBTN5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculo.put(contador, 5);
                contador++;
            }
        });



        CalculadoraBTN6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculo.put(contador, 6);
                contador++;
            }
        });

        CalculadoraBTN7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculo.put(contador, 7);
                contador++;
            }
        });

        CalculadoraBTN8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculo.put(contador, 8);
                contador++;
            }
        });


        CalculadoraBTN9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculo.put(contador, 9);
                contador++;
            }
        });
        CalculadoraSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Output.setText(Output.getText() + " " + "+");
            }
        });

        CalculadoraResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Output.setText(Output.getText() + " " + "-");
            }
        });

        CalculadoraMultiplica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Output.setText(Output.getText() + " " + "*");
            }
        });






    }
}
