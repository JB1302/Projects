import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WeatherAppGui extends JFrame {

    private JSONObject getDataClima;

    public WeatherAppGui() {
        //Definir GUI y añadir titulo
        super("Aplicación del Clima");

        //Configurar GUI para terminar cuando se cierre
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Definir tamaño del GUI en Pixeles
        setSize(450, 650);

        //Cargar la GUI en el centro de la pantalla
        setLocationRelativeTo(null);

        //Hacer el administrador de layour para configurarlo manualmente en el GUI
        setLayout(null);

        //Evitar que se cambie el tamaño de la GUI
        setResizable(false);

        addGuicomponents();

    }

    private void addGuicomponents() {
        //Campo de Busqueda
        JTextField textSearchField = new JTextField();

        //Definir el tamaño y el lugar de los componentes
        textSearchField.setBounds(15, 15, 351, 45);

        //Definir la fuente y el tamaño
        textSearchField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(textSearchField);


        //Imagen del weather
        JLabel weatherConditionImage = new JLabel(loadImage("src/assets/cloudy.png"));
        weatherConditionImage.setBounds(0, 125, 450, 217);
        add(weatherConditionImage);

        //Imagen de la temperatura
        JLabel textoDeTemperatura = new JLabel("10 C");
        textoDeTemperatura.setBounds(0, 350, 450, 54);
        textoDeTemperatura.setFont(new Font("Dialog", Font.BOLD, 48));

        //Centrar el texto
        textoDeTemperatura.setHorizontalAlignment(SwingConstants.CENTER);
        add(textoDeTemperatura);

        //Description Del Clima
        JLabel weatherCondicionDesc = new JLabel("Nublado");
        weatherCondicionDesc.setBounds(0, 405, 450, 36);
        weatherCondicionDesc.setFont(new Font("Dialog", Font.PLAIN, 32));
        weatherCondicionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherCondicionDesc);

        //Imagen de Humedad
        JLabel humedadImagen = new JLabel(loadImage("src/assets/humidity.png"));
        humedadImagen.setBounds(15, 500, 74, 66);
        add(humedadImagen);

        //Humedad Texto
        JLabel humedadTexto = new JLabel("<html><b>Humedad</b> 100%</html>");
        humedadTexto.setBounds(90, 500, 85, 55);
        humedadTexto.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humedadTexto);

        //Velocidad del Viento Imagen
        JLabel velocidadVientoImagen = new JLabel(loadImage("src/assets/windspeed.png"));
        velocidadVientoImagen.setBounds(220, 500, 74, 66);
        add(velocidadVientoImagen);

        //Velocidad del viento Texto
        JLabel velocidadVientoTexto = new JLabel("<html><b>Velocidad del Viento </b><15 Km/h</html>");
        velocidadVientoTexto.setBounds(310, 500, 85, 55);
        add(velocidadVientoTexto);

        //Definir boton de Busqueda
        JButton searchButton = new JButton(loadImage("src/assets/search.png"));

        //Hacer el Hover del raton sobre el boton
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //Definir tamaño
        searchButton.setBounds(375, 13, 47, 45);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Sacar lugar del usuario
                String userInput = textSearchField.getText();

                //Validar el input
                if (userInput.replaceAll("\\s", "").length() <= 0) {
                    return;
                }
                //Devoler el constructor
                getDataClima = WeatherApp.getDataClima(userInput);

                //Actualizar la imagen
                String condicionClima = (String) getDataClima.get("Condicion_Clima");

                //Iterar sobre las imagenes para elegir la correcta
                switch (condicionClima){
                    case "Clear":
                        weatherConditionImage.setIcon(loadImage("src/assets/clear.png"));
                        break;
                    case "Cloudy":
                        weatherConditionImage.setIcon(loadImage("src/assets/cloudy.png"));
                        break;
                    case "Rain":
                        weatherConditionImage.setIcon(loadImage("src/assets/rain.png"));
                        break;
                    case "Snow":
                        weatherConditionImage.setIcon(loadImage("src/assets/snow.png"));
                        break;
                }

                //Actualizar temperatura
                double temperatura = (double) getDataClima.get("Temperatura");
                textoDeTemperatura.setText(temperatura + "C");

                //Actualizar condición text
                weatherCondicionDesc.setText(condicionClima);

                //Actualizar humedad
                long humedad = (long) getDataClima.get("Humedad");
                humedadTexto.setText("<html><b>Humedad</b> " + humedad + "%</html>");

                //Actualizar velocidad del Viento
                double vel_Viento = (double) getDataClima.get("Vel_Viento");
                velocidadVientoTexto.setText("<html><b>Velocidad del Viento </b> " + vel_Viento + "Km/h</html>");

            }
        });
        add(searchButton);

    }

    //Usado para cargar imagenes en el GUI

    private ImageIcon loadImage(String resourcePath) {
        try {
            //Leer la imagen en el lugar asignado
            BufferedImage image = ImageIO.read(new File(resourcePath));
            return new ImageIcon(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("No se encontro el recurso");
        return null;
    }
}
