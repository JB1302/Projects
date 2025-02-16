package Logic;

import Server.ServerGateway;

public class EmailTemplate extends EmailHandler{
    ServerGateway serverGateway = new ServerGateway();
    EmailHandler emailHandler = new EmailHandler();


        public String EmailTemplate(Integer IdToFind,String password){
            StringBuilder correo = new StringBuilder();

         try {
             EmailHandler emailHandler = new EmailHandler();
            //Conectarse al servidor
            String nombre = emailHandler.getNombre(IdToFind);
            String apellido = emailHandler.getApellido(IdToFind);
            String departamento = (emailHandler.getDepartamento(IdToFind)).replaceAll("\\s","");

             correo.append("\n'Se ha generado un Usuario Nuevo,\n");
             correo.append(String.format("El empleado %s %s recibira las siguientes credenciales:\n\n", nombre,apellido));
             correo.append("    Correo:\n");
             correo.append(emailHandler.correo(IdToFind));
             correo.append("    Contraseña:\n");
             correo.append("    Password:\n");
             correo.append("    ");
             correo.append(password);
             correo.append("\n\nQuedamos atentos a cualquier consulta\n");
             correo.append("Un saludo'");


        }finally {
            serverGateway.closeConnection();
        }
         return correo.toString();
    }
}
