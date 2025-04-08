import Vista.UI;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class main {
    public static void main(String[] args) {

        //Copiar del OS
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Sistema de Gestión de Artistas");
            UI ui = new UI();
            frame.setContentPane(ui.getMainPanel());


            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {

                    frame.setVisible(false);

                    SwingUtilities.invokeLater(() -> {
                        frame.setVisible(true);
                    });
                }
            });


            frame.setSize(700, 525);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}