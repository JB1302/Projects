package Frontend.CoreApp.Funciones;

import javax.swing.*;
import java.awt.*;

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
        JLabel horasLabel = new JLabel("Horas");
        horasLabel.setForeground(Color.decode("#37BEB0"));
        horasLabel.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(horasLabel, fieldsGbc2);

        fieldsGbc2.gridy = 3;
        JTextField horasTXT = new JTextField();
        horasTXT.setPreferredSize(new Dimension(150, 26));
        horasTXT.setMaximumSize(new Dimension(150, 26));
        horasTXT.setBackground(Color.decode("#DBF5F0"));
        horasTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(horasTXT, fieldsGbc2);

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

        MainPanel.add(panelIzquierdo);
        MainPanel.add(panelDerecho);

        this.add(MainPanel, BorderLayout.CENTER);
    }
}