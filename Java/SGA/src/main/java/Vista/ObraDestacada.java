package Vista;

import Modelo.ClienteSocket;

import javax.swing.*;
import java.awt.*;

public class ObraDestacada {

    public void mostrarObraDestacada(int idArtista) {
        String obraDestacada = ClienteSocket.obtenerDestacada(idArtista);

        JFrame ventanaObra = new JFrame("Obra Destacada");
        ventanaObra.setSize(400, 300);
        ventanaObra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Información del Artista");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(tituloLabel);
        panel.add(Box.createVerticalStrut(10));

        JLabel obraLabel = new JLabel("Obra Destacada: " + obraDestacada);
        obraLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(obraLabel);

        ventanaObra.add(panel);
        ventanaObra.setLocationRelativeTo(null);
        ventanaObra.setVisible(true);
    }

    public static void main(String[] args) {
        ObraDestacada vista = new ObraDestacada();
        vista.mostrarObraDestacada(1);
    }
}
