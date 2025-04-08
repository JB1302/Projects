import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class servidorGaleria {
    public static void main(String[] args) {
        int puerto = 5700;
        String[] obras = {
                "Pintura Fruta Naranja",
                "Paisaje Urbano Gris",
                "Retrato Luz de Luna",
                "Naturaleza Viva Esmeralda",
                "Abstracción del Mar Profundo"
        };

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor de galeria escuchando en el puerto " + puerto);

            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                    String idStr = in.readLine();
                    int id = Integer.parseInt(idStr);

                    String obra = obras[new Random().nextInt(obras.length)];


                    if (id % 2 == 0) {
                        out.println("[" + obra + "]");
                    } else {
                        out.println("(" + obra + ")");
                    }
                } catch (IOException | NumberFormatException e) {
                    e.printStackTrace();
                    System.out.println("Error al procesar la solicitud.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al crear el servidor.");
        }
    }
}
