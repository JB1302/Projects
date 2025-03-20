package Frontend.CoreApp.Funciones;

import Backend.modelo.Cita;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        subtituloIzquierdo.setBackground(Color.WHITE);
        gbc.gridwidth = 4;
        panelIzquierdo.add(subtituloIzquierdo, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;  // Incrementar para el siguiente componente

        JPanel fieldsIzquierdos = new JPanel();
        fieldsIzquierdos.setLayout(new GridBagLayout());
        fieldsIzquierdos.setBackground(Color.WHITE);
        GridBagConstraints fieldsGbc2 = new GridBagConstraints();
        fieldsGbc2.insets = new Insets(2, 2, 2, 2); // Márgenes internos reducidos
        fieldsGbc2.anchor = GridBagConstraints.WEST;

        // Conjunto 2
        fieldsGbc2.gridx = 0;
        fieldsGbc2.gridy = 0;
        JLabel clienteLBL = new JLabel("Cliente");
        clienteLBL.setForeground(Color.decode("#37BEB0"));
        clienteLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        fieldsIzquierdos.add(clienteLBL, fieldsGbc2);

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
        JButton crearCitaBTN = new JButton("Crear Cita");
        crearCitaBTN.setPreferredSize(new Dimension(310, 25));
        crearCitaBTN.setMaximumSize(new Dimension(310, 25));
        crearCitaBTN.setBackground(Color.decode("#37BEB0"));
        crearCitaBTN.setForeground(Color.white);
        crearCitaBTN.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldsIzquierdos.add(crearCitaBTN, fieldsGbc2);

        panelIzquierdo.add(fieldsIzquierdos, gbc);


        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new GridBagLayout());
        panelDerecho.setBackground(Color.white);

        GridBagConstraints gbcDerecho = new GridBagConstraints();
        gbcDerecho.insets = new Insets(5, 5, 5, 5);
        gbcDerecho.gridx = 0;
        gbcDerecho.gridy = 0;
        gbcDerecho.anchor = GridBagConstraints.CENTER;
        gbcDerecho.fill = GridBagConstraints.HORIZONTAL;

        JLabel reprogramarCitaSubtitulo = new JLabel("Reprogramar Cita");
        reprogramarCitaSubtitulo.setFont(new Font("ARIAL", Font.BOLD, 28));
        reprogramarCitaSubtitulo.setForeground(Color.decode("#0C6170"));
        reprogramarCitaSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbcDerecho.gridwidth = 4;
        panelDerecho.add(reprogramarCitaSubtitulo, gbcDerecho);

        GridBagConstraints fieldsGbcDerecho = new GridBagConstraints();
        fieldsGbcDerecho.insets = new Insets(2, 2, 2, 2);
        fieldsGbcDerecho.anchor = GridBagConstraints.WEST;

        fieldsGbcDerecho.gridx = 0;
        fieldsGbcDerecho.gridy = 1;
        JLabel clienteLBLDerechoSuperior = new JLabel("Cliente");
        clienteLBLDerechoSuperior.setForeground(Color.decode("#37BEB0"));
        clienteLBLDerechoSuperior.setFont(new Font("ARIAL", Font.BOLD, 12));
        panelDerecho.add(clienteLBLDerechoSuperior, fieldsGbcDerecho);

        fieldsGbcDerecho.gridy = 2;
        fieldsGbcDerecho.gridwidth = 4; // Para que el JTextField ocupe todo el ancho del contenedor
        JTextField clienteTXTDerechoSuperior = new JTextField();
        clienteTXTDerechoSuperior.setPreferredSize(new Dimension(310, 26));
        clienteTXTDerechoSuperior.setMaximumSize(new Dimension(310, 26));
        clienteTXTDerechoSuperior.setBackground(Color.decode("#DBF5F0"));
        clienteTXTDerechoSuperior.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelDerecho.add(clienteTXTDerechoSuperior, fieldsGbcDerecho);

        fieldsGbcDerecho.gridx = 0;
        fieldsGbcDerecho.gridy = 3;
        fieldsGbcDerecho.gridwidth = 1;
        JLabel nuevaFechaLBL = new JLabel("Nueva Fecha");
        nuevaFechaLBL.setForeground(Color.decode("#37BEB0"));
        nuevaFechaLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        panelDerecho.add(nuevaFechaLBL, fieldsGbcDerecho);

        fieldsGbcDerecho.gridy = 4;
        JTextField nuevaFechaTXT = new JTextField();
        nuevaFechaTXT.setPreferredSize(new Dimension(150, 26));
        nuevaFechaTXT.setMaximumSize(new Dimension(150, 26));
        nuevaFechaTXT.setBackground(Color.decode("#DBF5F0"));
        nuevaFechaTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelDerecho.add(nuevaFechaTXT, fieldsGbcDerecho);

        fieldsGbcDerecho.gridx = 1;
        fieldsGbcDerecho.gridy = 3;
        JLabel nuevaHoraLBL = new JLabel("Nueva Hora");
        nuevaHoraLBL.setForeground(Color.decode("#37BEB0"));
        nuevaHoraLBL.setFont(new Font("ARIAL", Font.BOLD, 12));
        panelDerecho.add(nuevaHoraLBL, fieldsGbcDerecho);

        fieldsGbcDerecho.gridy = 4;
        JTextField nuevaHoraReprogramarTXT = new JTextField();
        nuevaHoraReprogramarTXT.setPreferredSize(new Dimension(150, 26));
        nuevaHoraReprogramarTXT.setMaximumSize(new Dimension(150, 26));
        nuevaHoraReprogramarTXT.setBackground(Color.decode("#DBF5F0"));
        nuevaHoraReprogramarTXT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelDerecho.add(nuevaHoraReprogramarTXT, fieldsGbcDerecho);

        fieldsGbcDerecho.gridx = 0;
        fieldsGbcDerecho.gridy = 5;
        fieldsGbcDerecho.gridwidth = 2; // Para que el botón ocupe el ancho de los dos campos anteriores
        JButton reprogramarBTN = new JButton("Reprogramar");
        reprogramarBTN.setPreferredSize(new Dimension(310, 25));
        reprogramarBTN.setMaximumSize(new Dimension(310, 25));
        reprogramarBTN.setBackground(Color.decode("#37BEB0"));
        reprogramarBTN.setForeground(Color.white);
        reprogramarBTN.setBorder(BorderFactory.createLineBorder(Color.black));
        panelDerecho.add(reprogramarBTN, fieldsGbcDerecho);

        gbcDerecho.gridy = 6;
        gbcDerecho.gridwidth = 4;
        JLabel subtituloBuscar = new JLabel("Cancelar Cita");
        subtituloBuscar.setFont(new Font("ARIAL", Font.BOLD, 28));
        subtituloBuscar.setForeground(Color.decode("#0C6170"));
        subtituloBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        panelDerecho.add(subtituloBuscar, gbcDerecho);

        GridBagConstraints fieldsGbcBuscarDerecho = new GridBagConstraints();
        fieldsGbcBuscarDerecho.insets = new Insets(2, 2, 2, 2);
        fieldsGbcBuscarDerecho.anchor = GridBagConstraints.WEST;

        fieldsGbcBuscarDerecho.gridx = 0;
        fieldsGbcBuscarDerecho.gridy = 7;
        JLabel clienteLBLDerecho = new JLabel("Cliente");
        clienteLBLDerecho.setForeground(Color.decode("#37BEB0"));
        clienteLBLDerecho.setFont(new Font("ARIAL", Font.BOLD, 12));
        panelDerecho.add(clienteLBLDerecho, fieldsGbcBuscarDerecho);

        fieldsGbcBuscarDerecho.gridy = 8;
        fieldsGbcBuscarDerecho.gridwidth = 4; // Para que el JTextField ocupe todo el ancho del contenedor
        JTextField clienteTXTDerecho = new JTextField();
        clienteTXTDerecho.setPreferredSize(new Dimension(310, 26));
        clienteTXTDerecho.setMaximumSize(new Dimension(310, 26));
        clienteTXTDerecho.setBackground(Color.decode("#DBF5F0"));
        clienteTXTDerecho.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelDerecho.add(clienteTXTDerecho, fieldsGbcBuscarDerecho);

        fieldsGbcBuscarDerecho.gridx = 0;
        fieldsGbcBuscarDerecho.gridy = 9;
        fieldsGbcBuscarDerecho.gridwidth = 2; // Para que el botón ocupe el ancho de los dos campos anteriores
        JButton cancelarDerechoBTN = new JButton("Cancelar");
        cancelarDerechoBTN.setPreferredSize(new Dimension(310, 25));
        cancelarDerechoBTN.setMaximumSize(new Dimension(310, 25));
        cancelarDerechoBTN.setBackground(Color.decode("#37BEB0"));
        cancelarDerechoBTN.setForeground(Color.white);
        cancelarDerechoBTN.setBorder(BorderFactory.createLineBorder(Color.black));
        panelDerecho.add(cancelarDerechoBTN, fieldsGbcBuscarDerecho);

        MainPanel.add(panelIzquierdo);
        MainPanel.add(panelDerecho);

        this.setLayout(new BorderLayout());
        this.add(MainPanel, BorderLayout.CENTER);

        crearCitaBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cliente = clienteTXT.getText();
                    String placa = placaTXT.getText();
                    String fecha = fechaTXT.getText();
                    String hora = horaTXT.getText();


                    Cita cita = new Cita(cliente,placa,fecha,hora);
                    cita.insertarObjeto();

                    JOptionPane.showMessageDialog(null,"Cita creada");


                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Error al crear Cita");

                }

            }
        });

        reprogramarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cliente = clienteTXTDerechoSuperior.getText();
                    String nuevaFecha = nuevaFechaTXT.getText();
                    String nuevaHora = nuevaHoraReprogramarTXT.getText();

                    Cita cita = new Cita();
                    cita.reprogramarCita(cliente,nuevaFecha, nuevaHora);

                    JOptionPane.showMessageDialog(null,"Cita Reprogramada");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Error al reprogramar cita");

                }

            }
        });

        cancelarDerechoBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                String cliente = clienteTXTDerecho.getText();

                Cita cita = new Cita();
                cita.cancelarCita(cliente);

                JOptionPane.showMessageDialog(null,"Cita cancelada");

            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,"Error al reprogramar cita");

            }

            }
        });
    }
}