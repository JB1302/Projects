package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSocket {

    private static final String HOST = "localhost";
    private static final int PUERTO = 5700;

    public static String obtenerDestacada(int idArtista) {
        String obraDestacada = "No disponible";

        try (Socket socket = new Socket(HOST, PUERTO);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {


            out.println(String.valueOf(idArtista));


            String respuesta = in.readLine();


            if (respuesta != null) {
                if (respuesta.startsWith("[") && respuesta.endsWith("]")) {
                    obraDestacada = respuesta.substring(1, respuesta.length() - 1);
                } else if (respuesta.startsWith("(") && respuesta.endsWith(")")) {
                    obraDestacada = respuesta.substring(1, respuesta.length() - 1);
                } else {
                    obraDestacada = respuesta;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al conectar con el servidor.");
        }

        return obraDestacada;
    }
}
