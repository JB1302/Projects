package Frontend.Cor 
import Frontend.CoreApp.Funciones.*;
import Frontend.login.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    private JLabel tituloPagina;
    private JPanel vistaPanel; //Contenedor Dinamico
    private JButton[] menuButtons;

    public VentanaPrincipal(){
        setTitle("FullStack Gestor de Tareas");
        setSize(905,485);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        //Panel Izquierdo de navegación
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BorderLayout());
        panelIzquierdo.setPreferredSize(new Dimension(153,294));

        //Header
        JPanel headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(153,50));
        headerPanel.setBackground(Color.decode("#0C6170"));
        headerPanel.setLayout(new BorderLayout());

        JLabel headerLabel = new JLabel("Gestor de Taller", SwingConstants.CENTER);
        headerLabel.setForeground(Color.decode("#FFFFFF"));

        headerPanel.add(headerLabel, BorderLayout.CENTER);

        //Menu Vertical
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.decode("#0C6170"));

        menuPanel.setLayout(new BoxLayout(menuPanel,BoxLayout.Y_AXIS));


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.decode("#0C6170"));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        menuButtons = new JButton[7];
        String[] buttonLabels = {
                "Usuarios",
                "Vehículos",
                "Reparaciones",
                "Citas",
                "Inventario",
                "Notificaciones",
                "Facturas"
        };

        for (int i = 0; i < menuButtons.length; i++) {
            menuButtons[i] = new JButton(buttonLabels[i]);
            int FinalI = i;

            //Estilos
            menuButtons[i].setBackground(Color.decode("#DBF5F0"));
            menuButtons[i].setForeground(Color.decode("#1E1E1E"));
            menuButtons[i].setPreferredSize(new Dimension(123,25));
            menuButtons[i].setMaximumSize(new Dimension(123,25));

            menuButtons[i].setAlignmentX(Component.CENTER_ALIGNMENT);


            menuButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cambiarVista(FinalI);
                }
            });
            buttonPanel.add(menuButtons[i]);
            if (i < menuButtons.length - 1) {
                buttonPanel.add(Box.createVerticalStrut(10)); // Espacio de 5 píxeles entre botones
            }

        }

        menuPanel.add(Box.createVerticalGlue());
        menuPanel.add(buttonPanel);
        menuPanel.add(Box.createVerticalGlue());

        //Boton Cerrar Sesión
        JButton cerrarSessionBtn = new JButton("Cerrar Sesión");

        cerrarSessionBtn.setBackground(Color.decode("#0C6170"));
        cerrarSessionBtn.setForeground(Color.decode("#FFFFFF"));
        cerrarSessionBtn.setPreferredSize(new Dimension(123,23));

        cerrarSessionBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        cerrarSessionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login loginVista = new Login();
                loginVista.setVisible(true);
                dispose();
            }
        });

        panelIzquierdo.add(headerPanel, BorderLayout.NORTH);
        panelIzquierdo.add(menuPanel, BorderLayout.CENTER);
        panelIzquierdo.add(cerrarSessionBtn, BorderLayout.SOUTH);

        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BorderLayout());

        //Header de la vista
        JPanel headerDerecho = new JPanel();
        headerDerecho.add(Box.createRigidArea(new Dimension(0,50)));
        tituloPagina = new JLabel("Titulo de la pagina",SwingConstants.CENTER);
        tituloPagina.setFont(new Font("Arial", Font.BOLD,38));
        tituloPagina.setForeground(Color.decode("#37BEB0"));

        headerDerecho.add(tituloPagina);

        vistaPanel = new JPanel(new BorderLayout());
        vistaPanel.setPreferredSize(new Dimension(445,350));
        vistaPanel.setBackground(Color.WHITE);

        panelDerecho.setBackground(Color.white);
        headerDerecho.setBackground(Color.white);
        vistaPanel.setBackground(Color.white);

        panelDerecho.setLayout(new BorderLayout());
        panelDerecho.add(headerDerecho, BorderLayout.NORTH);
        panelDerecho.add(vistaPanel, BorderLayout.CENTER);

        add(panelIzquierdo, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.CENTER);

        //Ajustar Ventana de Inicio
        cambiarVista(0);

    }

    private void cambiarVista(int vistaIndex){
        vistaPanel.removeAll();
        JPanel nuevaViSTA = null;
        String titulo = "Titulo de la pagina";

        //Crear panel nuevo dependiendo de la vista
        JPanel nuevaVista = null;
        switch (vistaIndex) {
            case 0:
                nuevaVista = new vista0();
                titulo = "Gestión de Usuarios";
                break;
            case 1:
                nuevaVista = new vista1();
                titulo = "Gestión de Vehículos"; // Añade esto
                break;
            case 2:
                nuevaVista = new vista2();
                titulo = "Gestión de Reparaciones"; // Añade esto
                break;
            case 3:
                nuevaVista = new vista3();
                titulo = "Gestión de Citas"; // Añade esto
                break;
            case 4:
                nuevaVista = new vista4();
                titulo = "Gestión de Inventario"; // Añade esto
                break;
            case 5:
                nuevaVista = new vista5();
                titulo = "Notificaciones"; // Añade esto

                break;
            case 6:
                nuevaVista = new vista6();
                titulo = "Gestión de Facturas"; // Añade esto
                break;
        }
        if (nuevaVista != null) {
            // Actualizar título y vista
            tituloPagina.setText(titulo);
            vistaPanel.add(nuevaVista, BorderLayout.CENTER);
            vistaPanel.revalidate(); // Refrescar el layout
            vistaPanel.repaint(); // Redibujar componentes

        }
        for (int i = 0; i < menuButtons.length; i++) {
            if (i== vistaIndex){
                //Cambiar el color del boton seleccionado
                menuButtons[i].setBackground(Color.decode("#a4e5e0"));
            }else {
                menuButtons[i].setBackground(Color.decode("#DBF5F0"));
            }

        }
    }



    public class vista0 extends JPanel{
        public vista0(){
            setLayout(new BorderLayout());
            RegistrarUsuario registrarUsuario = new RegistrarUsuario();
            add(registrarUsuario);
        }
    }

    public class vista1 extends JPanel{
        public vista1(){
            setLayout(new BorderLayout());
            GestionVehicular gestionVehicular = new GestionVehicular();
            add(gestionVehicular);
        }
    }


    public class vista2 extends JPanel{
        public vista2(){
            setLayout(new BorderLayout());
            GestionReparaciones gestionReparaciones = new GestionReparaciones();
            add(gestionReparaciones);
        }
    }


    public class vista3 extends JPanel{
        public vista3(){
            setLayout( new BorderLayout());
            GestionCitas gestionCitas = new GestionCitas();
            add(gestionCitas);
        }
    }

    public class vista4 extends JPanel{
        public vista4(){
            setLayout( new BorderLayout());
            Inventario inventario = new Inventario();
            add(inventario);
        }
    }

    public class vista5 extends JPanel{
        public vista5(){
            setLayout(new BorderLayout());
            Notificaciones notificaciones = new Notificaciones();
            add(notificaciones);
        }
    }

    public class vista6 extends JPanel{
        public vista6(){
            setLayout(new BorderLayout());
            Facturas facturas = new Facturas();
            add(facturas);
        }
    }



    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

}
