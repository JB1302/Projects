
import Logic.EmailTemplate;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID a buscar: ");

        Integer IdToFind = sc.nextInt();

        try {
           EmailTemplate emailTemplate = new EmailTemplate();
           System.out.println(emailTemplate.EmailTemplate(IdToFind));

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
