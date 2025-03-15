package Frontend.CoreApp.Funciones;

import Backend.modelo.Factura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Facturas extends JPanel {

    private JPanel mainPanel;

    public Facturas() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white); // Fondo blanco para el panel principal

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));
        mainPanel.setBackground(Color.white);

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridBagLayout());
        panelIzquierdo.setBackground(Color.white); // Fondo blanco para el panel izquierdo

        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.insets = new Insets(5, 10, 5, 10);
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.anchor = GridBagConstraints.CENTER;
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;

        // Subtítulo del panel izquierdo
        JLabel subtitulo1 = new JLabel("Generar Factura");
        subtitulo1.setFont(new Font("ARIAL", Font.BOLD, 28));
        subtitulo1.setForeground(Color.decode("#0C6170"));
        subtitulo1.setHorizontalAlignment(SwingConstants.CENTER);
        gridConstraints.gridwidth = 2;
        panelIzquierdo.add(subtitulo1, gridConstraints);

        gridConstraints.gridwidth = 1;
        gridConstraints.gridy++;

        // Campo de texto para "Usuario"
        JLabel usuarioPlaca = new JLabel("Placa");
        usuarioPlaca.setForeground(Color.decode("#37BEB0"));
        usuarioPlaca.setFont(new Font("ARIAL", Font.BOLD, 12));
        panelIzquierdo.add(usuarioPlaca, gridConstraints);

        gridConstraints.gridy++;
        JTextField placaTXT = new JTextField();
        placaTXT.setPreferredSize(new Dimension(310, 26));
        placaTXT.setMaximumSize(new Dimension(380, 26));
        placaTXT.setBackground(Color.decode("#DBF5F0")); // Fondo diferente para JTextField
        placaTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelIzquierdo.add(placaTXT, gridConstraints);

        gridConstraints.gridy++;
        JButton generarFacturaBTN = new JButton("Generar");
        generarFacturaBTN.setPreferredSize(new Dimension(310, 25));
        generarFacturaBTN.setBackground(Color.decode("#37BEB0"));
        generarFacturaBTN.setForeground(Color.white);
        generarFacturaBTN.setBorder(BorderFactory.createLineBorder(Color.black));
        panelIzquierdo.add(generarFacturaBTN, gridConstraints);

        gridConstraints.gridy++;
        gridConstraints.gridwidth = 2;

        // Subtítulo del panel izquierdo
        JLabel subtitulo2 = new JLabel("Registrar Pago");
        subtitulo2.setFont(new Font("ARIAL", Font.BOLD, 28));
        subtitulo2.setForeground(Color.decode("#0C6170"));
        subtitulo2.setHorizontalAlignment(SwingConstants.CENTER);
        panelIzquierdo.add(subtitulo2, gridConstraints);

        gridConstraints.gridwidth = 1;
        gridConstraints.gridy++;

        // Campo de texto para "Placa" en registrar pago
        JLabel usuarioPlacaPago = new JLabel("Placa");
        usuarioPlacaPago.setForeground(Color.decode("#37BEB0"));
        usuarioPlacaPago.setFont(new Font("ARIAL", Font.BOLD, 12));
        panelIzquierdo.add(usuarioPlacaPago, gridConstraints);

        gridConstraints.gridy++;
        JTextField placaTXTPago = new JTextField();
        placaTXTPago.setPreferredSize(new Dimension(310, 26));
        placaTXTPago.setMaximumSize(new Dimension(380, 26));
        placaTXTPago.setBackground(Color.decode("#DBF5F0")); // Fondo diferente para JTextField
        placaTXTPago.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelIzquierdo.add(placaTXTPago, gridConstraints);

        gridConstraints.gridy++;
        JButton registrarPago = new JButton("Registrar");
        registrarPago.setPreferredSize(new Dimension(310, 25));
        registrarPago.setBackground(Color.decode("#37BEB0"));
        registrarPago.setForeground(Color.white);
        registrarPago.setBorder(BorderFactory.createLineBorder(Color.black));
        panelIzquierdo.add(registrarPago, gridConstraints);

        mainPanel.add(panelIzquierdo);

        //-----------------------------------------

        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.setBackground(Color.white); // Fondo blanco para el panel derecho

        // Contenedor con márgenes para el área de texto
        JPanel outputContainer = new JPanel(new BorderLayout());
        outputContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Márgenes
        outputContainer.setBackground(Color.white);

        // Área de texto para mostrar resultados
        JTextArea outputField = new JTextArea(5, 30);
        outputField.setBorder(BorderFactory.createLineBorder(Color.black));
        outputField.setBackground(Color.decode("#DBF5F0")); // Fondo diferente para JTextArea

        JScrollPane scrollPane = new JScrollPane(outputField);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        outputContainer.add(scrollPane, BorderLayout.CENTER);
        panelDerecho.add(outputContainer, BorderLayout.CENTER);

        mainPanel.add(panelDerecho);
        this.add(mainPanel, BorderLayout.CENTER);

        generarFacturaBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Factura factura = new Factura();
                String Placa = placaTXT.getText();
                outputField.setText(factura.generarFactura(Placa));
            }
        });

        registrarPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Placa = placaTXTPago.getText();

                Factura factura = new Factura();
                outputField.setText(factura.registrarPago(Placa));
            }
        });
    }
}
