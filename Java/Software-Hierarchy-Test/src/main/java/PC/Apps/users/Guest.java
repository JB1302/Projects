package PC.Apps.users;
import PC.Apps.userManager;

public class Guest implements userManager{

        @Override
        public boolean login(String usuario, String password){
            if ("Guest".equals(usuario) && "tomate".equals(password)){
                System.out.println("Login exitoso");
                return true;
            }else{
                System.out.println("Login Fallido");
                return false;
            }
        }
    }
