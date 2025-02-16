package Logic;

import Server.ServerGateway;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.time.LocalDate;

public class EmailHandler extends ServerGateway {



    public String getNombre(Integer IDnumber ){
    String query = "Select nombre FROM empleados WHERE id = ?";
    String nombre = "";

        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, IDnumber); //Reemplazar el ID a Buscar
            try { ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()){
                   nombre = resultSet.getString("nombre");
                }else{
                    nombre = resultSet.getString("N/a");
                }
            }catch (SQLException e){
                throw new RuntimeException("Error al cargar ID", e);
            }
        }catch(SQLException e){
            throw new RuntimeException("No se pudo obtener el nombre", e);
      }
        return nombre;
    }

    public String getApellido(Integer IDnumber) {
        String query = "Select apellido FROM empleados WHERE id = ?";
        String apellido = "";

        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, IDnumber); //Reemplazar el ID a Buscar
            try { ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()){
                    apellido = resultSet.getString("apellido");
                }else{
                    apellido = resultSet.getString("N/a");
                }
            }catch (SQLException e){
                throw new RuntimeException("Error al cargar el ID", e);
            }
        }catch(SQLException e){
            throw new RuntimeException("No se pudo obtener el nombre", e);
        }
        return apellido;
    }

    public String getDepartamento(Integer IDnumber) {
        String query = "Select departamento FROM empleados WHERE id = ?";
        String posición = "";

        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, IDnumber); //Reemplazar el ID a Buscar
            try { ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()){
                    if(resultSet.getString("departamento") == null){
                        posición = "general";
                    }else{
                        posición = resultSet.getString("departamento");
                    }
                }else{
                    posición = resultSet.getString("N/a");
                }
            }catch (SQLException e){
                throw new RuntimeException("Error al cargar el ID", e);
            }
        }catch(SQLException e){
            throw new RuntimeException("No se pudo obtener el nombre", e);
        }
        return posición;
    }

    public String generatePassword(){
        Random random = new Random();
        StringBuilder passwordGenerated = new StringBuilder();

        LocalDate fechaActual = LocalDate.now();
        String fecha = fechaActual.toString();

        int randomInteger1 = random.nextInt(9000);

        //Generar caracteres Especiales
        String caracteresEspeciales = "!#$%&?@";
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%&?@";
        char randomChar1 = caracteres.charAt(random.nextInt(caracteresEspeciales.length()));
        char randomChar2 = caracteresEspeciales.charAt(random.nextInt(caracteresEspeciales.length()));
        char randomChar3 = caracteres.charAt(random.nextInt(caracteresEspeciales.length()));
        char randomChar4 = caracteresEspeciales.charAt(random.nextInt(caracteresEspeciales.length()));

        passwordGenerated.append(randomInteger1)
                .append(randomChar1)
                .append(randomChar4)
                .append(fecha)
                .append(randomChar2)
                .append(randomChar3);



        return  passwordGenerated.toString();
    }
}
