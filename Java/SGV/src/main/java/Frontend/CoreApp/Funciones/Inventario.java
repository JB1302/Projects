package Frontend.CoreApp.Funciones;

import javax.swing.*;
import java.awt.*;

public class Inventario extends JPanel {
    JPanel MainPanel;

    public Inventario(){
        MainPanel = new JPanel();
        MainPanel.setLayout(new GridLayout(1, 2));
        MainPanel.setBackground(Color.white);

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridBagLayout());
        panelIzquierdo.setBackground(Color.white);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes internos reducidos
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel subtituloIzquierdo = new JLabel("Crear Cita");
        subtituloIzquierdo.setFont(new Font("ARIAL", Font.BOLD, 28));
        subtituloIzquierdo.setForeground(Color.decode("#0C6170"));
        subtituloIzquierdo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridwidth = 4;
        panelIzquierdo.add(subtituloIzquierdo, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        JPanel fieldsIzquierdos = new JPanel();
        fieldsIzquierdos.setLayout(new GridBagLayout());
        fieldsIzquierdos.setBackground(Color.white);
        GridBagConstraints fieldsGbc2 = new GridBagConstraints();
        fieldsGbc2.insets = new Insets(3, 3, 3, 3); // Márgenes internos reducidos
        fieldsGbc2.anchor = GridBagConstraints.WEST;

        // Conjunto 2
        fieldsGbc2.gridx = 0;
        fieldsGbc2.gridy = 0;
        JLabel clienteLabel = new JLabel("Cliente");
        clienteLabel.setForeground(Color.decode("#37BEB0"));
        clienteLabel.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(clienteLabel, fieldsGbc2);

        fieldsGbc2.gridy = 1;
        JTextField clienteTXT = new JTextField();
        clienteTXT.setPreferredSize(new Dimension(150, 26));
        clienteTXT.setMaximumSize(new Dimension(150, 26));
        clienteTXT.setBackground(Color.decode("#DBF5F0"));
        clienteTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(clienteTXT, fieldsGbc2);

        fieldsGbc2.gridx = 1;
        fieldsGbc2.gridy = 0;
        JLabel placaLBL = new JLabel("Placa");
        placaLBL.setForeground(Color.decode("#37BEB0"));
        placaLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(placaLBL, fieldsGbc2);

        fieldsGbc2.gridy = 1;
        JTextField placaTXT = new JTextField();
        placaTXT.setPreferredSize(new Dimension(150, 26));
        placaTXT.setMaximumSize(new Dimension(150, 26));
        placaTXT.setBackground(Color.decode("#DBF5F0"));
        placaTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(placaTXT, fieldsGbc2);

        fieldsGbc2.gridx = 0;
        fieldsGbc2.gridy = 2;
        JLabel fechaLBL = new JLabel("Fecha");
        fechaLBL.setForeground(Color.decode("#37BEB0"));
        fechaLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(fechaLBL, fieldsGbc2);

        fieldsGbc2.gridy = 3;
        JTextField fechaTXT = new JTextField();
        fechaTXT.setPreferredSize(new Dimension(150, 26));
        fechaTXT.setMaximumSize(new Dimension(150, 26));
        fechaTXT.setBackground(Color.decode("#DBF5F0"));
        fechaTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(fechaTXT, fieldsGbc2);

        fieldsGbc2.gridx = 1;
        fieldsGbc2.gridy = 2;
        JLabel horaLBL = new JLabel("Hora");
        horaLBL.setForeground(Color.decode("#37BEB0"));
        horaLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(horaLBL, fieldsGbc2);

        fieldsGbc2.gridy = 3;
        JTextField horaTXT = new JTextField();
        horaTXT.setPreferredSize(new Dimension(150, 26));
        horaTXT.setMaximumSize(new Dimension(150, 26));
        horaTXT.setBackground(Color.decode("#DBF5F0"));
        horaTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(horaTXT, fieldsGbc2);

        fieldsGbc2.gridx = 0;
        fieldsGbc2.gridy = 4;
        fieldsGbc2.gridwidth = 2; // Para que el botón ocupe el ancho de los dos campos anteriores
        JButton crearReparacion = new JButton("Crear Cita");
        crearReparacion.setPreferredSize(new Dimension(310, 25));
        crearReparacion.setMaximumSize(new Dimension(310, 25));
        crearReparacion.setBackground(Color.decode("#37BEB0"));
        crearReparacion.setForeground(Color.white);
        crearReparacion.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsIzquierdos.add(crearReparacion, fieldsGbc2);

        panelIzquierdo.add(fieldsIzquierdos, gbc);

        gbc.gridy++;
        gbc.gridwidth = 4;

        JLabel subtituloIzquierdo2 = new JLabel("Revisar Inventario");
        subtituloIzquierdo2.setFont(new Font("ARIAL", Font.BOLD, 28));
        subtituloIzquierdo2.setForeground(Color.decode("#0C6170"));
        subtituloIzquierdo2.setHorizontalAlignment(SwingConstants.CENTER);
        panelIzquierdo.add(subtituloIzquierdo2, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;

        JPanel fieldsInventario = new JPanel();
        fieldsInventario.setLayout(new GridBagLayout());
        fieldsInventario.setBackground(Color.white);
        GridBagConstraints fieldsGbc3 = new GridBagConstraints();
        fieldsGbc3.insets = new Insets(3, 3, 3, 3); // Márgenes internos reducidos
        fieldsGbc3.anchor = GridBagConstraints.WEST;

        fieldsGbc3.gridx = 0;
        fieldsGbc3.gridy = 0;
        JLabel nombreLBL = new JLabel("Nombre");
        nombreLBL.setForeground(Color.decode("#37BEB0"));
        nombreLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsInventario.add(nombreLBL, fieldsGbc3);

        fieldsGbc3.gridy = 1;
        JTextField nombreTXT = new JTextField();
        nombreTXT.setPreferredSize(new Dimension(150, 26));
        nombreTXT.setMaximumSize(new Dimension(150, 26));
        nombreTXT.setBackground(Color.decode("#DBF5F0"));
        nombreTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsInventario.add(nombreTXT, fieldsGbc3);

        fieldsGbc3.gridx = 1;
        fieldsGbc3.gridy = 0;
        JLabel necesitadoLBL = new JLabel("Necesitado");
        necesitadoLBL.setForeground(Color.decode("#37BEB0"));
        necesitadoLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsInventario.add(necesitadoLBL, fieldsGbc3);

        fieldsGbc3.gridy = 1;
        JTextField necesitadoTXT = new JTextField();
        necesitadoTXT.setPreferredSize(new Dimension(150, 26));
        necesitadoTXT.setMaximumSize(new Dimension(150, 26));
        necesitadoTXT.setBackground(Color.decode("#DBF5F0"));
        necesitadoTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsInventario.add(necesitadoTXT, fieldsGbc3);

        fieldsGbc3.gridx = 0;
        fieldsGbc3.gridy = 2;
        fieldsGbc3.gridwidth = 2; // Para que el botón ocupe el ancho de los dos campos anteriores
        JButton compararInventarioBTN = new JButton("Comparar Inventario");
        compararInventarioBTN.setPreferredSize(new Dimension(310, 25));
        compararInventarioBTN.setMaximumSize(new Dimension(310, 25));
        compararInventarioBTN.setBackground(Color.decode("#37BEB0"));
        compararInventarioBTN.setForeground(Color.white);
        compararInventarioBTN.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsInventario.add(compararInventarioBTN, fieldsGbc3);

        panelIzquierdo.add(fieldsInventario, gbc);

        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new GridBagLayout());
        panelDerecho.setBackground(Color.white);

        gbc.gridy = 0; // Reset gbc.gridy for the panelDerecho
        gbc.gridwidth = 4; // Make sure the subtitle spans across the panel

        JLabel subtituloDerecho = new JLabel("Añadir Stock");
        subtituloDerecho.setFont(new Font("ARIAL", Font.BOLD, 28));
        subtituloDerecho.setForeground(Color.decode("#0C6170"));
        subtituloDerecho.setHorizontalAlignment(SwingConstants.CENTER);
        panelDerecho.add(subtituloDerecho, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;

        JPanel fieldsInventarioDerecho = new JPanel();
        fieldsInventarioDerecho.setLayout(new GridBagLayout());
        fieldsInventarioDerecho.setBackground(Color.white);
        GridBagConstraints fieldsGbc4 = new GridBagConstraints();
        fieldsGbc4.insets = new Insets(3, 3, 3, 3); // Márgenes internos reducidos
        fieldsGbc4.anchor = GridBagConstraints.WEST;

        fieldsGbc4.gridx = 0;
        fieldsGbc4.gridy = 0;
        JLabel nombreLBLDerecho = new JLabel("Nombre");
        nombreLBLDerecho.setForeground(Color.decode("#37BEB0"));
        nombreLBLDerecho.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsInventarioDerecho.add(nombreLBLDerecho, fieldsGbc4);

        fieldsGbc4.gridy = 1;
        JTextField nombreTXTDerecho = new JTextField();
        nombreTXTDerecho.setPreferredSize(new Dimension(150, 26));
        nombreTXTDerecho.setMaximumSize(new Dimension(150, 26));
        nombreTXTDerecho.setBackground(Color.decode("#DBF5F0"));
        nombreTXTDerecho.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsInventarioDerecho.add(nombreTXTDerecho, fieldsGbc4);

        fieldsGbc4.gridx = 1;
        fieldsGbc4.gridy = 0;
        JLabel cantidadLBL = new JLabel("Cantidad");
        cantidadLBL.setForeground(Color.decode("#37BEB0"));
        cantidadLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsInventarioDerecho.add(cantidadLBL, fieldsGbc4);

        fieldsGbc4.gridy = 1;
        JTextField cantidadTXT = new JTextField();
        cantidadTXT.setPreferredSize(new Dimension(150, 26));
        cantidadTXT.setMaximumSize(new Dimension(150, 26));
        cantidadTXT.setBackground(Color.decode("#DBF5F0"));
        cantidadTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsInventarioDerecho.add(cantidadTXT, fieldsGbc4);

        fieldsGbc4.gridx = 0;
        fieldsGbc4.gridy = 2;
        fieldsGbc4.gridwidth = 2; // Para que el botón ocupe el ancho de los dos campos anteriores
        JButton addBTN = new JButton("Agregar Inventario");
        addBTN.setPreferredSize(new Dimension(310, 25));
        addBTN.setMaximumSize(new Dimension(310, 25));
        addBTN.setBackground(Color.decode("#37BEB0"));
        addBTN.setForeground(Color.white);
        addBTN.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsInventarioDerecho.add(addBTN, fieldsGbc4);

        gbc.gridy++;
        panelDerecho.add(fieldsInventarioDerecho, gbc);

        gbc.gridwidth = 4; // Ensure the second subtitle spans across the panel
        gbc.gridy++;

        JLabel subtituloDerecho2 = new JLabel("Buscar Pieza");
        subtituloDerecho2.setFont(new Font("ARIAL", Font.BOLD, 28));
        subtituloDerecho2.setForeground(Color.decode("#0C6170"));
        subtituloDerecho2.setHorizontalAlignment(SwingConstants.CENTER);
        panelDerecho.add(subtituloDerecho2, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;

        JPanel fieldsBuscarDerecho = new JPanel();
        fieldsBuscarDerecho.setLayout(new GridBagLayout());
        fieldsBuscarDerecho.setBackground(Color.white);
        GridBagConstraints fieldsGbc5 = new GridBagConstraints();
        fieldsGbc5.insets = new Insets(3, 3, 3, 3); // Márgenes internos reducidos
        fieldsGbc5.anchor = GridBagConstraints.WEST;

        fieldsGbc5.gridx = 0;
        fieldsGbc5.gridy = 0;
        JLabel nombreLBL2Derecho = new JLabel("Nombre");
        nombreLBL2Derecho.setForeground(Color.decode("#37BEB0"));
        nombreLBL2Derecho.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsBuscarDerecho.add(nombreLBL2Derecho, fieldsGbc5);

        fieldsGbc5.gridy = 1;
        JTextField nombreTXT2Derecho = new JTextField();
        nombreTXT2Derecho.setPreferredSize(new Dimension(150, 26));
        nombreTXT2Derecho.setMaximumSize(new Dimension(150, 26));
        nombreTXT2Derecho.setBackground(Color.decode("#DBF5F0"));
        nombreTXT2Derecho.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsGbc5.fill = GridBagConstraints.HORIZONTAL; // Expandir el campo de texto
        fieldsGbc5.weightx = 1.0; // Tomar todo el espacio horizontal disponible
        fieldsBuscarDerecho.add(nombreTXT2Derecho, fieldsGbc5);

        fieldsGbc5.gridx = 0;
        fieldsGbc5.gridy = 2;
        fieldsGbc5.gridwidth = 2; // Para que el botón ocupe el ancho de los dos campos anteriores
        JButton buscarBTN = new JButton("Buscar");
        buscarBTN.setPreferredSize(new Dimension(310, 25));
        buscarBTN.setMaximumSize(new Dimension(310, 25));
        buscarBTN.setBackground(Color.decode("#37BEB0"));
        buscarBTN.setForeground(Color.white);
        buscarBTN.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsBuscarDerecho.add(buscarBTN, fieldsGbc5);

        gbc.gridy++;
        panelDerecho.add(fieldsBuscarDerecho, gbc);

        JPanel outputPanelDerecho = new JPanel(new BorderLayout());
        outputPanelDerecho.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Márgenes reducidos
        outputPanelDerecho.setBackground(Color.white);

        JTextArea outputField = new JTextArea(5, 30);
        outputField.setBorder(BorderFactory.createLineBorder(Color.black));
        outputField.setBackground(Color.decode("#DBF5F0")); // Fondo diferente para JTextArea

        JScrollPane scrollPane = new JScrollPane(outputField);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        outputPanelDerecho.add(scrollPane, BorderLayout.CENTER);

        gbc.gridy++;
        panelDerecho.add(outputPanelDerecho, gbc);

        MainPanel.add(panelIzquierdo);
        MainPanel.add(panelDerecho);

        this.setLayout(new BorderLayout());
        this.add(MainPanel, BorderLayout.CENTER);
    }
}