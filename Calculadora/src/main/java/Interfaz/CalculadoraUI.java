package Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                Output.setText(Output.getText() + " " + 0);
            }
        });

        CalculadoraBTN1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Output.setText(Output.getText() + " " + 1);
            }
        });

        CalculadoraBTN2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Output.setText(Output.getText() + " " + 2);
            }
        });

        CalculadoraBTN3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Output.setText(Output.getText() + " " + 3);
            }
        });

        CalculadoraBTN4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Output.setText(Output.getText() + " " + 4);
            }
        });


        CalculadoraBTN5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Output.setText(Output.getText() + " " + 5);
            }
        });


        CalculadoraBTN6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Output.setText(Output.getText() + " " + 6);
            }
        });


        CalculadoraBTN7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Output.setText(Output.getText() + " " + 7);
            }
        });


        CalculadoraBTN8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Output.setText(Output.getText() + " " + 8);
            }
        });


        CalculadoraBTN9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Output.setText(Output.getText() + " " + 9);
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
