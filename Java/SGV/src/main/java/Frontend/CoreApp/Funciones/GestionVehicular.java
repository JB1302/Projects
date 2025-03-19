package Frontend.CoreApp.Funciones;

import javax.swing.*;
import java.awt.*;

public class GestionVehicular extends JPanel {

    JPanel MainPanel;

    public GestionVehicular() {
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

        JLabel subtituloIzquierdo = new JLabel("Añadir Vehiculo");
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
        fieldsGbc2.insets = new Insets(5, 5, 5, 5); // Márgenes internos reducidos
        fieldsGbc2.anchor = GridBagConstraints.WEST;

// Conjunto 2
        fieldsGbc2.gridx = 0;
        fieldsGbc2.gridy = 0;
        JLabel placaLabel = new JLabel("Placa");
        placaLabel.setForeground(Color.decode("#37BEB0"));
        placaLabel.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(placaLabel, fieldsGbc2);

        fieldsGbc2.gridy = 1;
        JTextField placaTXT = new JTextField();
        placaTXT.setPreferredSize(new Dimension(150, 26));
        placaTXT.setMaximumSize(new Dimension(150, 26));
        placaTXT.setBackground(Color.decode("#DBF5F0"));
        placaTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(placaTXT, fieldsGbc2);

        fieldsGbc2.gridx = 1;
        fieldsGbc2.gridy = 0;
        JLabel modeloLBL = new JLabel("Modelo");
        modeloLBL.setForeground(Color.decode("#37BEB0"));
        modeloLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(modeloLBL, fieldsGbc2);

        fieldsGbc2.gridy = 1;
        JTextField modeloTXT = new JTextField();
        modeloTXT.setPreferredSize(new Dimension(150, 26));
        modeloTXT.setMaximumSize(new Dimension(150, 26));
        modeloTXT.setBackground(Color.decode("#DBF5F0"));
        modeloTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(modeloTXT, fieldsGbc2);

        fieldsGbc2.gridx = 0;
        fieldsGbc2.gridy = 2;
        JLabel yearLBL = new JLabel("Año");
        yearLBL.setForeground(Color.decode("#37BEB0"));
        yearLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(yearLBL, fieldsGbc2);

        fieldsGbc2.gridy = 3;
        JTextField yearTXT = new JTextField();
        yearTXT.setPreferredSize(new Dimension(150, 26));
        yearTXT.setMaximumSize(new Dimension(150, 26));
        yearTXT.setBackground(Color.decode("#DBF5F0"));
        yearTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(yearTXT, fieldsGbc2);

        fieldsGbc2.gridx = 1;
        fieldsGbc2.gridy = 2;
        JLabel propietarioLBL = new JLabel("Propietario");
        propietarioLBL.setForeground(Color.decode("#37BEB0"));
        propietarioLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(propietarioLBL, fieldsGbc2);

        fieldsGbc2.gridy = 3;
        JTextField propietarioTXT = new JTextField();
        propietarioTXT.setPreferredSize(new Dimension(150, 26));
        propietarioTXT.setMaximumSize(new Dimension(150, 26));
        propietarioTXT.setBackground(Color.decode("#DBF5F0"));
        propietarioTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(propietarioTXT, fieldsGbc2);

// Campo de Fecha para "Fecha"
        fieldsGbc2.gridx = 0;
        fieldsGbc2.gridy = 4;
        JLabel fechaLabel = new JLabel("Fecha");
        fechaLabel.setForeground(Color.decode("#37BEB0"));
        fechaLabel.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(fechaLabel, fieldsGbc2);

        fieldsGbc2.gridx = 0;
        fieldsGbc2.gridy = 5;
        fieldsGbc2.gridwidth = 4;
        JTextField fechaTxt = new JTextField();
        fechaTxt.setPreferredSize(new Dimension(310, 26));
        fechaTxt.setMaximumSize(new Dimension(310, 26));
        fechaTxt.setBackground(Color.decode("#DBF5F0"));
        fechaTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(fechaTxt, fieldsGbc2);

        fieldsGbc2.gridy = 6;
        JButton crearVehiculo = new JButton("Crear Vehiculo");
        crearVehiculo.setPreferredSize(new Dimension(310, 25));
        crearVehiculo.setMaximumSize(new Dimension(310, 25));
        crearVehiculo.setBackground(Color.decode("#37BEB0"));
        crearVehiculo.setForeground(Color.white);
        crearVehiculo.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsIzquierdos.add(crearVehiculo, fieldsGbc2);

        panelIzquierdo.add(fieldsIzquierdos, gbc);

        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new GridBagLayout());
        panelDerecho.setBackground(Color.white);

