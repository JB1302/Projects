package Frontend.CoreApp.Funciones;

import javax.swing.*;
import java.awt.*;

public class GestionCitas extends JPanel {

    JPanel MainPanel;

    public GestionCitas(){
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
        gbc.gridy++;  // Incrementar para el siguiente componente

        JPanel fieldsIzquierdos = new JPanel();
        fieldsIzquierdos.setLayout(new GridBagLayout());
        GridBagConstraints fieldsGbc2 = new GridBagConstraints();
        fieldsGbc2.insets = new Insets(2, 2, 2, 2); // Márgenes internos reducidos
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
        fieldsGbc2.gridy = 4; // Ajuste de valor de "gridy" para reducir el espacio
        fieldsGbc2.gridwidth = 2; // Para que el botón ocupe el ancho de los dos campos anteriores
        JButton crearReparacion = new JButton("Crear Cita");
        crearReparacion.setPreferredSize(new Dimension(310, 25));
        crearReparacion.setMaximumSize(new Dimension(310, 25));
        crearReparacion.setBackground(Color.decode("#37BEB0"));
        crearReparacion.setForeground(Color.white);
        crearReparacion.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsIzquierdos.add(crearReparacion, fieldsGbc2);

        panelIzquierdo.add(fieldsIzquierdos, gbc);

        gbc.gridy++;  // Incrementar para el siguiente subtítulo

        JLabel subtituloIzquierdo2 = new JLabel("Revisar Inventario");
        subtituloIzquierdo2.setFont(new Font("ARIAL", Font.BOLD, 28));
        subtituloIzquierdo2.setForeground(Color.decode("#0C6170"));
        subtituloIzquierdo2.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridwidth = 4;
        panelIzquierdo.add(subtituloIzquierdo2, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;  // Incrementar para el siguiente componente

        JPanel fieldsInventario = new JPanel();
        fieldsInventario.setLayout(new GridBagLayout());
        GridBagConstraints fieldsGbc3 = new GridBagConstraints();
        fieldsGbc3.insets = new Insets(2, 2, 2, 2); // Márgenes internos reducidos
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
        fieldsGbc3.gridy = 2; // Ajuste de valor de "gridy" para reducir el espacio
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

        MainPanel.add(panelIzquierdo);
        MainPanel.add(panelDerecho);

        this.setLayout(new BorderLayout());
        this.add(MainPanel, BorderLayout.CENTER);
    }
}