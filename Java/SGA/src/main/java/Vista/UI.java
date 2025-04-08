package Vista;

import Controlador.CRUDcontroller;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class UI {
    private JComboBox<String> GaleriaComboBox;
    private JTextField ValoracionTXT;
    private JComboBox<String> EstiloComboBox;
    private JTextField EdadTXT;
    private JTextField nombreTXT;
    private JButton agregarButton;
    private JButton limpiarButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private JButton destacadoButton; // Nuevo botón Destacado
    private JTable table1;
    private JPanel MainPanel;
    private JLabel Titulo;
    private JPanel Inputs;
    private JLabel NombreTXT;
    private JLabel Galeria;
    private JLabel Edad;
    private JLabel Valoracion;
    private JLabel Estilo;
    private JButton obraDesButton;

    private CRUDcontroller controlador;

    public UI() {
        controlador = new CRUDcontroller();

        MainPanel = new JPanel();
        MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));
        MainPanel.setBackground(new Color(240, 234, 220));
        MainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Titulo = new JLabel("Sistema de Gestión de Artistas");
        Titulo.setFont(new Font("Serif", Font.BOLD, 28));
        Titulo.setForeground(new Color(39, 55, 27));
        Titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        MainPanel.add(Titulo);
        MainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        Inputs = new JPanel();
        Inputs.setLayout(new GridLayout(3, 4, 10, 10));
        Inputs.setBackground(new Color(240, 234, 220));
        Inputs.setMaximumSize(new Dimension(450, 150));

        NombreTXT = new JLabel("Nombre");
        NombreTXT.setFont(new Font("SansSerif", Font.PLAIN, 14));
        nombreTXT = new JTextField();

        Galeria = new JLabel("Galeria");
        Galeria.setFont(new Font("SansSerif", Font.PLAIN, 14));
        GaleriaComboBox = new JComboBox<>();
        GaleriaComboBox.setBackground(new Color(204, 232, 182));

        Edad = new JLabel("Edad");
        Edad.setFont(new Font("SansSerif", Font.PLAIN, 14));
        EdadTXT = new JTextField();

        Valoracion = new JLabel("Valoracion");
        Valoracion.setFont(new Font("SansSerif", Font.PLAIN, 14));
        ValoracionTXT = new JTextField();

        Estilo = new JLabel("Estilo");
        Estilo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        EstiloComboBox = new JComboBox<>();
        EstiloComboBox.setBackground(new Color(204, 232, 182));

        Inputs.add(NombreTXT);
        Inputs.add(nombreTXT);
        Inputs.add(Galeria);
        Inputs.add(GaleriaComboBox);
        Inputs.add(Edad);
        Inputs.add(EdadTXT);
        Inputs.add(Valoracion);
        Inputs.add(ValoracionTXT);
        Inputs.add(Estilo);
        Inputs.add(EstiloComboBox);

        MainPanel.add(Inputs);
        MainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new GridLayout(1, 5, 10, 0));
        botonesPanel.setBackground(new Color(240, 234, 220));
        botonesPanel.setMaximumSize(new Dimension(800, 40));

        agregarButton = createStyledButton("Agregar");
        actualizarButton = createStyledButton("Actualizar");
        eliminarButton = createStyledButton("Eliminar");
        limpiarButton = createStyledButton("Limpiar");
        destacadoButton = createStyledButton("Destacado");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CRUDcontroller cruDcontroller = new CRUDcontroller();

                String nombre = nombreTXT.getText();

                if (!nombre.isEmpty() ){

                    String estilo = (String) EstiloComboBox.getSelectedItem();
                    Integer edad = Integer.valueOf(EdadTXT.getText());
                    String galeria = (String) GaleriaComboBox.getSelectedItem();
                    double valoracion = Double.parseDouble(ValoracionTXT.getText());

                    cruDcontroller.agregarArtista(nombre, estilo, edad, galeria, valoracion);
                    cargarDatosTabla();
                }else{
                    JOptionPane.showMessageDialog(null,"Se require Nombre, Estilo, Edad, Galeria y valoracion");
                }
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CRUDcontroller cruDcontroller = new CRUDcontroller();

                String nombre = nombreTXT.getText();

                if (!nombre.isEmpty()) {
                    String estilo = (String) EstiloComboBox.getSelectedItem();
                    Integer edad = Integer.valueOf(EdadTXT.getText());
                    String galeria = (String) GaleriaComboBox.getSelectedItem();
                    double valoracion = Double.parseDouble(ValoracionTXT.getText());

                    cruDcontroller.actualizarArtista(nombre, estilo, edad, galeria, valoracion);
                    cargarDatosTabla();
                }else{
                    JOptionPane.showMessageDialog(null,"Se require Nombre, Estilo, Edad, Galeria y valoracion");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CRUDcontroller cruDcontroller = new CRUDcontroller();
                cruDcontroller.eliminarArtista(nombreTXT.getText());
                cargarDatosTabla();
            }
        });

        limpiarButton.addActionListener(e -> limpiarCampos());

        destacadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             /*   obraDestacada obraDestacada = new obraDestacada();
                ventanaObra.setVisible(True)
                MainPanel.setVisible();*/
            }
        });


        destacadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(MainPanel,
                        "Artista destacado correctamente",
                        "Destacado", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        botonesPanel.add(agregarButton);
        botonesPanel.add(actualizarButton);
        botonesPanel.add(eliminarButton);
        botonesPanel.add(limpiarButton);
        botonesPanel.add(destacadoButton);

        MainPanel.add(botonesPanel);
        MainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        table1 = new JTable();
        table1.setFillsViewportHeight(true);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table1.getTableHeader().setBackground(Color.decode("#1A3315"));
        table1.getTableHeader().setForeground(Color.black);

        JScrollPane scrollPane = new JScrollPane(table1);
        scrollPane.setPreferredSize(new Dimension(800, 300));

        MainPanel.add(scrollPane);

        cargarDatosTabla();

        String[] galerias = {"Galería Nacional", "Galería Moderna", "Museo de Arte", "Centro de Arte", "Galería Contemporánea"};
        for (String galeria : galerias) {
            GaleriaComboBox.addItem(galeria);
        }

        String[] estilos = {"Impresionismo", "Surrealismo", "Cubismo", "Modernismo", "Abstracto"};
        for (String estilo : estilos) {
            EstiloComboBox.addItem(estilo);
        }
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(39, 55, 27));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        return button;
    }

    private void limpiarCampos() {
        nombreTXT.setText("");
        EdadTXT.setText("");
        ValoracionTXT.setText("");
        GaleriaComboBox.setSelectedIndex(0);
        EstiloComboBox.setSelectedIndex(0);
    }

    private void cargarDatosTabla() {
        try {
            DefaultTableModel modelo = controlador.mostrarArtista();
            table1.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(MainPanel,
                    "Error al cargar los datos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Sistema de Gestión de Artistas");
            UI ui = new UI();
            frame.setContentPane(ui.getMainPanel());


            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {

                    frame.setVisible(false);

                    SwingUtilities.invokeLater(() -> {
                        frame.setVisible(true);
                    });
                }
            });

            frame.setSize(850, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}