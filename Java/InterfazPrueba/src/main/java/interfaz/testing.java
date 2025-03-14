package interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class testing extends JFrame {
    private JPanel LOGINPANE;
    private JTextField LoginUserFld;
    private JLabel LoginUserLbl;
    private JPasswordField LoginPasswordFld;
    private JLabel LoginPassLbl;
    private JButton LoginBtn;
    private JButton LoginLimpiarBtn;

    public testing(){

        setContentPane(LOGINPANE);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(225,235);
        setLocationRelativeTo(null);
        setVisible(true);

        //Llamar al Boton
        LoginBtn.addActionListener(new ActionListener() {
            @Override
            //Llamar a la accion
            public void actionPerformed(ActionEvent e) {

                String user = LoginUserFld.getText();
                String pass = LoginPasswordFld.getText();

                if(user.equals("123") && pass.equals("123")){
                    JOptionPane.showMessageDialog(null, "Ingreso correctamente");
                    limpiarDatos();
                }else{
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta, favor revise el usuario o la contraseña ingresada");
                    limpiarDatos();
                }

            }
        });



        LoginLimpiarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarDatos();

            }
        });

        }

    public void limpiarDatos(){
        LoginUserFld.setText("");
        LoginPasswordFld.setText("");
    }

}
