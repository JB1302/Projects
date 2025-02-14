import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//Utilizar el API para extraer datos del clima
public class WeatherApp {

    //Extraer datos del clima de cierto lugar
    public static JSONObject getDataClima(String nombreLugar) {
        //Usar el API de geolocation para sacar coordenadas
        JSONArray dataLugar = getLocationData(nombreLugar);

        //Exctact latitude and longitude data
        JSONObject location = (JSONObject) dataLugar.get(0);
        double latitude = (double) location.get("latitude");
        double longitude = (double) location.get("longitude");

        //Construir peticion del API para scar la location con las coordenadas
        String urlString = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&hourly=temperature_2m,relative_humidity_2m,weather_code,wind_speed_10m";

        try {
            //Llamar al Api para conseugir una respuesta.
            HttpURLConnection conn = fetchAPIResponse(urlString);

            //Revisar el status. Queremos un return de 200
            if (conn.getResponseCode() != 200) {
                System.out.println("Error: No se pudo conectar al API");
                return null;
            }

            //Store resulting JSON Data
            StringBuilder resultadosJson = new StringBuilder();
            Scanner scanner = new Scanner(conn.getInputStream());
            while (scanner.hasNext()) {
                resultadosJson.append(scanner.nextLine());
            }

            //Cerrar Scanner
            scanner.close();

            //Cerrar URL connection

            //Parse through our data
            JSONParser parser = new JSONParser();
            JSONObject resultadoJsonObject = (JSONObject) parser.parse(String.valueOf(resultadosJson));

            //Traer dato de la hora
            JSONObject hourly = (JSONObject) resultadoJsonObject.get("hourly");

            //Index de la hora actual
            JSONArray time = (JSONArray) hourly.get("time");
            int index = findIndexOfCurrentTime(time);

            //Recuperar temperatura
            JSONArray temperaturaData = (JSONArray) hourly.get("temperature_2m");
            double temperature = (double) temperaturaData.get(index);

            //Conseugir codigo del clima
            JSONArray weathercode = (JSONArray) hourly.get("weather_code");
            String weatherCondition = converWeatherCode((long) weathercode.get(index));

            //Conseguir la Humedad
            JSONArray humedadRelativa = (JSONArray) hourly.get("relative_humidity_2m");
            long humidity = (long) humedadRelativa.get(index);

            //Velocidad del viento
            JSONArray velocidadDelViento = (JSONArray) hourly.get("wind_speed_10m");
            double windspeed = (double) velocidadDelViento.get(index);

            //Constructor para el frontEnd
            JSONObject getDataClima = new JSONObject();
            getDataClima.put("Temperatura", temperature);
            getDataClima.put("Condicion_Clima", weatherCondition);
            getDataClima.put("Humedad", humidity);
            getDataClima.put("Vel_Viento", windspeed);

            return getDataClima;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static JSONArray getLocationData(String locationName) {
        //Hacerle trim a los textos para adecuarse al formato
        locationName = locationName.replaceAll(" ", "+");

        //Construir API url con parametros de la localidad
        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" +
                //Utilizar la variable para la busqueda
                locationName + "&count=10&language=en&format=json";

        try {
            //Llamar a la api y sacar la respuesta
            HttpURLConnection conn = fetchAPIResponse(urlString);

            //revisar la respuesta
            //200 Bien 400 mal 500 Fallo el server
            if (conn.getResponseCode() != 200) {
                System.out.println("Error: No se pudo conectar");
            } else {
                //guardar los resultados de la API
                StringBuilder resultadosJson = new StringBuilder();
                Scanner scanner = new Scanner(conn.getInputStream());
                while (scanner.hasNext()) {
                    resultadosJson.append(scanner.nextLine());
                }

                //Cerrar el Scanner
                scanner.close();

                //Cerrar la connexion.
                conn.disconnect();

                //Prase al Json de String a Objeto
                JSONParser parser = new JSONParser();
                JSONObject resultadosJsonObj = (JSONObject) parser.parse(resultadosJson.toString());

                //Obtener la lista de datos desde el API generadas por el locationName
                JSONArray locationData = (JSONArray) resultadosJsonObj.get("results");
                return locationData;
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }

    private static HttpURLConnection fetchAPIResponse(String urlString) {
        try {
            //Intentar crear la busqueda
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //Definir metodo para sacar info
            conn.setRequestMethod("GET");

            //Conectar a la API
            conn.connect();
            return conn;

        } catch (IOException e) {
            e.printStackTrace();

        }
        //No se pudo hacer la conexion
        return null;
    }

    private static int findIndexOfCurrentTime(JSONArray timeList) {
        String currentTime = getCurrentTime();

        //Iterar sobre la lista de horas en el Api Para ver cual es la correcta
        for (int i = 0; i < timeList.size(); i++) {
            String time = (String) timeList.get(i);
            if (time.equalsIgnoreCase(currentTime)) {
                //Regresar el indice
                return i;
            }
        }

        return 0;
    }

    public static String getCurrentTime() {
        //Sacar fecha y hora actual
        LocalDateTime currentDateTime = LocalDateTime.now();

        //Cambiar formato para que coincida con el API 2024-09-02T00:00
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:00");

        //Darle formato y imprimir el tiempo

        String formattedDateTime = currentDateTime.format(formatter);
        return formattedDateTime;
    }

    private static String converWeatherCode(long weathercode) {
        String weatherCondition = "";
        if (weathercode == 0L) {
            //Soleado
            weatherCondition = "Clear";
        } else if (weathercode > 0L && weathercode <= 3L) {
            //Nublado
            weatherCondition = "Cloudy";
        } else if ((weathercode >= 51L && weathercode <= 67L) || weathercode >= 80L && weathercode <= 99L) {
            //Lluvia
            weatherCondition = "Rain";
        } else if (weathercode >= 71L && weathercode <= 77L) {
            //Nieve
            weatherCondition = "Snow";

        }
        return weatherCondition;
    }
}