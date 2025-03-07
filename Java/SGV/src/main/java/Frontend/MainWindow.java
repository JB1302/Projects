package Frontend;

import Backend.controlador.*;
import Backend.modelo.Cita;
import Backend.modelo.Factura;
import Backend.modelo.Inventario.Pieza;
import Backend.modelo.Notificacion;
import Backend.modelo.Usuario.Administrador;
import Backend.modelo.Usuario.Cliente;
import Backend.modelo.Usuario.Mecanico;
import Backend.modelo.Usuario.Usuario;
import Backend.modelo.Vehiculo.OrdenReparacion;
import Backend.modelo.Vehiculo.Vehiculo;
import Backend.modelo.Inventario.Inventario;
import Backend.servicio.UsuarioService;
import Backend.controlador.ReparacionController;
import Backend.controlador.ReparacionController.estado;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MainWindow extends JFrame {
    private JTextArea terminalArea;
    private JPanel currentPanel;

    public MainWindow() {
        setupMainFrame();
        setupMenu();
        redirectSystemOutput();
        setVisible(true);
    }

    private void setupMainFrame() {
        setTitle("Sistema Taller Mecánico");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        terminalArea = new JTextArea(8, 80);
        terminalArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(terminalArea);
        add(scrollPane, BorderLayout.SOUTH);
    }

    private void setupMenu() {
        JMenuBar menuBar = new JMenuBar();
        String[] menus = {"Usuarios", "Vehículos", "Inventario", "Reparaciones", "Citas", "Notificaciones", "Facturas"};

        for (String menuName : menus) {
            JMenu menu = new JMenu(menuName);
            menu.addMenuListener(new MenuListener() {
                @Override
                public void menuSelected(MenuEvent e) {
                    showPanel(menuName);
                }
                @Override public void menuDeselected(MenuEvent e) { }
                @Override public void menuCanceled(MenuEvent e) { }
            });
            menuBar.add(menu);
        }
        setJMenuBar(menuBar);
    }

    private void showPanel(String panelName) {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        switch (panelName) {
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
            default:
                currentPanel = new JPanel();
        }
        add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    // ───────────────────────────────────────────────
    // PANEL USUARIOS: Crear usuario, Login/Logout y CRUD
    // ───────────────────────────────────────────────
    private JPanel createUsuarioPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Sección 1: Crear Usuario
        JPanel createUserPanel = new JPanel(new FlowLayout());
        createUserPanel.setBorder(new TitledBorder("Crear Usuario"));
        JTextField nameField = new JTextField(10);
        JTextField emailField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);
        String[] userTypes = {"Cliente", "Mecanico", "Administrador"};
        JComboBox<String> typeCombo = new JComboBox<>(userTypes);
        JButton btnCrearUsuario = new JButton("Crear Usuario");

        createUserPanel.add(new JLabel("Nombre:"));
        createUserPanel.add(nameField);
        createUserPanel.add(new JLabel("Email:"));
        createUserPanel.add(emailField);
        createUserPanel.add(new JLabel("Password:"));
        createUserPanel.add(passwordField);
        createUserPanel.add(new JLabel("Tipo:"));
        createUserPanel.add(typeCombo);
        createUserPanel.add(btnCrearUsuario);
        panel.add(createUserPanel);

        btnCrearUsuario.addActionListener(e -> {
            String nombre = nameField.getText();
            String email = emailField.getText();
            String pass = new String(passwordField.getPassword());
            String tipo = (String) typeCombo.getSelectedItem();
            Usuario usuario = null;
            if (tipo.equals("Cliente")) {
                usuario = new Cliente(nombre, email, pass);
            } else if (tipo.equals("Mecanico")) {
                usuario = new Mecanico(nombre, email, pass);
            } else if (tipo.equals("Administrador")) {
                usuario = new Administrador(nombre, email, pass);
            }
            UsuarioController uc = new UsuarioController(usuario);
            uc.insertarObjeto();
            System.out.println("Usuario creado: " + nombre + " (" + tipo + ")");
        });

        // Sección 2: Iniciar/Cerrar Sesión
        JPanel loginPanel = new JPanel(new FlowLayout());
        loginPanel.setBorder(new TitledBorder("Login / Cerrar Sesión"));
        JTextField loginEmailField = new JTextField(10);
        JPasswordField loginPasswordField = new JPasswordField(10);
        JComboBox<String> loginTypeCombo = new JComboBox<>(userTypes);
        JButton btnLogin = new JButton("Iniciar Sesión");
        JButton btnCerrarSesion = new JButton("Cerrar Sesión");

        loginPanel.add(new JLabel("Email:"));
        loginPanel.add(loginEmailField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(loginPasswordField);
        loginPanel.add(new JLabel("Tipo:"));
        loginPanel.add(loginTypeCombo);
        loginPanel.add(btnLogin);
        loginPanel.add(btnCerrarSesion);
        panel.add(loginPanel);

        btnLogin.addActionListener(e -> {
            String email = loginEmailField.getText();
            String pass = new String(loginPasswordField.getPassword());
            String tipo = (String) loginTypeCombo.getSelectedItem();
            Usuario usuario = null;
            // Se asume que existe un constructor sin parámetros o similar para iniciar sesión.
            if (tipo.equals("Cliente")) {
                usuario = new Cliente("", email, pass);
            } else if (tipo.equals("Mecanico")) {
                usuario = new Mecanico("", email, pass);
            } else if (tipo.equals("Administrador")) {
                usuario = new Administrador("", email, pass);
            }
            if (usuario.iniciarSesion(email, pass)) {
                System.out.println(tipo + " logueado: " + email);
            } else {
                System.err.println("Error en credenciales para " + tipo);
            }
        });

        btnCerrarSesion.addActionListener(e -> {
            String email = loginEmailField.getText();
            String pass = new String(loginPasswordField.getPassword());
            String tipo = (String) loginTypeCombo.getSelectedItem();
            Usuario usuario = null;
            if (tipo.equals("Cliente")) {
                usuario = new Cliente("", email, pass);
            } else if (tipo.equals("Mecanico")) {
                usuario = new Mecanico("", email, pass);
            } else if (tipo.equals("Administrador")) {
                usuario = new Administrador("", email, pass);
            }
            usuario.cerrarSesion();
            System.out.println(tipo + " cerró sesión: " + email);
        });

        // Sección 3: CRUD Usuarios usando UsuarioService
        JPanel crudPanel = new JPanel(new FlowLayout());
        crudPanel.setBorder(new TitledBorder("CRUD Usuarios"));
        JTextField buscarEmailField = new JTextField(10);
        JButton btnBuscar = new JButton("Buscar Cliente");
        JButton btnMostrar = new JButton("Mostrar Clientes");
        JButton btnEliminar = new JButton("Eliminar Cliente");
        JTextField actualizarNameField = new JTextField(10);
        JTextField actualizarEmailField = new JTextField(10);
        JPasswordField actualizarPasswordField = new JPasswordField(10);
        JButton btnActualizar = new JButton("Actualizar Cliente");

        crudPanel.add(new JLabel("Buscar Email:"));
        crudPanel.add(buscarEmailField);
        crudPanel.add(btnBuscar);
        crudPanel.add(btnMostrar);
        crudPanel.add(new JLabel("Actualizar (Nombre, Email, Pass):"));
        crudPanel.add(actualizarNameField);
        crudPanel.add(actualizarEmailField);
        crudPanel.add(actualizarPasswordField);
        crudPanel.add(btnActualizar);
        crudPanel.add(btnEliminar);
        panel.add(crudPanel);

        btnBuscar.addActionListener(e -> {
            String criterio = buscarEmailField.getText();
            UsuarioService us = new UsuarioService();
            us.buscarCliente(criterio);
        });
        btnActualizar.addActionListener(e -> {
            String nombre = actualizarNameField.getText();
            String email = actualizarEmailField.getText();
            String pass = new String(actualizarPasswordField.getPassword());
            Cliente actualizado = new Cliente(nombre, email, pass);
            UsuarioService us = new UsuarioService();
            us.actualizarCliente(actualizado);
            System.out.println("Cliente actualizado: " + nombre);
        });
        btnMostrar.addActionListener(e -> {
            UsuarioService us = new UsuarioService();
            us.mostrarClientes();
        });
        btnEliminar.addActionListener(e -> {
            String email = buscarEmailField.getText();
            UsuarioService us = new UsuarioService();
            us.eliminarCliente(email);
            System.out.println("Cliente eliminado: " + email);
        });

        return panel;
    }

    // ───────────────────────────────────────────────
    // PANEL VEHÍCULOS: Crear, Actualizar y Consultar Historial
    // ───────────────────────────────────────────────
    private JPanel createVehiculoPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Sección: Crear Vehículo
        JPanel createVehPanel = new JPanel(new FlowLayout());
        createVehPanel.setBorder(new TitledBorder("Crear Vehículo"));
        JTextField placaField = new JTextField(8);
        JTextField modeloField = new JTextField(8);
        JTextField añoField = new JTextField(4);
        JTextField propietarioField = new JTextField(8);
        JTextField notasField = new JTextField(8);
        JButton btnCrearVeh = new JButton("Crear Vehículo");

        createVehPanel.add(new JLabel("Placa:"));
        createVehPanel.add(placaField);
        createVehPanel.add(new JLabel("Modelo:"));
        createVehPanel.add(modeloField);
        createVehPanel.add(new JLabel("Año:"));
        createVehPanel.add(añoField);
        createVehPanel.add(new JLabel("Propietario:"));
        createVehPanel.add(propietarioField);
        createVehPanel.add(new JLabel("Notas:"));
        createVehPanel.add(notasField);
        createVehPanel.add(btnCrearVeh);
        panel.add(createVehPanel);

        btnCrearVeh.addActionListener(e -> {
            try {
                Vehiculo vehiculo = new Vehiculo(
                        placaField.getText(),
                        modeloField.getText(),
                        Integer.parseInt(añoField.getText()),
                        propietarioField.getText(),
                        notasField.getText()
                );
                VehiculoController vc = new VehiculoController(vehiculo);
                vc.insertarObjeto();
                System.out.println("Vehículo creado: " + vehiculo.getPlaca());
            } catch (NumberFormatException ex) {
                System.err.println("Error en formato de año");
            }
        });

        // Sección: Actualizar y Consultar Vehículo
        JPanel updatePanel = new JPanel(new FlowLayout());
        updatePanel.setBorder(new TitledBorder("Actualizar / Consultar Vehículo"));
        JTextField placaUpdateField = new JTextField(8);
        JTextField estadoField = new JTextField(8);
        JButton btnActualizarVeh = new JButton("Actualizar Vehículo");
        JButton btnConsultarHistorial = new JButton("Consultar Historial");

        updatePanel.add(new JLabel("Placa:"));
        updatePanel.add(placaUpdateField);
        updatePanel.add(new JLabel("Nuevo Estado:"));
        updatePanel.add(estadoField);
        updatePanel.add(btnActualizarVeh);
        updatePanel.add(btnConsultarHistorial);
        panel.add(updatePanel);

        btnActualizarVeh.addActionListener(e -> {
            VehiculoController vc = new VehiculoController();
            vc.actualizarVehiculo(placaUpdateField.getText(), estadoField.getText());
            System.out.println("Vehículo actualizado: " + placaUpdateField.getText());
        });
        btnConsultarHistorial.addActionListener(e -> {
            VehiculoController vc = new VehiculoController();
            vc.consultarHistorial(placaUpdateField.getText());
        });

        return panel;
    }

    // ───────────────────────────────────────────────
    // PANEL REPARACIONES: Crear orden, Actualizar estado y Asignar mecánico
    // ───────────────────────────────────────────────
    private JPanel createReparacionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Sección: Crear Orden Reparación
        JPanel crearRepPanel = new JPanel(new FlowLayout());
        crearRepPanel.setBorder(new TitledBorder("Crear Orden Reparación"));
        JTextField placaRepField = new JTextField(8);
        JTextField propietarioRepField = new JTextField(8);
        JTextField descripcionField = new JTextField(8);
        JTextField horasField = new JTextField(4);
        JButton btnCrearOrden = new JButton("Crear Orden Reparación");

        crearRepPanel.add(new JLabel("Placa:"));
        crearRepPanel.add(placaRepField);
        crearRepPanel.add(new JLabel("Propietario:"));
        crearRepPanel.add(propietarioRepField);
        crearRepPanel.add(new JLabel("Descripción:"));
        crearRepPanel.add(descripcionField);
        crearRepPanel.add(new JLabel("Horas:"));
        crearRepPanel.add(horasField);
        crearRepPanel.add(btnCrearOrden);
        panel.add(crearRepPanel);

        btnCrearOrden.addActionListener(e -> {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaFormateada = now.format(formatter);
            try {
                OrdenReparacion orden = new OrdenReparacion(
                        placaRepField.getText(),
                        propietarioRepField.getText(),
                        descripcionField.getText(),
                        fechaFormateada,
                        Integer.parseInt(horasField.getText())
                );
                ReparacionController rc = new ReparacionController(orden);
                rc.insertarObjeto();
                System.out.println("Orden de reparación creada para: " + orden.getPlaca());
            } catch (NumberFormatException ex) {
                System.err.println("Error en formato de horas");
            }
        });

        // Sección: Actualizar Estado y Asignar Mecánico
        JPanel updateRepPanel = new JPanel(new FlowLayout());
        updateRepPanel.setBorder(new TitledBorder("Actualizar Reparación"));
        JTextField placaUpdateRep = new JTextField(8);
        JComboBox<estado> estadoCombo = new JComboBox<>(estado.values());
        JTextField mecanicoIdField = new JTextField(4);
        JButton btnActualizarEstado = new JButton("Actualizar Estado");
        JButton btnAsignarMecanico = new JButton("Asignar Mecánico");

        updateRepPanel.add(new JLabel("Placa:"));
        updateRepPanel.add(placaUpdateRep);
        updateRepPanel.add(new JLabel("Estado:"));
        updateRepPanel.add(estadoCombo);
        updateRepPanel.add(btnActualizarEstado);
        updateRepPanel.add(new JLabel("Mecánico ID:"));
        updateRepPanel.add(mecanicoIdField);
        updateRepPanel.add(btnAsignarMecanico);
        panel.add(updateRepPanel);

        btnActualizarEstado.addActionListener(e -> {
            ReparacionController rc = new ReparacionController();
            rc.actualizarEstado(placaUpdateRep.getText(), (estado) estadoCombo.getSelectedItem());
            System.out.println("Estado actualizado para: " + placaUpdateRep.getText());
        });
        btnAsignarMecanico.addActionListener(e -> {
            ReparacionController rc = new ReparacionController();
            try {
                int id = Integer.parseInt(mecanicoIdField.getText());
                rc.asignarMecanico(placaUpdateRep.getText(), id);
                System.out.println("Mecánico asignado para: " + placaUpdateRep.getText());
            } catch (NumberFormatException ex) {
                System.err.println("Error en formato de ID de mecánico");
            }
        });

        return panel;
    }

    // ───────────────────────────────────────────────
    // PANEL CITAS: Crear, Cancelar y Reprogramar Cita
    // ───────────────────────────────────────────────
    private JPanel createCitasPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Sección: Crear Cita
        JPanel crearCitaPanel = new JPanel(new FlowLayout());
        crearCitaPanel.setBorder(new TitledBorder("Crear Cita"));
        JTextField clienteField = new JTextField(8);
        JTextField placaCitaField = new JTextField(8);
        JTextField fechaField = new JTextField(8);
        JTextField horaField = new JTextField(4);
        JButton btnCrearCita = new JButton("Crear Cita");

        crearCitaPanel.add(new JLabel("Cliente:"));
        crearCitaPanel.add(clienteField);
        crearCitaPanel.add(new JLabel("Placa:"));
        crearCitaPanel.add(placaCitaField);
        crearCitaPanel.add(new JLabel("Fecha (dd-MM-yyyy):"));
        crearCitaPanel.add(fechaField);
        crearCitaPanel.add(new JLabel("Hora:"));
        crearCitaPanel.add(horaField);
        crearCitaPanel.add(btnCrearCita);
        panel.add(crearCitaPanel);

        btnCrearCita.addActionListener(e -> {
            try {
                // Suponiendo que convertirStringADate devuelve ya un String en el formato "yyyy-MM-dd"
                String fechaConvertida = Cita.convertirStringADate(fechaField.getText());
                Cita cita = new Cita(
                        clienteField.getText(),
                        placaCitaField.getText(),
                        fechaConvertida,
                        horaField.getText()
                );
                cita.insertarObjeto();
                System.out.println("Cita creada para: " + clienteField.getText());
            } catch (Exception ex) {
                System.err.println("Error en formato de fecha: " + ex.getMessage());
            }
        });



        // Sección: Cancelar y Reprogramar Cita
        JPanel citaModPanel = new JPanel(new FlowLayout());
        citaModPanel.setBorder(new TitledBorder("Modificar Cita"));
        JTextField clienteCitaField = new JTextField(8);
        JTextField nuevaFechaField = new JTextField(8);
        JTextField nuevaHoraField = new JTextField(4);
        JButton btnCancelarCita = new JButton("Cancelar Cita");
        JButton btnReprogramarCita = new JButton("Reprogramar Cita");

        citaModPanel.add(new JLabel("Cliente:"));
        citaModPanel.add(clienteCitaField);
        citaModPanel.add(btnCancelarCita);
        citaModPanel.add(new JLabel("Nueva Fecha (dd-MM-yyyy):"));
        citaModPanel.add(nuevaFechaField);
        citaModPanel.add(new JLabel("Nueva Hora:"));
        citaModPanel.add(nuevaHoraField);
        citaModPanel.add(btnReprogramarCita);
        panel.add(citaModPanel);

        btnCancelarCita.addActionListener(e -> {
            Cita cita = new Cita();
            cita.cancelarCita(clienteCitaField.getText());
            System.out.println("Cita cancelada para: " + clienteCitaField.getText());
        });
        btnReprogramarCita.addActionListener(e -> {
            try {
                String fechaConvertida = Cita.convertirStringADate(nuevaFechaField.getText());
                Cita cita = new Cita();
                cita.reprogramarCita(clienteCitaField.getText(), fechaConvertida, nuevaHoraField.getText());
                System.out.println("Cita reprogramada para: " + clienteCitaField.getText());
            } catch (Exception ex) {
                System.err.println("Error en reprogramar cita: " + ex.getMessage());
            }
        });


        return panel;
    }

    // ───────────────────────────────────────────────
    // PANEL INVENTARIO: Agregar pieza y operaciones varias
    // ───────────────────────────────────────────────
    private JPanel createInventarioPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Sección: Agregar Pieza
        JPanel agregarPiezaPanel = new JPanel(new FlowLayout());
        agregarPiezaPanel.setBorder(new TitledBorder("Agregar Pieza"));
        JTextField piezaNombreField = new JTextField(8);
        JTextField piezaDescField = new JTextField(8);
        JTextField piezaCantidadField = new JTextField(4);
        JTextField piezaCostoField = new JTextField(4);
        JButton btnAgregarPieza = new JButton("Agregar Pieza");

        agregarPiezaPanel.add(new JLabel("Nombre:"));
        agregarPiezaPanel.add(piezaNombreField);
        agregarPiezaPanel.add(new JLabel("Descripción:"));
        agregarPiezaPanel.add(piezaDescField);
        agregarPiezaPanel.add(new JLabel("Cantidad:"));
        agregarPiezaPanel.add(piezaCantidadField);
        agregarPiezaPanel.add(new JLabel("Costo:"));
        agregarPiezaPanel.add(piezaCostoField);
        agregarPiezaPanel.add(btnAgregarPieza);
        panel.add(agregarPiezaPanel);

        btnAgregarPieza.addActionListener(e -> {
            try {
                Pieza pieza = new Pieza(
                        piezaNombreField.getText(),
                        piezaDescField.getText(),
                        Integer.parseInt(piezaCantidadField.getText()),
                        Integer.parseInt(piezaCostoField.getText())
                );
                // Según tu ejemplo, la pieza se inserta a través de su método insertarObjeto()
                pieza.insertarObjeto();
                System.out.println("Pieza insertada: " + pieza.getNombre());
            } catch (NumberFormatException ex) {
                System.err.println("Error en formato numérico de la pieza");
            }
        });

        // Sección: Operaciones de Inventario
        JPanel opsPanel = new JPanel(new FlowLayout());
        opsPanel.setBorder(new TitledBorder("Operaciones Inventario"));
        JTextField piezaOpNombreField = new JTextField(8);
        JTextField nuevaCantidadField = new JTextField(4);
        JTextField disponibilidadField = new JTextField(4);
        JButton btnMostrarInventario = new JButton("Mostrar Inventario");
        JButton btnActualizarCantidad = new JButton("Actualizar Cantidad");
        JButton btnRevisarDisponibilidad = new JButton("Revisar Disponibilidad");
        JButton btnBuscarPieza = new JButton("Buscar Pieza");

        opsPanel.add(new JLabel("Nombre Pieza:"));
        opsPanel.add(piezaOpNombreField);
        opsPanel.add(btnMostrarInventario);
        opsPanel.add(new JLabel("Nueva Cantidad:"));
        opsPanel.add(nuevaCantidadField);
        opsPanel.add(btnActualizarCantidad);
        opsPanel.add(new JLabel("Cantidad Requerida:"));
        opsPanel.add(disponibilidadField);
        opsPanel.add(btnRevisarDisponibilidad);
        opsPanel.add(btnBuscarPieza);
        panel.add(opsPanel);

        btnMostrarInventario.addActionListener(e -> {
            Inventario inv = new Inventario();
            inv.mostrarInventario();
        });
        btnActualizarCantidad.addActionListener(e -> {
            Inventario inv = new Inventario();
            try {
                inv.actualizarCantidad(piezaOpNombreField.getText(), Integer.parseInt(nuevaCantidadField.getText()));
                System.out.println("Cantidad actualizada para: " + piezaOpNombreField.getText());
            } catch (NumberFormatException ex) {
                System.err.println("Error en cantidad");
            }
        });
        btnRevisarDisponibilidad.addActionListener(e -> {
            Inventario inv = new Inventario();
            try {
                inv.revisarDisponibilidad(piezaOpNombreField.getText(), Integer.parseInt(disponibilidadField.getText()));
            } catch (NumberFormatException ex) {
                System.err.println("Error en cantidad requerida");
            }
        });
        btnBuscarPieza.addActionListener(e -> {
            Inventario inv = new Inventario();
            inv.buscarPieza(piezaOpNombreField.getText());
        });

        return panel;
    }

    // ───────────────────────────────────────────────
    // PANEL NOTIFICACIONES: Enviar notificaciones pendientes
    // ───────────────────────────────────────────────
    private JPanel createNotificacionesPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(new TitledBorder("Notificaciones"));
        JButton btnEnviarNotificaciones = new JButton("Enviar Notificaciones");
        panel.add(btnEnviarNotificaciones);
        btnEnviarNotificaciones.addActionListener(e -> {
            Notificacion notificacion = new Notificacion();
            notificacion.enviarNotificacionesOrdenesAbiertas();
            System.out.println("Notificaciones enviadas");
        });
        return panel;
    }

    // ───────────────────────────────────────────────
    // PANEL FACTURAS: Generar factura y registrar pago
    // ───────────────────────────────────────────────
    private JPanel createFacturasPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(new TitledBorder("Facturas"));
        JTextField placaFacturaField = new JTextField(8);
        JButton btnGenerarFactura = new JButton("Generar Factura");
        JButton btnRegistrarPago = new JButton("Registrar Pago");

        panel.add(new JLabel("Placa Vehículo:"));
        panel.add(placaFacturaField);
        panel.add(btnGenerarFactura);
        panel.add(btnRegistrarPago);

        btnGenerarFactura.addActionListener(e -> {
            Factura factura = new Factura();
            factura.generarFactura(placaFacturaField.getText());
            System.out.println("Factura generada para: " + placaFacturaField.getText());
        });
        btnRegistrarPago.addActionListener(e -> {
            Factura factura = new Factura();
            factura.registrarPago(placaFacturaField.getText());
            System.out.println("Pago registrado para: " + placaFacturaField.getText());
        });
        return panel;
    }

    // ───────────────────────────────────────────────
    // Redirige la salida de System.out y System.err a la terminal de la GUI
    // ───────────────────────────────────────────────
    private void redirectSystemOutput() {
        PrintStream printStream = new PrintStream(new CustomOutputStream(terminalArea));
        System.setOut(printStream);
        System.setErr(printStream);
    }

    public static class CustomOutputStream extends java.io.OutputStream {
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

    // ───────────────────────────────────────────────
    // Método main: Inicia la GUI en el Event Dispatch Thread
    // ───────────────────────────────────────────────
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainWindow());
    }
}
