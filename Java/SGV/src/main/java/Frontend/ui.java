package Frontend;

import Backend.controlador.*;
import Backend.modelo.*;
import Backend.modelo.Inventario.Pieza;
import Backend.modelo.Usuario.*;
import Backend.modelo.Vehiculo.OrdenReparacion;
import Backend.servicio.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainWindow extends JFrame {
    private JTextArea terminalArea;
    private JPanel currentPanel;

    private JTextField emailField;
    private JPasswordField passwordField;

    private UsuarioController usuarioController;
    private VehiculoController vehiculoController;
    private ReparacionController reparacionController;
    private Inventario inventario;

    public MainWindow() {
        initComponents();
        setupMainFrame();
        setupMenu();
        redirectSystemOutput();
        setVisible(true);
    }

    private void initComponents() {
        usuarioController = new UsuarioController();
        vehiculoController = new VehiculoController();
        inventario = new Inventario();
        reparacionController = new ReparacionController();
    }

    private void setupMainFrame() {
        setTitle("Sistema Taller Mecánico");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        terminalArea = new JTextArea();
        terminalArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(terminalArea);
        add(scrollPane, BorderLayout.SOUTH);
    }

    private void setupMenu() {
        JMenuBar menuBar = new JMenuBar();
        String[] menus = {"Usuarios", "Vehículos", "Inventario", "Reparaciones", "Citas", "Notificaciones", "Facturas"};

        for(String menuName : menus) {
            JMenu menu = new JMenu(menuName);
            menu.addActionListener(e -> showPanel(menuName));
            menuBar.add(menu);
        }
        setJMenuBar(menuBar);
    }

    private void showPanel(String panelName) {
        if(currentPanel != null) {
            remove(currentPanel);
        }

        switch(panelName) {
            case "Usuarios":
                currentPanel = createUsuarioPanel();
                break;
            case "Vehículos":
                currentPanel = createVehiculoPanel();
                break;
            case "Inventario":
                currentPanel = createInventarioPanel();
                break;
            case "Reparaciones":
                currentPanel = createReparacionPanel();
                break;
            case "Citas":
                currentPanel = createCitasPanel();
                break;
            case "Notificaciones":
                currentPanel = createNotificacionesPanel();
                break;
            case "Facturas":
                currentPanel = createFacturasPanel();
                break;
        }

        add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    // PANEL DE USUARIOS
    private JPanel createUsuarioPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2));

        JTextField nombreField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();

        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Contraseña:"));
        panel.add(passwordField);

        JButton btnCrearCliente = new JButton("Crear Cliente");
        btnCrearCliente.addActionListener(e -> {
            Cliente cliente = new Cliente(
                    nombreField.getText(),
                    emailField.getText(),
                    new String(passwordField.getPassword())
            );
            new UsuarioController(cliente).insertarObjeto();
            System.out.println("Cliente creado: " + cliente.getNombre());
        });

        JButton btnLoginMecanico = new JButton("Iniciar Sesión Mecánico");
        btnLoginMecanico.addActionListener(e -> {
            Mecanico mecanico = new Mecanico();
            mecanico.iniciarSesion(
                    emailField.getText(),
                    new String(passwordField.getPassword())
            );
            System.out.println("Mecánico logueado: " + mecanico.getNombre());
        });

        panel.add(btnCrearCliente);
        panel.add(btnLoginMecanico);
        return panel;
    }

    // PANEL DE VEHÍCULOS
    private JPanel createVehiculoPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));

        JTextField placaField = new JTextField();
        JTextField modeloField = new JTextField();
        JTextField añoField = new JTextField();
        JTextField propietarioField = new JTextField();
        JTextField notasField = new JTextField();

        panel.add(new JLabel("Placa:"));
        panel.add(placaField);
        panel.add(new JLabel("Modelo:"));
        panel.add(modeloField);
        panel.add(new JLabel("Año:"));
        panel.add(añoField);
        panel.add(new JLabel("Propietario:"));
        panel.add(propietarioField);
        panel.add(new JLabel("Notas:"));
        panel.add(notasField);

        JButton btnCrearVehiculo = new JButton("Crear Vehículo");
        btnCrearVehiculo.addActionListener(e -> {
            try {
                Vehiculo vehiculo = new Vehiculo(
                        placaField.getText(),
                        modeloField.getText(),
                        Integer.parseInt(añoField.getText()),
                        propietarioField.getText(),
                        notasField.getText()
                );
                vehiculoController.insertarObjeto(vehiculo);
                System.out.println("Vehículo creado: " + vehiculo.getPlaca());
            } catch (NumberFormatException ex) {
                System.err.println("Error en formato de año!");
            }
        });

        panel.add(btnCrearVehiculo);
        return panel;
    }

    // PANEL DE INVENTARIO
    private JPanel createInventarioPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        JTextField nombreField = new JTextField();
        JTextField descripcionField = new JTextField();
        JTextField cantidadField = new JTextField();
        JTextField costoField = new JTextField();

        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Descripción:"));
        panel.add(descripcionField);
        panel.add(new JLabel("Cantidad:"));
        panel.add(cantidadField);
        panel.add(new JLabel("Costo:"));
        panel.add(costoField);

        JButton btnAgregarPieza = new JButton("Agregar Pieza");
        btnAgregarPieza.addActionListener(e -> {
            try {
                Pieza pieza = new Pieza(
                        nombreField.getText(),
                        descripcionField.getText(),
                        Integer.parseInt(cantidadField.getText()),
                        Double.parseDouble(costoField.getText())
                );
                pieza.insertarObjeto();
                System.out.println("Pieza agregada: " + pieza.getNombre());
            } catch (NumberFormatException ex) {
                System.err.println("Error en formato numérico!");
            }
        });

        panel.add(btnAgregarPieza);
        return panel;
    }

    // PANEL DE REPARACIONES
    private JPanel createReparacionPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2));

        JTextField placaRepField = new JTextField();
        JTextField propietarioRepField = new JTextField();
        JTextField descripcionField = new JTextField();
        JTextField horasField = new JTextField();

        panel.add(new JLabel("Placa Vehículo:"));
        panel.add(placaRepField);
        panel.add(new JLabel("Propietario:"));
        panel.add(propietarioRepField);
        panel.add(new JLabel("Descripción Problema:"));
        panel.add(descripcionField);
        panel.add(new JLabel("Horas Estimadas:"));
        panel.add(horasField);

        JButton btnCrearReparacion = new JButton("Crear Orden Reparación");
        btnCrearReparacion.addActionListener(e -> {
            try {
                LocalDateTime fechaActual = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String fechaFormateada = fechaActual.format(formatter);

                OrdenReparacion orden = new OrdenReparacion(
                        placaRepField.getText(),
                        propietarioRepField.getText(),
                        descripcionField.getText(),
                        fechaFormateada,
                        Integer.parseInt(horasField.getText())
                );

                new ReparacionController(orden).insertarObjeto();
                System.out.println("Orden creada: " + orden.getPlaca());

            } catch (NumberFormatException ex) {
                System.err.println("Error en formato de horas!");
            }
        });

        JButton btnActualizarEstado = new JButton("Actualizar Estado");
        btnActualizarEstado.addActionListener(e -> {
            JComboBox<ReparacionController.estado> estadoCombo =
                    new JComboBox<>(ReparacionController.estado.values());

            int option = JOptionPane.showConfirmDialog(
                    this,
                    estadoCombo,
                    "Seleccionar Estado",
                    JOptionPane.OK_CANCEL_OPTION
            );

            if(option == JOptionPane.OK_OPTION) {
                reparacionController.actualizarEstado(
                        placaRepField.getText(),
                        (ReparacionController.estado) estadoCombo.getSelectedItem()
                );
                System.out.println("Estado actualizado para: " + placaRepField.getText());
            }
        });

        panel.add(btnCrearReparacion);
        panel.add(btnActualizarEstado);
        return panel;
    }

    // PANEL DE CITAS
    private JPanel createCitasPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));

        JTextField clienteField = new JTextField();
        JTextField placaCitaField = new JTextField();
        JTextField fechaField = new JTextField();
        JTextField horaField = new JTextField();

        panel.add(new JLabel("Cliente:"));
        panel.add(clienteField);
        panel.add(new JLabel("Placa Vehículo:"));
        panel.add(placaCitaField);
        panel.add(new JLabel("Fecha (dd-MM-yyyy):"));
        panel.add(fechaField);
        panel.add(new JLabel("Hora:"));
        panel.add(horaField);

        JButton btnCrearCita = new JButton("Crear Cita");
        btnCrearCita.addActionListener(e -> {
            try {
                String fechaConvertida = String.valueOf(
                        new Cita().convertirStringADate(fechaField.getText())
                );

                Cita cita = new Cita(
                        clienteField.getText(),
                        placaCitaField.getText(),
                        fechaConvertida,
                        horaField.getText()
                );

                cita.insertarObjeto();
                System.out.println("Cita creada para: " + clienteField.getText());

            } catch (Exception ex) {
                System.err.println("Error en formato de fecha!");
            }
        });

        panel.add(btnCrearCita);
        return panel;
    }

    // PANEL DE FACTURAS
    private JPanel createFacturasPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2));

        JTextField placaFacturaField = new JTextField();
        panel.add(new JLabel("Placa Vehículo:"));
        panel.add(placaFacturaField);

        JButton btnGenerarFactura = new JButton("Generar Factura");
        btnGenerarFactura.addActionListener(e -> {
            new Factura().generarFactura(placaFacturaField.getText());
            System.out.println("Factura generada para: " + placaFacturaField.getText());
        });

        JButton btnRegistrarPago = new JButton("Registrar Pago");
        btnRegistrarPago.addActionListener(e -> {
            new Factura().registrarPago(placaFacturaField.getText());
            System.out.println("Pago registrado para: " + placaFacturaField.getText());
        });

        panel.add(btnGenerarFactura);
        panel.add(btnRegistrarPago);
        return panel;
    }

    // PANEL DE NOTIFICACIONES
    private JPanel createNotificacionesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JButton btnEnviarNotificaciones = new JButton("Enviar Notificaciones Pendientes");
        btnEnviarNotificaciones.addActionListener(e -> {
            new Notificacion().enviarNotificacionesOrdenesAbiertas();
            System.out.println("Notificaciones enviadas");
        });
        panel.add(btnEnviarNotificaciones);
        return panel;
    }

    private void redirectSystemOutput() {
        PrintStream printStream = new PrintStream(new CustomOutputStream(terminalArea));
        System.setOut(printStream);
        System.setErr(printStream);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainWindow());
    }

    class CustomOutputStream extends java.io.OutputStream {
        private JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) {
            textArea.append(String.valueOf((char) b));
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }
}