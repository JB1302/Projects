/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package employeemanager;
import javax.swing.JOptionPane;

/**
 *
 * @author jstev
 */
public class EmployeeManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestionUsuario miGestion = new GestionUsuario();

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menú de Gestión de Empleados\n" +
                            "1) Agregar Empleado\n" +
                            "2) Mostrar Salario Promedio\n" +
                            "3) Mostrar Empleado con el Salario Más Bajo\n" +
                            "4) Mostrar Empleado con el Salario Más Alto\n" +
                            "5) Buscar Empleado por Nombre\n" +
                            "6) Mostrar Todos los Empleados\n" +
                            "0) SALIR\n" +
                            "Ingrese una opción"));

            switch (opcion) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Fin del programa");
                    break;
                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingrese el Nombre del Empleado");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Edad del Empleado"));
                    String departamento = JOptionPane.showInputDialog("Ingrese el Departamento del Empleado");
                    double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Salario del Empleado"));
                    Empleado empleado = new Empleado(nombre, edad, departamento, salario);
                    miGestion.agregarEmpleado(empleado);
                    break;
                case 2:
                    double salarioPromedio = miGestion.salarioPromedio();
                    JOptionPane.showMessageDialog(null, "El salario promedio es: " + salarioPromedio);
                    break;
                case 3:
                    Empleado empleadoMenorSalario = miGestion.menorSalario();
                    JOptionPane.showMessageDialog(null, "El empleado con el salario más bajo es: " + empleadoMenorSalario);
                    break;
                case 4:
                    Empleado empleadoMayorSalario = miGestion.mayorSalario();
                    JOptionPane.showMessageDialog(null, "El empleado con el salario más alto es: " + empleadoMayorSalario);
                    break;
                case 5:
                    String nombreBuscar = JOptionPane.showInputDialog("Ingrese el Nombre del Empleado a buscar");
                    Empleado empleadoEncontrado = miGestion.nameSearch(nombreBuscar);
                    if (empleadoEncontrado != null) {
                        JOptionPane.showMessageDialog(null, "Empleado encontrado:\n" + empleadoEncontrado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
                    }
                    break;
                case 6:
                    miGestion.showAll();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 0);
    }
}