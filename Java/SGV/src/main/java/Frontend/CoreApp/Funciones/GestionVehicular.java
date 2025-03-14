package Frontend.CoreApp.Funciones;

import javax.swing.*;
import java.awt.*;


public class GestionVehicular extends JPanel {

    JPanel MainPanel;

    public GestionVehicular(){
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
    JLabel placaLabel2 = new JLabel("Placa");
        placaLabel2.setForeground(Color.decode("#37BEB0"));
        placaLabel2.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(placaLabel2, fieldsGbc2);

    fieldsGbc2.gridy = 1;
    JTextField placaTxt2 = new JTextField();
        placaTxt2.setPreferredSize(new Dimension(150, 26));
        placaTxt2.setMaximumSize(new Dimension(150, 26));
        placaTxt2.setBackground(Color.decode("#DBF5F0"));
        placaTxt2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(placaTxt2, fieldsGbc2);

    fieldsGbc2.gridx = 1;
    fieldsGbc2.gridy = 0;
    JLabel placaLabel3 = new JLabel("Placa");
        placaLabel3.setForeground(Color.decode("#37BEB0"));
        placaLabel3.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(placaLabel3, fieldsGbc2);

    fieldsGbc2.gridy = 1;
    JTextField placaTxt3 = new JTextField();
        placaTxt3.setPreferredSize(new Dimension(150, 26));
        placaTxt3.setMaximumSize(new Dimension(150, 26));
        placaTxt3.setBackground(Color.decode("#DBF5F0"));
        placaTxt3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(placaTxt3, fieldsGbc2);

    fieldsGbc2.gridx = 0;
    fieldsGbc2.gridy = 2;
    JLabel propietarioLabel1 = new JLabel("Propietario");
        propietarioLabel1.setForeground(Color.decode("#37BEB0"));
        propietarioLabel1.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(propietarioLabel1, fieldsGbc2);

    fieldsGbc2.gridy = 3;
    JTextField propietarioTxt1 = new JTextField();
        propietarioTxt1.setPreferredSize(new Dimension(150, 26));
        propietarioTxt1.setMaximumSize(new Dimension(150, 26));
        propietarioTxt1.setBackground(Color.decode("#DBF5F0"));
        propietarioTxt1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(propietarioTxt1, fieldsGbc2);

    fieldsGbc2.gridx = 1;
    fieldsGbc2.gridy = 2;
    JLabel propietarioLabel2 = new JLabel("Propietario");
        propietarioLabel2.setForeground(Color.decode("#37BEB0"));
        propietarioLabel2.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(propietarioLabel2, fieldsGbc2);

    fieldsGbc2.gridy = 3;
    JTextField propietarioTxt2 = new JTextField();
        propietarioTxt2.setPreferredSize(new Dimension(150, 26));
        propietarioTxt2.setMaximumSize(new Dimension(150, 26));
        propietarioTxt2.setBackground(Color.decode("#DBF5F0"));
        propietarioTxt2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldsIzquierdos.add(propietarioTxt2, fieldsGbc2);

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
    JButton crearReparacion = new JButton("Registrar Nuevo");
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