        GridBagConstraints gbcDerecho = new GridBagConstraints();
        gbcDerecho.insets = new Insets(5, 5, 5, 5); // Márgenes internos reducidos
        gbcDerecho.gridx = 0;
        gbcDerecho.gridy = 0;
        gbcDerecho.anchor = GridBagConstraints.CENTER;
        gbcDerecho.fill = GridBagConstraints.HORIZONTAL;

        JLabel subtituloBuscar = new JLabel("Buscar Coche");
        subtituloBuscar.setFont(new Font("ARIAL", Font.BOLD, 28));
        subtituloBuscar.setForeground(Color.decode("#0C6170"));
        subtituloBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        gbcDerecho.gridwidth = 4;
        panelDerecho.add(subtituloBuscar, gbcDerecho);

        gbcDerecho.gridwidth = 1;
        gbcDerecho.gridy++;

        JPanel fieldsBuscarDerecho = new JPanel();
        fieldsBuscarDerecho.setLayout(new GridBagLayout());
        fieldsBuscarDerecho.setBackground(Color.white);
        GridBagConstraints fieldsGbcBuscarDerecho = new GridBagConstraints();
        fieldsGbcBuscarDerecho.insets = new Insets(5, 5, 5, 5); // Márgenes internos reducidos
        fieldsGbcBuscarDerecho.anchor = GridBagConstraints.WEST;
        fieldsGbcBuscarDerecho.fill = GridBagConstraints.HORIZONTAL; // Para que el JTextField ocupe todo el espacio horizontal disponible

        fieldsGbcBuscarDerecho.gridx = 0;
        fieldsGbcBuscarDerecho.gridy = 0;

        JLabel emailLBLBuscar = new JLabel("Email");
        emailLBLBuscar.setForeground(Color.decode("#37BEB0"));
        emailLBLBuscar.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsBuscarDerecho.add(emailLBLBuscar, fieldsGbcBuscarDerecho);

        fieldsGbcBuscarDerecho.gridy = 1;
        fieldsGbcBuscarDerecho.gridwidth = 4; // Para que el JTextField ocupe todo el ancho del contenedor
        JTextField emailTXTBuscar = new JTextField();
        emailTXTBuscar.setPreferredSize(new Dimension(310, 26));
        emailTXTBuscar.setMaximumSize(new Dimension(310, 26));
        emailTXTBuscar.setBackground(Color.decode("#DBF5F0"));
        emailTXTBuscar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsBuscarDerecho.add(emailTXTBuscar, fieldsGbcBuscarDerecho);

        fieldsGbcBuscarDerecho.gridx = 0;
        fieldsGbcBuscarDerecho.gridy = 2;
        fieldsGbcBuscarDerecho.gridwidth = 4;
        JButton buscarBTN = new JButton("Buscar Coche");
        buscarBTN.setPreferredSize(new Dimension(310, 25));
        buscarBTN.setMaximumSize(new Dimension(310, 25));
        buscarBTN.setBackground(Color.decode("#37BEB0"));
        buscarBTN.setForeground(Color.white);
        buscarBTN.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsBuscarDerecho.add(buscarBTN, fieldsGbcBuscarDerecho);

        gbcDerecho.gridy++;
        panelDerecho.add(fieldsBuscarDerecho, gbcDerecho);

        gbcDerecho.gridy++;
        JLabel subtituloActualizar = new JLabel("Actualizar Vehiculo");
        subtituloActualizar.setFont(new Font("ARIAL", Font.BOLD, 28));
        subtituloActualizar.setForeground(Color.decode("#0C6170"));
        subtituloActualizar.setHorizontalAlignment(SwingConstants.CENTER);
        gbcDerecho.gridwidth = 4;
        panelDerecho.add(subtituloActualizar, gbcDerecho);

