package Logica;

import POJO.Escritorio;
import POJO.Reserva;
import POJO.SalaReunion;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Interacciones {

    //Definir Arreglo de guardado
    static List<Reserva> reservaciones = new ArrayList<>();

    public static void Menu() {

        String mensajeErrorMenu = "La opcion NO esta en la lista";

        JOptionPane.showMessageDialog(null, "Bienvenido al Sistema");

        String Menu = "Menu De reservas" + "\n\n" +
                "1. [Crear Escritorio / Sala]" + "\n" +
                "2. [Asignar Reserva]" + "\n" +
                "3. [Calcular Costos]" + "\n" +
                "4. [Listas Reservas]" + "\n" +
                "5. [Mostrar Revenue]" + "\n" +
                "6. [Salir]\n ";

        String interaccion;

        do {
            interaccion = JOptionPane.showInputDialog(Menu);
            if (interaccion == null) return;

            switch (interaccion) {
                case "1": {
                    //Crear Escritorio o Sala
                    String SubMenu1 = "Menu De reservas" + "\n\n" +
                            "1. [Crear Escritorio]" + "\n" +
                            "2. [Crear Sala]" + "\n" +
                            "3. [Regresar]\n ";

                    String subInteraccion;

                    do {
                        subInteraccion = JOptionPane.showInputDialog(SubMenu1);
                        if (subInteraccion == null) break;

                        switch (subInteraccion) {
                            case "1": {
                                //Crear Escritorio
                                String nombre = JOptionPane.showInputDialog("Ingrese el Nombre del Escritorio");
                                String costo = JOptionPane.showInputDialog("Ingrese el Costo del Escritorio");
                                String Horas = JOptionPane.showInputDialog("Ingrese las Horas a utilizar");

                                Double costoConvertido = Double.parseDouble(costo);

                                Double horasDouble = Double.parseDouble(Horas);

                                if (horasDouble > 5) {
                                    costoConvertido -= (costoConvertido * 0.10);
                                }

                                Reserva escritorio = new Escritorio(
                                        reservaciones.size(),
                                        nombre,
                                        costoConvertido,
                                        horasDouble,
                                        Reserva.EstadoEspacio.Disponible
                                );

                                JOptionPane.showMessageDialog(null, escritorio);
                                reservaciones.add(escritorio);
                                break;
                            }

                            case "2": {
                                //Crear Sala
                                String nombre = JOptionPane.showInputDialog("Ingrese el Nombre de la Sala");
                                String costo = JOptionPane.showInputDialog("Ingrese el Costo de la Sala");
                                String Horas = JOptionPane.showInputDialog("Ingrese las Horas a utilizar");

                                Double costoConvertido = Double.parseDouble(costo);

                                Double horasDouble = Double.parseDouble(Horas);

                                if (horasDouble > 5) {
                                    costoConvertido -= (costoConvertido * 0.10);
                                }

                                Double costoConTax = costoConvertido + (costoConvertido * 0.15);

                                Reserva salaReunion = new SalaReunion(
                                        reservaciones.size(),
                                        nombre,
                                        costoConTax,
                                        Double.parseDouble(Horas),
                                        Reserva.EstadoEspacio.Disponible
                                );

                                JOptionPane.showMessageDialog(null, salaReunion);
                                reservaciones.add(salaReunion);
                                break;
                            }


                            case "3":
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, mensajeErrorMenu);
                                JOptionPane.showInputDialog(SubMenu1);
                        }

                    } while (!subInteraccion.equals("3"));

                    break;
                }

                case "2":
                    //Asignar Reserva
                    break;

                case "3":
                    //Calcular Costos
                    String tipo = JOptionPane.showInputDialog("Ingrese el tipo de Reserva: \n" +
                            "\n" +
                            "1. [Sala de Reuniones]\n" +
                            "2. [Escritorios]\n" +
                            "3. [Regresar al Menu]\n ");

                    if (tipo.equals("3")) {
                        break;
                    }

                    String costo = JOptionPane.showInputDialog("Ingrese el Costo de la Sala");
                    String Horas = JOptionPane.showInputDialog("Ingrese las Horas a utilizar");

                    Double costoCurado = Double.parseDouble(costo);
                    Double horasCurado = Double.parseDouble(Horas);

                    if (horasCurado > 5) {
                        costoCurado -= (costoCurado * 0.10);
                    }

                    switch (tipo) {
                        case "1": {
                            costoCurado += (costoCurado * 0.15);
                            JOptionPane.showMessageDialog(null, "El costo es de ₡ " + costoCurado);
                            break;
                        }

                        case "2": {
                            JOptionPane.showMessageDialog(null, "El costo es de ₡ " + costoCurado);
                            break;
                        }
                        case "3":
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, mensajeErrorMenu);
                            break;
                    }

                    break;

                case "4":
                    //Listar Reservas
                    JOptionPane.showMessageDialog(null, reservaciones);
                    break;

                case "5": {
                    //Mostrar Revenue

                    double beneficioTotal = 0;

                    for (int i = 0; i < reservaciones.size(); i++) {
                        double costoPerHora = reservaciones.get(i).getCostPerHour();
                        double horas = reservaciones.get(i).getHoras();

                        beneficioTotal += (costoPerHora * horas);
                    }

                    JOptionPane.showMessageDialog(null, "Beneficios Totales: ₡" + beneficioTotal);
                }
                break;

                case "6":
                    //Salir del Sistema
                    break;

                default:
                    JOptionPane.showMessageDialog(null, mensajeErrorMenu);
                    JOptionPane.showInputDialog(Menu);
            }

            //Cerrar el Menu
        } while (!interaccion.equals("6"));
    }
}
