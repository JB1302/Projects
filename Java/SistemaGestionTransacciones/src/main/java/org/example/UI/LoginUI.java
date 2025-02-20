package org.example.UI;

import org.example.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class LoginUI extends JFrame {
    private JPanel LoginPage;

    //Login Header
    private JLabel LoginTextHeader;

    //Login User
    private JPanel LoginUserPanel;
    private JLabel LoginTag;
    private JTextField UserTxtField;

    //Login Pass
    private JPanel LoginPassPanel;
    private JLabel PassTxtTag;
    private JPasswordField PassTxtField;

    //Login Buttons
    private JPanel LoginPanel;
    private JButton iniciarButton;
    private JButton LimpiarBTN;

    public void limpiarDatos(){
        UserTxtField.setText("");
        PassTxtField.setText("");
    }

    public LoginUI(){

        setContentPane(LoginPage);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(210,195);
        setLocationRelativeTo(null);
        setVisible(true);

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = UserTxtField.getText();
                String password = new String(PassTxtField.getPassword());

                if(user.equals("Admin") && password.equals("123")){
                    JOptionPane.showMessageDialog(null,"Se ha ingresado exitosamente");
                    dispose();

                    Main.menuPrincipal();
                }else{
                    JOptionPane.showMessageDialog(null,"Credenciales Incorrectas");
                    limpiarDatos();
                }
            }
        });

        LimpiarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarDatos();
            }
        });



    }
}