        gbcDerecho.gridwidth = 1;
        gbcDerecho.gridy++;

        JPanel fieldsInventarioDerecho = new JPanel();
        fieldsInventarioDerecho.setLayout(new GridBagLayout());
        fieldsInventarioDerecho.setBackground(Color.white);
        GridBagConstraints fieldsGbcDerecho = new GridBagConstraints();
        fieldsGbcDerecho.insets = new Insets(5, 5, 5, 5); // Márgenes internos reducidos
        fieldsGbcDerecho.anchor = GridBagConstraints.WEST;

        fieldsGbcDerecho.gridx = 0;
        fieldsGbcDerecho.gridy = 0;

        JLabel nombreLBLDerecho = new JLabel("Nombre");
        nombreLBLDerecho.setForeground(Color.decode("#37BEB0"));
        nombreLBLDerecho.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsInventarioDerecho.add(nombreLBLDerecho, fieldsGbcDerecho);

        fieldsGbcDerecho.gridy = 1;
        JTextField nombreTXTDerecho = new JTextField();
        nombreTXTDerecho.setPreferredSize(new Dimension(150, 26));
        nombreTXTDerecho.setMaximumSize(new Dimension(150, 26));
        nombreTXTDerecho.setBackground(Color.decode("#DBF5F0"));
        nombreTXTDerecho.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsInventarioDerecho.add(nombreTXTDerecho, fieldsGbcDerecho);

        fieldsGbcDerecho.gridx = 1;
        fieldsGbcDerecho.gridy = 0;
        JLabel estadoLBLDerecho = new JLabel("Estado");
        estadoLBLDerecho.setForeground(Color.decode("#37BEB0"));
        estadoLBLDerecho.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsInventarioDerecho.add(estadoLBLDerecho, fieldsGbcDerecho);

        fieldsGbcDerecho.gridy = 1;
        JComboBox<String> estadoComboBox = new JComboBox<>(new String[]{"PENDIENTE", "TRABAJANDO", "FINALIZADO"});
        estadoComboBox.setPreferredSize(new Dimension(150, 26));
        estadoComboBox.setMaximumSize(new Dimension(150, 26));
        estadoComboBox.setBackground(Color.decode("#DBF5F0"));
        estadoComboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsInventarioDerecho.add(estadoComboBox, fieldsGbcDerecho);

        fieldsGbcDerecho.gridx = 0;
        fieldsGbcDerecho.gridy = 2;
        fieldsGbcDerecho.gridwidth = 2; // Para que el botón ocupe el ancho de los dos campos anteriores
        JButton addBTN = new JButton("Agregar Inventario");
        addBTN.setPreferredSize(new Dimension(310, 25));
        addBTN.setMaximumSize(new Dimension(310, 25));
        addBTN.setBackground(Color.decode("#37BEB0"));
        addBTN.setForeground(Color.white);
        addBTN.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsInventarioDerecho.add(addBTN, fieldsGbcDerecho);

        gbcDerecho.gridy++;
        panelDerecho.add(fieldsInventarioDerecho, gbcDerecho);

// Área de texto para mostrar resultados al final
        gbcDerecho.gridy++;
        gbcDerecho.weightx = 0; // No permitir expansión horizontal
        gbcDerecho.weighty = 0; // No permitir expansión vertical
        gbcDerecho.fill = GridBagConstraints.NONE; // No se expande automáticamente
        gbcDerecho.gridwidth = 4;

        JTextArea outputField = new JTextArea(1, 30); // 1 fila para mantener la altura reducida
        outputField.setBorder(BorderFactory.createLineBorder(Color.black));
        outputField.setBackground(Color.decode("#DBF5F0"));
        outputField.setPreferredSize(new Dimension(310, 60)); // Tamaño fijo

        JScrollPane scrollPane = new JScrollPane(outputField);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(310, 60)); // Tamaño fijo del JScrollPane

        panelDerecho.add(scrollPane, gbcDerecho);

        MainPanel.add(panelIzquierdo);
        MainPanel.add(panelDerecho);

        this.setLayout(new BorderLayout());
        this.add(MainPanel, BorderLayout.CENTER);
    }
}