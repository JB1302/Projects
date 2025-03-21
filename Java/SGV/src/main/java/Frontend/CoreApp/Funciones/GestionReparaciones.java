package Frontend.CoreApp.Funciones;

import Backend.controlador.ReparacionController;
import Backend.modelo.Vehiculo.OrdenReparacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class GestionReparaciones extends JPanel {

    JPanel MainPanel;

    public GestionReparaciones() {
        MainPanel = new JPanel();
        MainPanel.setLayout(new GridLayout(1, 2));
        MainPanel.setBackground(Color.white);

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridBagLayout());
        panelIzquierdo.setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Márgenes internos
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel subtituloIzquierdo = new JLabel("Añadir Reparación");
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
        fieldsGbc2.insets = new Insets(5, 5, 5, 5);
        fieldsGbc2.anchor = GridBagConstraints.WEST;

        // Conjunto 2
        fieldsGbc2.gridx = 0;
        fieldsGbc2.gridy = 0;
        JLabel placalabel = new JLabel("Placa");
        placalabel.setForeground(Color.decode("#37BEB0"));
        placalabel.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(placalabel, fieldsGbc2);

        fieldsGbc2.gridy = 1;
        JTextField placatxt = new JTextField();
        placatxt.setPreferredSize(new Dimension(150, 26));
        placatxt.setMaximumSize(new Dimension(150, 26));
        placatxt.setBackground(Color.decode("#DBF5F0"));
        placatxt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(placatxt, fieldsGbc2);

        fieldsGbc2.gridx = 1;
        fieldsGbc2.gridy = 0;
        JLabel propietarioLBL = new JLabel("Propietario");
        propietarioLBL.setForeground(Color.decode("#37BEB0"));
        propietarioLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(propietarioLBL, fieldsGbc2);

        fieldsGbc2.gridy = 1;
        JTextField propietarioTXT = new JTextField();
        propietarioTXT.setPreferredSize(new Dimension(150, 26));
        propietarioTXT.setMaximumSize(new Dimension(150, 26));
        propietarioTXT.setBackground(Color.decode("#DBF5F0"));
        propietarioTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(propietarioTXT, fieldsGbc2);

        fieldsGbc2.gridx = 0;
        fieldsGbc2.gridy = 2;
        JLabel descripcionLBL = new JLabel("Descripción");
        descripcionLBL.setForeground(Color.decode("#37BEB0"));
        descripcionLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(descripcionLBL, fieldsGbc2);

        fieldsGbc2.gridy = 3;
        JTextField descripcionTXT = new JTextField();
        descripcionTXT.setPreferredSize(new Dimension(150, 26));
        descripcionTXT.setMaximumSize(new Dimension(150, 26));
        descripcionTXT.setBackground(Color.decode("#DBF5F0"));
        descripcionTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(descripcionTXT, fieldsGbc2);

        fieldsGbc2.gridx = 1;
        fieldsGbc2.gridy = 2;
        JLabel mecanicoReparacionLBL = new JLabel("Mecanico");
        mecanicoReparacionLBL.setForeground(Color.decode("#37BEB0"));
        mecanicoReparacionLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(mecanicoReparacionLBL, fieldsGbc2);

        fieldsGbc2.gridy = 3;
        JTextField mecanicoIDReparaicontxt = new JTextField();
        mecanicoIDReparaicontxt.setPreferredSize(new Dimension(150, 26));
        mecanicoIDReparaicontxt.setMaximumSize(new Dimension(150, 26));
        mecanicoIDReparaicontxt.setBackground(Color.decode("#DBF5F0"));
        mecanicoIDReparaicontxt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(mecanicoIDReparaicontxt, fieldsGbc2);

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
        JButton crearReparacion = new JButton("Crear Reparación");
        crearReparacion.setPreferredSize(new Dimension(310, 25));
        crearReparacion.setMaximumSize(new Dimension(310, 25));
        crearReparacion.setBackground(Color.decode("#37BEB0"));
        crearReparacion.setForeground(Color.white);
        crearReparacion.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsIzquierdos.add(crearReparacion, fieldsGbc2);

        panelIzquierdo.add(fieldsIzquierdos, gbc);

        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new GridBagLayout());
        panelDerecho.setBackground(Color.white);

        GridBagConstraints gbcDerecho = new GridBagConstraints();
        gbcDerecho.insets = new Insets(5, 5, 5, 5); // Márgenes internos iguales a los del lado izquierdo
        gbcDerecho.gridx = 0;
        gbcDerecho.gridy = 0;
        gbcDerecho.anchor = GridBagConstraints.CENTER;
        gbcDerecho.fill = GridBagConstraints.HORIZONTAL;

        JLabel subtituloDerecho = new JLabel("Actualizar Reparacion");
        subtituloDerecho.setFont(new Font("ARIAL", Font.BOLD, 28));
        subtituloDerecho.setForeground(Color.decode("#0C6170"));
        subtituloDerecho.setHorizontalAlignment(SwingConstants.CENTER);
        gbcDerecho.gridwidth = 4;
        panelDerecho.add(subtituloDerecho, gbcDerecho);

        gbcDerecho.gridwidth = 1;
        gbcDerecho.gridy++;

        JPanel fieldsInventarioDerecho = new JPanel();
        fieldsInventarioDerecho.setLayout(new GridBagLayout());
        fieldsInventarioDerecho.setBackground(Color.white);
        GridBagConstraints fieldsGbcDerecho = new GridBagConstraints();
        fieldsGbcDerecho.insets = new Insets(5, 5, 5, 5); // Márgenes internos iguales a los del lado izquierdo
        fieldsGbcDerecho.anchor = GridBagConstraints.WEST;

        fieldsGbcDerecho.gridx = 0;
        fieldsGbcDerecho.gridy = 0;

        JLabel placaDerechaLBL = new JLabel("Placa");
        placaDerechaLBL.setForeground(Color.decode("#37BEB0"));
        placaDerechaLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsInventarioDerecho.add(placaDerechaLBL, fieldsGbcDerecho);

        fieldsGbcDerecho.gridy = 1;
        JTextField placaReparacion = new JTextField();
        placaReparacion.setPreferredSize(new Dimension(150, 26));
        placaReparacion.setMaximumSize(new Dimension(150, 26));
        placaReparacion.setBackground(Color.decode("#DBF5F0"));
        placaReparacion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsInventarioDerecho.add(placaReparacion, fieldsGbcDerecho);

        fieldsGbcDerecho.gridx = 1;
        fieldsGbcDerecho.gridy = 0;
        JLabel estadoLBL = new JLabel("Estado");
        estadoLBL.setForeground(Color.decode("#37BEB0"));
        estadoLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsInventarioDerecho.add(estadoLBL, fieldsGbcDerecho);

        fieldsGbcDerecho.gridy = 1;
        JComboBox<String> estadoComboBox = new JComboBox<>(new String[]{"PROGRAMADA", "CANCELADA"});
        estadoComboBox.setPreferredSize(new Dimension(150, 26));
        estadoComboBox.setMaximumSize(new Dimension(150, 26));
        estadoComboBox.setBackground(Color.decode("#37BEB0"));
        estadoComboBox.setForeground(Color.white);
        estadoComboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsInventarioDerecho.add(estadoComboBox, fieldsGbcDerecho);

        fieldsGbcDerecho.gridx = 0;
        fieldsGbcDerecho.gridy = 2;
        fieldsGbcDerecho.gridwidth = 2; // Para que el botón ocupe el ancho de los dos campos anteriores
        JButton actualizarEstadoBTN = new JButton("Actualizar Orden");
        actualizarEstadoBTN.setPreferredSize(new Dimension(310, 25));
        actualizarEstadoBTN.setMaximumSize(new Dimension(310, 25));
        actualizarEstadoBTN.setBackground(Color.decode("#37BEB0"));
        actualizarEstadoBTN.setForeground(Color.white);
        actualizarEstadoBTN.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsInventarioDerecho.add(actualizarEstadoBTN, fieldsGbcDerecho);

        gbcDerecho.gridy++;
        panelDerecho.add(fieldsInventarioDerecho, gbcDerecho);

        gbcDerecho.gridwidth = 4;
        gbcDerecho.gridy++;

        JLabel subtituloDerecho2 = new JLabel("Actualizar Mecanico");
        subtituloDerecho2.setFont(new Font("ARIAL", Font.BOLD, 28));
        subtituloDerecho2.setForeground(Color.decode("#0C6170"));
        subtituloDerecho2.setHorizontalAlignment(SwingConstants.CENTER);
        panelDerecho.add(subtituloDerecho2, gbcDerecho);

        gbcDerecho.gridy++;
        gbcDerecho.gridwidth = 1;

        JPanel fieldsInventarioDerecho2 = new JPanel();
        fieldsInventarioDerecho2.setLayout(new GridBagLayout());
        fieldsInventarioDerecho2.setBackground(Color.white);
        GridBagConstraints fieldsGbcDerecho2 = new GridBagConstraints();
        fieldsGbcDerecho2.insets = new Insets(5, 5, 5, 5); // Márgenes internos iguales a los del lado izquierdo
        fieldsGbcDerecho2.anchor = GridBagConstraints.WEST;

        fieldsGbcDerecho2.gridx = 0;
        fieldsGbcDerecho2.gridy = 0;
        JLabel placaMecanicoLBL = new JLabel("Placa");
        placaMecanicoLBL.setForeground(Color.decode("#37BEB0"));
        placaMecanicoLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsInventarioDerecho2.add(placaMecanicoLBL, fieldsGbcDerecho2);

        fieldsGbcDerecho2.gridy = 1;
        JTextField placaMecanicoTXT = new JTextField();
        placaMecanicoTXT.setPreferredSize(new Dimension(150, 26));
        placaMecanicoTXT.setMaximumSize(new Dimension(150, 26));
        placaMecanicoTXT.setBackground(Color.decode("#DBF5F0"));
        placaMecanicoTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsInventarioDerecho2.add(placaMecanicoTXT, fieldsGbcDerecho2);

        fieldsGbcDerecho2.gridx = 1;
        fieldsGbcDerecho2.gridy = 0;
        JLabel mecanicoLBL = new JLabel("Mecanico");
        mecanicoLBL.setForeground(Color.decode("#37BEB0"));
        mecanicoLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsInventarioDerecho2.add(mecanicoLBL, fieldsGbcDerecho2);

        fieldsGbcDerecho2.gridy = 1;
        JTextField mecanicoTXT = new JTextField();
        mecanicoTXT.setPreferredSize(new Dimension(150, 26));
        mecanicoTXT.setMaximumSize(new Dimension(150, 26));
        mecanicoTXT.setBackground(Color.decode("#DBF5F0"));
        mecanicoTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsInventarioDerecho2.add(mecanicoTXT, fieldsGbcDerecho2);

        fieldsGbcDerecho2.gridx = 0;
        fieldsGbcDerecho2.gridy = 2;
        fieldsGbcDerecho2.gridwidth = 2; // Para que el botón ocupe el ancho de los dos campos anteriores

        JButton addBTN2 = new JButton("Actualizar Mecanico");
        addBTN2.setPreferredSize(new Dimension(310, 25));
        addBTN2.setMaximumSize(new Dimension(310, 25));
        addBTN2.setBackground(Color.decode("#37BEB0"));
        addBTN2.setForeground(Color.white);
        addBTN2.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsInventarioDerecho2.add(addBTN2, fieldsGbcDerecho2);

        gbcDerecho.gridy++;
        panelDerecho.add(fieldsInventarioDerecho2, gbcDerecho);

        // Área de texto para mostrar resultados al final
        gbcDerecho.gridy++;
        gbcDerecho.weightx = 0;    // No permitir expansión horizontal
        gbcDerecho.weighty = 0;    // No permitir expansión vertical
        gbcDerecho.fill = GridBagConstraints.NONE;  // No se expande automáticamente
        gbcDerecho.gridwidth = 2;

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

        crearReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String placa = placatxt.getText();
                    String propietario = propietarioTXT.getText();
                    String descripcion = descripcionTXT.getText();
                    String fechaSTR = fechaTxt.getText();
                    int mecanico = Integer.parseInt(mecanicoIDReparaicontxt.getText());

                    // Usar un formato más flexible para la fecha
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
                    LocalDate fechaDate = LocalDate.parse(fechaSTR, formatter);
                    LocalDateTime fecha = fechaDate.atTime(0, 0);

                    String fechaConvertida = fecha.toString();

                    OrdenReparacion ordenReparacion = new OrdenReparacion(placa, propietario, descripcion, fechaConvertida, mecanico);
                    ReparacionController reparacionController = new ReparacionController(ordenReparacion);

                    reparacionController.insertarObjeto();

                    // Mostrar mensaje de confirmación
                    JOptionPane.showMessageDialog(null, "Reparación creada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    // Limpiar campos
                    placatxt.setText("");
                    propietarioTXT.setText("");
                    descripcionTXT.setText("");
                    fechaTxt.setText("");
                    mecanicoIDReparaicontxt.setText("");

                    outputField.setText("Reparacion creada");

                } catch (Exception ex) {
                    outputField.setText("Error creando Reparacion");

                }
            }
        });

        addBTN2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String placa = placaMecanicoTXT.getText();
                int mecanico = Integer.parseInt(mecanicoTXT.getText());

                ReparacionController reparacionController = new ReparacionController();
                reparacionController.asignarMecanico(placa, mecanico);

                outputField.setText("Mecanico Actualizado");
            }
        });


        actualizarEstadoBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = placaReparacion.getText();

                // Obtener el valor seleccionado como String
                String estadoStr = (String) estadoComboBox.getSelectedItem();

                // Convertir el String al enum correspondiente
                ReparacionController.Estado estadoSeleccionado = ReparacionController.Estado.valueOf(estadoStr);

                // Crear el controlador y actualizar el estado
                ReparacionController reparacionController = new ReparacionController();
                reparacionController.actualizarEstado(placa, estadoSeleccionado);

                outputField.setText("Estado Actualizado");
            }
        });
    }
}