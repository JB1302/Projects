package Frontend.CoreApp.Funciones;

import Backend.modelo.Inventario.Pieza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JLabel subtituloIzquierdo = new JLabel("Añadir Pieza");
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
        JLabel nombreLBL = new JLabel("Nombre");
        nombreLBL.setForeground(Color.decode("#37BEB0"));
        nombreLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(nombreLBL, fieldsGbc2);

        fieldsGbc2.gridy = 1;
        JTextField nombreTXT = new JTextField();
        nombreTXT.setPreferredSize(new Dimension(150, 26));
        nombreTXT.setMaximumSize(new Dimension(150, 26));
        nombreTXT.setBackground(Color.decode("#DBF5F0"));
        nombreTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(nombreTXT, fieldsGbc2);

        fieldsGbc2.gridx = 1;
        fieldsGbc2.gridy = 0;
        JLabel cantidadLBL = new JLabel("Cantidad");
        cantidadLBL.setForeground(Color.decode("#37BEB0"));
        cantidadLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(cantidadLBL, fieldsGbc2);

        fieldsGbc2.gridy = 1;
        JTextField cantidadTXT = new JTextField();
        cantidadTXT.setPreferredSize(new Dimension(150, 26));
        cantidadTXT.setMaximumSize(new Dimension(150, 26));
        cantidadTXT.setBackground(Color.decode("#DBF5F0"));
        cantidadTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(cantidadTXT, fieldsGbc2);

        fieldsGbc2.gridx = 0;
        fieldsGbc2.gridy = 2;
        JLabel costoLBL = new JLabel("Costo");
        costoLBL.setForeground(Color.decode("#37BEB0"));
        costoLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(costoLBL, fieldsGbc2);

        fieldsGbc2.gridy = 3;
        JTextField costoTXT = new JTextField();
        costoTXT.setPreferredSize(new Dimension(150, 26));
        costoTXT.setMaximumSize(new Dimension(150, 26));
        costoTXT.setBackground(Color.decode("#DBF5F0"));
        costoTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(costoTXT, fieldsGbc2);

        fieldsGbc2.gridx = 1;
        fieldsGbc2.gridy = 2;
        JLabel descripcionLBL = new JLabel("Descripcion");
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

        fieldsGbc2.gridx = 0;
        fieldsGbc2.gridy = 4;
        fieldsGbc2.gridwidth = 2; // Para que el botón ocupe el ancho de los dos campos anteriores
        JButton crearPiezaBTN = new JButton("Crear Pieza");
        crearPiezaBTN.setPreferredSize(new Dimension(310, 25));
        crearPiezaBTN.setMaximumSize(new Dimension(310, 25));
        crearPiezaBTN.setBackground(Color.decode("#37BEB0"));
        crearPiezaBTN.setForeground(Color.white);
        crearPiezaBTN.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsIzquierdos.add(crearPiezaBTN, fieldsGbc2);

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
        JLabel nombreInventarioLBL = new JLabel("Nombre");
        nombreInventarioLBL.setForeground(Color.decode("#37BEB0"));
        nombreInventarioLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsInventario.add(nombreInventarioLBL, fieldsGbc3);

        fieldsGbc3.gridy = 1;
        JTextField nombreInventarioTXT = new JTextField();
        nombreInventarioTXT.setPreferredSize(new Dimension(150, 26));
        nombreInventarioTXT.setMaximumSize(new Dimension(150, 26));
        nombreInventarioTXT.setBackground(Color.decode("#DBF5F0"));
        nombreInventarioTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsInventario.add(nombreInventarioTXT, fieldsGbc3);

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
        JLabel cantidadLBLDerecha = new JLabel("Cantidad");
        cantidadLBLDerecha.setForeground(Color.decode("#37BEB0"));
        cantidadLBLDerecha.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsInventarioDerecho.add(cantidadLBLDerecha, fieldsGbc4);

        fieldsGbc4.gridy = 1;
        JTextField cantidadTXTDerecha = new JTextField();
        cantidadTXTDerecha.setPreferredSize(new Dimension(150, 26));
        cantidadTXTDerecha.setMaximumSize(new Dimension(150, 26));
        cantidadTXTDerecha.setBackground(Color.decode("#DBF5F0"));
        cantidadTXTDerecha.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsInventarioDerecho.add(cantidadTXTDerecha, fieldsGbc4);

        fieldsGbc4.gridx = 0;
        fieldsGbc4.gridy = 2;
        fieldsGbc4.gridwidth = 2; // Para que el botón ocupe el ancho de los dos campos anteriores
        JButton addBTN = new JButton("Agregar a Inventario");
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
        JLabel nombrePiezaLBL = new JLabel("Nombre");
        nombrePiezaLBL.setForeground(Color.decode("#37BEB0"));
        nombrePiezaLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsBuscarDerecho.add(nombrePiezaLBL, fieldsGbc5);

        fieldsGbc5.gridy = 1;
        JTextField nombrePiezaTXT = new JTextField();
        nombrePiezaTXT.setPreferredSize(new Dimension(150, 26));
        nombrePiezaTXT.setMaximumSize(new Dimension(150, 26));
        nombrePiezaTXT.setBackground(Color.decode("#DBF5F0"));
        nombrePiezaTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsGbc5.fill = GridBagConstraints.HORIZONTAL; // Expandir el campo de texto
        fieldsGbc5.weightx = 1.0; // Tomar todo el espacio horizontal disponible
        fieldsBuscarDerecho.add(nombrePiezaTXT, fieldsGbc5);

        fieldsGbc5.gridx = 0;
        fieldsGbc5.gridy = 2;
        fieldsGbc5.gridwidth = 2; // Para que el botón ocupe el ancho de los dos campos anteriores
        JButton buscarPiezaBTN = new JButton("Buscar");
        buscarPiezaBTN.setPreferredSize(new Dimension(310, 25));
        buscarPiezaBTN.setMaximumSize(new Dimension(310, 25));
        buscarPiezaBTN.setBackground(Color.decode("#37BEB0"));
        buscarPiezaBTN.setForeground(Color.white);
        buscarPiezaBTN.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsBuscarDerecho.add(buscarPiezaBTN, fieldsGbc5);

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

        crearPiezaBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTXT.getText();
                String descripcion = descripcionTXT.getText();
                int cantidad = Integer.parseInt(cantidadTXT.getText());
                int precioUnitario = Integer.parseInt(costoTXT.getText());

                Pieza pieza = new Pieza(nombre,descripcion,cantidad,precioUnitario);
                pieza.insertarObjeto();

                outputField.setText("Pieza creada");
            }
        });

        compararInventarioBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = nombreInventarioTXT.getText();
                int necesitado = Integer.parseInt(necesitadoTXT.getText());

                Backend.modelo.Inventario.Inventario inventario = new Backend.modelo.Inventario.Inventario();
                outputField.setText(inventario.revisarDisponibilidad(nombre, necesitado));
            }
        });

        addBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTXTDerecho.getText();
                int cantidadAñadir = Integer.parseInt(cantidadTXTDerecha.getText());

              Backend.modelo.Inventario.Inventario inventario = new Backend.modelo.Inventario.Inventario();
              inventario.actualizarCantidad(nombre,cantidadAñadir);

                outputField.setText("Stock Añadido");
            }
        }); //AÑADIR STOCK

        buscarPiezaBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombrePiezaTXT.getText();

                if(!nombre.isEmpty()) {
                    Backend.modelo.Inventario.Inventario inventario = new Backend.modelo.Inventario.Inventario();
                    outputField.setText(inventario.buscarPieza(nombre));
                }else {
                    Backend.modelo.Inventario.Inventario inventario = new Backend.modelo.Inventario.Inventario();
                    outputField.setText(inventario.mostrarInventario());
                }

            }
        });


    }

}