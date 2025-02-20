package org.example;

import org.example.TransactionManager.ExcepcionTransaccion;
import org.example.TransactionManager.ProcesosTransaccion.Egreso;
import org.example.TransactionManager.ProcesosTransaccion.Ingreso;
import org.example.TransactionManager.Transaccion;
import org.example.UI.LoginUI;
import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static double capital=1500;
    public static HashMap<Integer, Transaccion> baseDeTransaccion = new HashMap<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginUI::new);
    }



    public static void menuPrincipal(){
        int opcion = 0;
        String[] opcionesMenu = new String[]{"Nueva transacción", "Eliminar transacción", "Reporte de transacciones", "Salir"};

        while(true) {
            opcion = JOptionPane.showOptionDialog((Component)null, "Seleccione la opción que desea realizar", "Sistema de Gestión de Transacciones", -1, 3, (Icon)null, opcionesMenu, opcionesMenu[0]);
            if (opcion == 3) {
                JOptionPane.showMessageDialog((Component)null, "Saliendo del sistema...");
                return;
            }

            switch (opcion) {
                case 0:
                    nuevaTransaccion();
                    break;
                case 1:
                    eliminarTransaccion();
                    break;
                case 2:
                    mostrarTransacciones();
                    break;
                default:
                    JOptionPane.showMessageDialog((Component)null, "Opción no valida, seleccione nuevamente");
            }
        }
    }

    public static void nuevaTransaccion() {
        String[] opcionesTransaccion = new String[]{"Ingreso", "Egreso"};
        int tipoTransaccion = JOptionPane.showOptionDialog(null, "Seleccione el tipo de transacción", "Nueva Transacción", -1, JOptionPane.QUESTION_MESSAGE, null, opcionesTransaccion, opcionesTransaccion[0]);

        if (tipoTransaccion == -1) {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún tipo de transacción. Operación cancelada.");
            return;
        }

        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción:");
        double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto:"));

        try {
            Transaccion transaccion;
            if (tipoTransaccion == 0) {
                ExcepcionTransaccion.validarMontoPositivo(monto);
                transaccion = new Ingreso(monto, descripcion);
            } else {
                ExcepcionTransaccion.validarEgresoValido(monto, capital);
                transaccion = new Egreso(monto, descripcion);
            }
            Double nuevoMonto = transaccion.calcularImpuesto(monto);
            transaccion.setMonto(nuevoMonto);
            agregarTransaccion(transaccion);
        } catch (ExcepcionTransaccion e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void agregarTransaccion(Transaccion transaccion) {
        int id = baseDeTransaccion.size() + 1; // Genera ID único a cada transaccion.
        baseDeTransaccion.put(id, transaccion);
        if (transaccion instanceof Ingreso) {
            capital += transaccion.getMonto();
        } else {
            capital -= transaccion.getMonto();
        }
        JOptionPane.showMessageDialog(null, "Transacción agregada exitosamente!");
    }

    public static void eliminarTransaccion() {
        if (!baseDeTransaccion.isEmpty()){
            baseDeTransaccion.clear();
            JOptionPane.showMessageDialog(null, "Todos los registros han sido eliminados");
        } else {
            JOptionPane.showMessageDialog(null, "No existen registros de transacciones para eliminar");
        }

    }

    public static void mostrarTransacciones() {
        StringBuilder textoConcatenado = new StringBuilder();
        if (!baseDeTransaccion.isEmpty()){
            for (Map.Entry<Integer,Transaccion> entry: baseDeTransaccion.entrySet()){
                Transaccion transaccion = entry.getValue();
                textoConcatenado.append( String.format("Transacción código: %s\n %s \n\n", entry.getKey(), entry.getValue().toString()));
            }
            JOptionPane.showMessageDialog(null,textoConcatenado);
            JOptionPane.showMessageDialog(null," capital total " + capital);
        } else {
            JOptionPane.showMessageDialog(null, "No existen registros de transacciones para eliminar");
        }

         }
    }
