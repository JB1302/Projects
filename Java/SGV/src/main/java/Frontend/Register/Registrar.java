package Frontend.Register;


import Backend.controlador.UsuarioController;
import Backend.modelo.Usuario.Cliente;
import Frontend.login.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registrar extends JFrame {
    private JTextField RegistrarUserTxtField;
    private JButton inicioButton;
    private JButton REGISTRARButton;
    private JLabel RegistrarTxtField;
    private JLabel RegistrarUserTxt;
    private JLabel RegistrarPassTxt;
    private JPasswordField RegistrarUserPassField;
    private JPanel MainPanel;

    private JLabel RegistrarEmailTxt;
    private JTextField RegistrarEmailTxtField;

    public Registrar() {
        setTitle("Iniciar Sesión");
        setSize(320, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel principal con BoxLayout vertical
        MainPanel = new JPanel();
        MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));
        MainPanel.setBackground(Color.decode("#ffffff"));
        MainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título centrado
        RegistrarTxtField = new JLabel("REGISTRARSE", JLabel.CENTER);
        RegistrarTxtField.setFont(new Font("Arial", Font.BOLD, 20));
        RegistrarTxtField.setAlignmentX(Component.CENTER_ALIGNMENT);
        RegistrarTxtField.setForeground(Color.decode("#37beb0"));
        MainPanel.add(RegistrarTxtField);

        // Espacio entre el título y los campos
        MainPanel.add(Box.createVerticalStrut(20));

        // Panel para el campo de Usuario
        RegistrarUserTxt = new JLabel("Nombre:");
        RegistrarUserTxt.setForeground(Color.decode("#37beb0"));
        RegistrarUserTxtField = new JTextField(20);
        RegistrarUserTxtField.setBackground(Color.decode("#dbf5f0"));
        RegistrarUserTxtField.setPreferredSize(new Dimension(150, 30));

        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));  // Centrado
        userPanel.setBackground(Color.decode("#ffffff"));
        userPanel.add(RegistrarUserTxt);
        userPanel.add(Box.createVerticalStrut(5)); // Espacio entre título y campo de texto
        userPanel.add(RegistrarUserTxtField);
        MainPanel.add(userPanel);

        // Panel para el campo de Usuario
        RegistrarEmailTxt = new JLabel("Correo:");
        RegistrarEmailTxt.setForeground(Color.decode("#37beb0"));
        RegistrarEmailTxtField = new JTextField(20);
        RegistrarEmailTxtField.setBackground(Color.decode("#dbf5f0"));
        RegistrarEmailTxtField.setPreferredSize(new Dimension(150, 30));

        JPanel EmailPanel = new JPanel();
        EmailPanel.setLayout(new BoxLayout(EmailPanel, BoxLayout.Y_AXIS));  // Centrado
        EmailPanel.setBackground(Color.decode("#ffffff"));
        EmailPanel.add(RegistrarEmailTxt);
        EmailPanel.add(Box.createVerticalStrut(5)); // Espacio entre título y campo de texto
        EmailPanel.add(RegistrarEmailTxtField);
        MainPanel.add(EmailPanel);

        // Panel para el campo de Contraseña
        RegistrarPassTxt = new JLabel("Contraseña:");
        RegistrarPassTxt.setForeground(Color.decode("#37beb0"));
        RegistrarUserPassField = new JPasswordField(20);
        RegistrarUserPassField.setBackground(Color.decode("#dbf5f0"));
        RegistrarUserPassField.setPreferredSize(new Dimension(150, 30));

        JPanel passPanel = new JPanel();
        passPanel.setLayout(new BoxLayout(passPanel, BoxLayout.Y_AXIS));  // Centrado
        passPanel.setBackground(Color.decode("#ffffff"));
        passPanel.add(RegistrarPassTxt);
        EmailPanel.add(Box.createVerticalStrut(5)); // Espacio entre título y campo de texto
        passPanel.add(RegistrarUserPassField);
        MainPanel.add(passPanel);

        // Espacio entre los campos y los botones
        MainPanel.add(Box.createVerticalStrut(20));

        // Botones
        inicioButton = new JButton("Regresar");
        inicioButton.setBackground(Color.decode("#37beb0"));
        inicioButton.setForeground(Color.decode("#FFFFFF"));
        inicioButton.setPreferredSize(new Dimension(100, 35));

        REGISTRARButton = new JButton("Registrar");
        REGISTRARButton.setBackground(Color.decode("#37beb0"));
        REGISTRARButton.setForeground(Color.decode("#FFFFFF"));
        REGISTRARButton.setPreferredSize(new Dimension(100, 35));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // Centrado
        buttonPanel.setBackground(Color.decode("#ffffff"));
        buttonPanel.add(inicioButton);
        buttonPanel.add(REGISTRARButton);
        MainPanel.add(buttonPanel);

        // Agregar el panel principal al frame
        add(MainPanel, BorderLayout.CENTER);

        REGISTRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String nombre = RegistrarUserTxtField.getText() ;
                String correo = RegistrarEmailTxtField.getText();
                String password = new String(RegistrarUserPassField.getPassword());

                Cliente cliente = new Cliente(nombre,correo,password);
                UsuarioController usuarioController = new UsuarioController(cliente);
                usuarioController.insertarObjeto();

                Login loginVista = new Login();

                loginVista.setVisible(true);

                dispose();
            }
        });

        inicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login loginVista = new Login();

                loginVista.setVisible(true);

                dispose();
            }
        });
    }

        public static void main(String[] args) {
            // Crear e iniciar la interfaz de Registrar
            SwingUtilities.invokeLater(() -> new Registrar().setVisible(true));
        }
}
