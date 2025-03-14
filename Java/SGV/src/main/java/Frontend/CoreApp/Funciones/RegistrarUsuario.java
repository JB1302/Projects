package Frontend.CoreApp.Funciones;

import javax.swing.*;
import java.awt.*;

public class RegistrarUsuario extends JPanel {

    private JPanel MainPanel;

    public RegistrarUsuario(){
        MainPanel = new JPanel();

        MainPanel.setLayout(new GridLayout(1,2));
        MainPanel.add(Box.createVerticalGlue());

        //Panel Principal Izquierdo
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridBagLayout());
        panelIzquierdo.setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();

        //Margenes internos
        gbc.insets = new Insets(10, 10, 10, 10);
        //Columna X
        gbc.gridx = 0;
        //Fila Y
        gbc.gridy = 0;

        //Alineacion del Componente
        gbc.anchor = GridBagConstraints.CENTER;
        //Establecer donde se estirara
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //Subtitulo
        JLabel subtituloIzquierdo = new JLabel("Registrar/Actualizar");
        subtituloIzquierdo.setFont(new Font("ARIAL", Font.BOLD, 28));
        subtituloIzquierdo.setForeground(Color.decode("#0C6170"));
        subtituloIzquierdo.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridwidth = 2;
        panelIzquierdo.add(subtituloIzquierdo, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        //Campos de Texto
        JPanel fieldsIzquierdos = new JPanel();
        fieldsIzquierdos.setLayout(new GridBagLayout());
        fieldsIzquierdos.setBackground(Color.white);

        //Constructor de Grid
        GridBagConstraints fieldsGbc = new GridBagConstraints();
        //Definir gaps
        fieldsGbc.insets = new Insets(3, 5, 3, 5);
        fieldsGbc.gridx = 0;
        fieldsGbc.gridy = 0;
        fieldsGbc.anchor = GridBagConstraints.CENTER;
        fieldsGbc.fill = GridBagConstraints.HORIZONTAL;

        // Usuario
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

        // Correo
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

        // Contraseña
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


        //Grid Botones
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
        gridBotones.add(Box.createHorizontalGlue());
        gridBotones.add(Box.createHorizontalStrut(10));
        gridBotones.add(botonActualizar);

        panelIzquierdo.add(gridBotones, gbc);

        //---------------------------------------

        JPanel panelDerecho = new JPanel();
        panelDerecho.setBackground(Color.blue);

        JLabel subtituloDerecho = new JLabel("Operaciones");
        subtituloDerecho.setFont(new Font("ARIAL", Font.BOLD,28));
        subtituloDerecho.setForeground(Color.decode("#0C6170"));

        panelDerecho.add(subtituloDerecho);

        //---------------------------------
        MainPanel.add(panelIzquierdo);
        MainPanel.add(panelDerecho);

        MainPanel.add(Box.createVerticalGlue());

        this.add(MainPanel);

    }
}