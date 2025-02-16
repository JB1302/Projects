import Logic.EmailTemplate;
import Server.ServerInteractions;

import java.util.Scanner;

import Logic.EmailHandler;
import Empleados.MostrarDatos;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID a buscar: ");
        Integer IdToFind = sc.nextInt();

        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            ServerInteractions serverInteractions = new ServerInteractions();
            EmailHandler emailHandler = new EmailHandler();
            MostrarDatos mostrarDatos = new MostrarDatos();

            String correo = emailHandler.correo(IdToFind);
            String contraseña = emailHandler.generatePassword();

            System.out.println("\n-------------------------------------------");
            System.out.println("Generar Template");
            System.out.println("-------------------------------------------");
            System.out.println(emailTemplate.EmailTemplate(IdToFind, contraseña));

            System.out.println("\n-------------------------------------------");
            System.out.println("Actualizar Datos");
            System.out.println("-------------------------------------------");
            serverInteractions.actualizarInformación("correo", correo, IdToFind);
            serverInteractions.actualizarInformación("contraseña", contraseña, IdToFind);

            System.out.println("-------------------------------------------");
            System.out.println("Mostrar Información");
            System.out.println("-------------------------------------------");

            mostrarDatos.mostrarDatos(IdToFind);
            System.out.println("-------------------------------------------");


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
