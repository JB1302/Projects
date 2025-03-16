package Frontend.CoreApp.Funciones;

import Backend.modelo.Notificacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notificaciones extends JPanel {

    private JPanel MainPanel;

    public Notificaciones(){

        setLayout(new BorderLayout());

        MainPanel = new JPanel();
        MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));
        MainPanel.setBackground(Color.WHITE);

        MainPanel.add(Box.createVerticalGlue());

        JTextArea outputField = new JTextArea();
        outputField.setPreferredSize(new Dimension(350,150));
        outputField.setMaximumSize(new Dimension(350,150));
        outputField.setBackground(Color.decode("#DBF5F0"));
        outputField.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        outputField.setAlignmentX(Component.CENTER_ALIGNMENT);
        MainPanel.add(outputField);

        //Espaciado
        MainPanel.add(Box.createRigidArea(new Dimension(0,35)));

        JPanel buttonPannel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPannel.setBackground(Color.white);

        JButton submittButton = new JButton();
        submittButton.setText("Enviar Notificaciones");
        submittButton.setPreferredSize(new Dimension(200,28));
        submittButton.setMaximumSize(new Dimension(200,28));
        submittButton.setBackground(Color.decode("#37BEB0"));
        submittButton.setForeground(Color.white);
        submittButton.setBorder(BorderFactory.createLineBorder(Color.black));

        buttonPannel.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonPannel.add(submittButton);
        MainPanel.add(buttonPannel);

        MainPanel.add(Box.createVerticalGlue());

        //Agregar al panel principal
        this.add(MainPanel, BorderLayout.CENTER);

        submittButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Notificacion notificacion = new Notificacion();
                String mensaje = notificacion.enviarNotificacionesOrdenesAbiertas();
                outputField.setText(mensaje);
            }
        });
    }
}