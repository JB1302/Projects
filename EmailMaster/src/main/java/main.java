
import Logic.EmailTemplate;
import Server.ServerInteractions;
import java.util.Scanner;
import Logic.EmailHandler;

public class main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID a buscar: ");
        Integer IdToFind = sc.nextInt();

        try {
           EmailTemplate emailTemplate = new EmailTemplate();
           ServerInteractions serverInteractions = new ServerInteractions();
           EmailHandler emailHandler = new EmailHandler();

            String correo = emailHandler.correo(IdToFind);
            String contraseña = emailHandler.generatePassword();

           System.out.println(emailTemplate.EmailTemplate(IdToFind, contraseña));


           serverInteractions.actualizarInformación("correo",correo, IdToFind);
           serverInteractions.actualizarInformación("contraseña",contraseña, IdToFind);



        }catch (Exception e){
            System.out.println(e);
        }
    }
}
