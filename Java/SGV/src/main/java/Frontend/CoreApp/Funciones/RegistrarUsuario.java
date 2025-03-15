package Frontend.CoreApp.Funciones;

import Backend.controlador.UsuarioController;
import Backend.modelo.Usuario.Cliente;
import Backend.servicio.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarUsuario extends JPanel {

    private JPanel MainPanel;

    // Constructor de la clase
    public RegistrarUsuario() {
        // Configuración del layout principal del panel
        this.setLayout(new BorderLayout());
        MainPanel = new JPanel();
        MainPanel.setLayout(new GridLayout(1, 2));
        MainPanel.setBackground(Color.white);

        // Definición y configuración del panel izquierdo
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridBagLayout());
        panelIzquierdo.setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Márgenes internos
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Subtítulo del panel izquierdo
        JLabel subtituloIzquierdo = new JLabel("Registrar/Actualizar");
        subtituloIzquierdo.setFont(new Font("ARIAL", Font.BOLD, 28));
        subtituloIzquierdo.setForeground(Color.decode("#0C6170"));
        subtituloIzquierdo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridwidth = 2;
        panelIzquierdo.add(subtituloIzquierdo, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        // Campos de texto del panel izquierdo
        JPanel fieldsIzquierdos = new JPanel();
        fieldsIzquierdos.setLayout(new GridBagLayout());
        fieldsIzquierdos.setBackground(Color.white);

        GridBagConstraints fieldsGbc = new GridBagConstraints();
        fieldsGbc.insets = new Insets(3, 5, 3, 5);
        fieldsGbc.gridx = 0;
        fieldsGbc.gridy = 0;
        fieldsGbc.anchor = GridBagConstraints.CENTER;
        fieldsGbc.fill = GridBagConstraints.HORIZONTAL;

        // Campo de texto para "Usuario"
        JLabel usuarioNombre = new JLabel("Usuario");
        usuarioNombre.setForeground(Color.decode("#37BEB0"));
        usuarioNombre.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(usuarioNombre, fieldsGbc);

        fieldsGbc.gridy++;
        JTextField usuarioTxt = new JTextField();
        usuarioTxt.setPreferredSize(new Dimension(310, 26));
        usuarioTxt.setMaximumSize(new Dimension(380, 26));
        usuarioTxt.setBackground(Color.decode("#DBF5F0"));
        usuarioTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(usuarioTxt, fieldsGbc);

        // Campo de texto para "Email"
        fieldsGbc.gridy++;
        JLabel usuarioCorreo = new JLabel("Email");
        usuarioCorreo.setForeground(Color.decode("#37BEB0"));
        usuarioCorreo.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(usuarioCorreo, fieldsGbc);

        fieldsGbc.gridy++;
        JTextField correoTxt = new JTextField();
        correoTxt.setPreferredSize(new Dimension(310, 26));
        correoTxt.setMaximumSize(new Dimension(380, 26));
        correoTxt.setBackground(Color.decode("#DBF5F0"));
        correoTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(correoTxt, fieldsGbc);

        // Campo de texto para "Contraseña"
        fieldsGbc.gridy++;
        JLabel usuarioPass = new JLabel("Contraseña");
        usuarioPass.setForeground(Color.decode("#37BEB0"));
        usuarioPass.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(usuarioPass, fieldsGbc);

        fieldsGbc.gridy++;
        JTextField passTxt = new JTextField();
        passTxt.setPreferredSize(new Dimension(310, 26));
        passTxt.setMaximumSize(new Dimension(380, 26));
        passTxt.setBackground(Color.decode("#DBF5F0"));
        passTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(passTxt, fieldsGbc);

        gbc.gridy++;
        panelIzquierdo.add(fieldsIzquierdos, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;

        // Definición y configuración de los botones del panel izquierdo
        JPanel gridBotones = new JPanel();
        gridBotones.setLayout(new GridBagLayout());
        gridBotones.setPreferredSize(new Dimension(194, 25));
        gridBotones.setMaximumSize(new Dimension(194, 25));
        gridBotones.setBackground(Color.white);

        JButton botonRegistrar = new JButton("Registrar Nuevo");
        botonRegistrar.setPreferredSize(new Dimension(100, 25));
        botonRegistrar.setMaximumSize(new Dimension(100, 25));
        botonRegistrar.setBackground(Color.decode("#37BEB0"));
        botonRegistrar.setForeground(Color.white);
        botonRegistrar.setBorder(BorderFactory.createLineBorder(Color.black));

        JButton botonActualizar = new JButton("Update");
        botonActualizar.setPreferredSize(new Dimension(84, 25));
        botonActualizar.setMaximumSize(new Dimension(84, 25));
        botonActualizar.setBackground(Color.decode("#37BEB0"));
        botonActualizar.setForeground(Color.white);
        botonActualizar.setBorder(BorderFactory.createLineBorder(Color.black));

        gridBotones.add(botonRegistrar);
        gridBotones.add(Box.createHorizontalStrut(10));
        gridBotones.add(botonActualizar);

        panelIzquierdo.add(gridBotones, gbc);

        // Definición y configuración del panel derecho
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new GridBagLayout());
        panelDerecho.setBackground(Color.white);

        GridBagConstraints gbcD = new GridBagConstraints();
        gbcD.insets = new Insets(10,10,10,10);
        gbcD.gridx = 0;
        gbcD.gridy = 0;
        gbcD.anchor = GridBagConstraints.CENTER;
        gbcD.fill = GridBagConstraints.HORIZONTAL;

        JLabel subtituloDerecho = new JLabel("Operaciones");
        subtituloDerecho.setFont(new Font("ARIAL", Font.BOLD,28));
        subtituloDerecho.setForeground(Color.decode("#0C6170"));
        subtituloDerecho.setHorizontalAlignment(SwingConstants.CENTER);
        gbcD.gridwidth = 2;
        panelDerecho.add(subtituloDerecho, gbcD);

        JPanel fieldsDerechos = new JPanel();
        fieldsDerechos.setLayout(new GridBagLayout());
        fieldsDerechos.setBackground(Color.white);

        GridBagConstraints fieldsgbcD = new GridBagConstraints();
        fieldsgbcD.insets = new Insets(3,5,3,5);
        fieldsgbcD.anchor = GridBagConstraints.CENTER;
        fieldsgbcD.fill = GridBagConstraints.HORIZONTAL;

        fieldsgbcD.gridx = 0;
        fieldsgbcD.gridy = 0;
        fieldsgbcD.gridwidth = 2;
        JLabel emailOperaciones = new JLabel("Email");
        emailOperaciones.setForeground(Color.decode("#37BEB0"));
        emailOperaciones.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsDerechos.add(emailOperaciones, fieldsgbcD);

        fieldsgbcD.gridy++;
        JTextField emailTXT = new JTextField();
        emailTXT.setPreferredSize(new Dimension(200, 26));
        emailTXT.setBackground(Color.decode("#DBF5F0"));
        emailTXT.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsDerechos.add(emailTXT, fieldsgbcD);

        // Botones del panel derecho
        fieldsgbcD.gridy++;
        fieldsgbcD.gridwidth = 1;
        JButton buscarUsuario = new JButton("Buscar Usuario");
        buscarUsuario.setPreferredSize(new Dimension(150, 25));
        buscarUsuario.setMaximumSize(new Dimension(150, 25));
        buscarUsuario.setBackground(Color.decode("#37BEB0"));
        buscarUsuario.setForeground(Color.white);
        buscarUsuario.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsDerechos.add(buscarUsuario, fieldsgbcD);

        fieldsgbcD.gridx = 1;
        JButton eliminarUsuario = new JButton("Eliminar Usuario");
        eliminarUsuario.setPreferredSize(new Dimension(150, 25));
        eliminarUsuario.setMaximumSize(new Dimension(150, 25));
        eliminarUsuario.setBackground(Color.decode("#37BEB0"));
        eliminarUsuario.setForeground(Color.white);
        eliminarUsuario.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsDerechos.add(eliminarUsuario, fieldsgbcD);

        fieldsgbcD.gridx = 0;
        fieldsgbcD.gridy++;
        fieldsgbcD.gridwidth = 2;
        JButton mostrarCliente = new JButton("Mostrar Usuarios");
        mostrarCliente.setPreferredSize(new Dimension(310, 25));
        mostrarCliente.setBackground(Color.decode("#37BEB0"));
        mostrarCliente.setForeground(Color.white);
        mostrarCliente.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsDerechos.add(mostrarCliente, fieldsgbcD);



        // Área de texto para mostrar resultados
        fieldsgbcD.gridy++;
        fieldsgbcD.weightx = 1.0;
        fieldsgbcD.weighty = 1.0;
        fieldsgbcD.fill = GridBagConstraints.BOTH;

        JTextArea outputField = new JTextArea(5, 30);
        outputField.setBorder(BorderFactory.createLineBorder(Color.black));
        outputField.setBackground(Color.decode("#DBF5F0"));

        JScrollPane scrollPane = new JScrollPane(outputField);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        fieldsDerechos.add(scrollPane, fieldsgbcD);

        gbcD.gridy++;
        gbcD.gridwidth = 2;
        gbcD.weightx = 1.0;
        gbcD.weighty = 1.0;
        gbcD.fill = GridBagConstraints.BOTH;

        panelDerecho.add(fieldsDerechos, gbcD);

        // Añadir los paneles principales al MainPanel
        MainPanel.add(panelIzquierdo);
        MainPanel.add(panelDerecho);

        // Añadir el MainPanel al panel principal
        this.add(MainPanel, BorderLayout.CENTER);

        // Acción del botón "Registrar Nuevo"
        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioTxt.getText();
                String email = correoTxt.getText();
                String pass = passTxt.getText();

                Cliente cliente = new Cliente(usuario, email, pass);
                UsuarioController usuarioController = new UsuarioController(cliente);
                usuarioController.insertarObjeto();
                outputField.setText("...");
                outputField.setText("Usuario Creado");
            }
        });

        // Acción del botón "Update"
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioTxt.getText();
                String email = correoTxt.getText();
                String pass = passTxt.getText();

                Cliente cliente = new Cliente(usuario, email, pass);
                UsuarioService usuarioService = new UsuarioService();
                usuarioService.actualizarCliente(cliente);
                outputField.setText("...");
                outputField.setText("Usuario Actualizado");
            }
        });

        // Acción del botón "Buscar Usuario"
        buscarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailTXT.getText();

                UsuarioService usuarioService = new UsuarioService();
                outputField.setText(usuarioService.buscarCliente(email));
            }
        });

        // Acción del botón "Eliminar Usuario"
        eliminarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailTXT.getText();

                UsuarioService usuarioService = new UsuarioService();
                usuarioService.eliminarCliente(email);

                outputField.setText("...");
                outputField.setText("Usuario Actualizado");
            }
        });

        // Acción del botón "Mostrar Usuarios"
        mostrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioService usuarioService = new UsuarioService();
                usuarioService.mostrarClientes();

                outputField.setText(usuarioService.mostrarClientes());
            }
        });
    }
}