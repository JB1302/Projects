package Frontend.login;

import Backend.modelo.Usuario.Administrador;
import Backend.modelo.Usuario.Cliente;
import Backend.modelo.Usuario.Mecanico;
import Frontend.CoreApp.VentanaPrincipal;
import Frontend.Register.Registrar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField LoginUserTxtField;
    private JButton LOGINButton;
    private JButton REGISTRARButton;
    private JLabel LoginTxtField;
    private JLabel LoginUserTxt;
    private JLabel LoginPassTxt;
    private JPasswordField LoginUserPassField;
    private JPanel MainPanel;

    public Login() {
        setTitle("Iniciar Sesión");
        setSize(320, 275);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel principal con BoxLayout vertical
        MainPanel = new JPanel();
        MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));
        MainPanel.setBackground(Color.decode("#ffffff"));
        MainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título centrado
        LoginTxtField = new JLabel("INICIAR SESIÓN", JLabel.CENTER);
        LoginTxtField.setFont(new Font("Arial", Font.BOLD, 20));
        LoginTxtField.setForeground(Color.decode("#37beb0"));
        LoginTxtField.setAlignmentX(Component.CENTER_ALIGNMENT);
        MainPanel.add(LoginTxtField);

        // Espacio entre el título y los campos
        MainPanel.add(Box.createVerticalStrut(20));

        // Panel para el campo de Usuario
        LoginUserTxt = new JLabel("Correo:");
        LoginUserTxt.setForeground(Color.decode("#37beb0"));
        LoginUserTxtField = new JTextField(20);
        LoginUserTxtField.setBackground(Color.decode("#dbf5f0"));
        LoginUserTxtField.setPreferredSize(new Dimension(150, 30));

        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));  // Centrado
        userPanel.setBackground(Color.decode("#ffffff"));
        userPanel.add(LoginUserTxt);
        userPanel.add(Box.createVerticalStrut(5)); // Espacio entre título y campo de texto
        userPanel.add(LoginUserTxtField);
        MainPanel.add(userPanel);

        // Panel para el campo de Contraseña
        LoginPassTxt = new JLabel("Contraseña:");
        LoginPassTxt.setForeground(Color.decode("#37beb0"));
        LoginUserPassField = new JPasswordField(20);
        LoginUserPassField.setBackground(Color.decode("#dbf5f0"));
        LoginUserPassField.setPreferredSize(new Dimension(150, 30));

        JPanel passPanel = new JPanel();
        passPanel.setLayout(new BoxLayout(passPanel, BoxLayout.Y_AXIS));  // Centrado
        passPanel.setBackground(Color.decode("#ffffff"));
        passPanel.add(LoginPassTxt);
        userPanel.add(Box.createVerticalStrut(5)); // Espacio entre título y campo de texto
        passPanel.add(LoginUserPassField);
        MainPanel.add(passPanel);

        // Espacio entre los campos y los botones
        MainPanel.add(Box.createVerticalStrut(20));

        // Botones
        LOGINButton = new JButton("Login");
        LOGINButton.setBackground(Color.decode("#37beb0"));
        LOGINButton.setForeground(Color.decode("#FFFFFF"));
        LOGINButton.setPreferredSize(new Dimension(100, 35));

        REGISTRARButton = new JButton("Registrar");
        REGISTRARButton.setBackground(Color.decode("#37beb0"));
        REGISTRARButton.setForeground(Color.decode("#FFFFFF"));
        REGISTRARButton.setPreferredSize(new Dimension(100, 35));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // Centrado
        buttonPanel.setBackground(Color.decode("#ffffff"));
        buttonPanel.add(LOGINButton);
        buttonPanel.add(REGISTRARButton);
        MainPanel.add(buttonPanel);

        // Agregar el panel principal al frame
        add(MainPanel, BorderLayout.CENTER);



        // Acción del botón Login usando un hilo para simular un proceso en segundo plano
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Se crea un nuevo hilo para el proceso de login
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // Obtener las credenciales ingresadas
                        String nombre = LoginUserTxtField.getText();
                        String pass = new String(LoginUserPassField.getPassword());

                        JOptionPane.showMessageDialog(null,"Verificando Credenciales...");

                        // Simulación de demora en la verificación (por ejemplo, 2 segundos)
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                        // Creación de instancias para cada tipo de usuario
                        Cliente cliente = new Cliente();
                        Administrador administrador = new Administrador();
                        Mecanico mecanico = new Mecanico();

                        // Verificar autenticación en función del rol
                        if (cliente.iniciarSesion(nombre, pass)) {
                            System.out.println("Inicio de sesión como Cliente exitoso");
                            SwingUtilities.invokeLater(() -> {
                                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                                ventanaPrincipal.setVisible(true);
                            });
                            dispose();
                        } else if (administrador.iniciarSesion(nombre, pass)) {
                            System.out.println("Inicio de sesión como Administrador exitoso");
                            SwingUtilities.invokeLater(() -> {
                                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                                ventanaPrincipal.setVisible(true);
                            });
                            dispose();
                        } else if (mecanico.iniciarSesion(nombre, pass)) {
                            System.out.println("Inicio de sesión como Mecánico exitoso");
                            SwingUtilities.invokeLater(() -> {
                                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                                ventanaPrincipal.setVisible(true);
                            });
                            dispose();
                        } else {
                           JOptionPane.showMessageDialog(null,"Credenciales incorrectas");
                        }
                    }
                }).start();
            }
        });

        REGISTRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registrar registroVista = new Registrar();
                registroVista.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        // Crear e iniciar la interfaz de login
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
