package PC.Apps.users;
import PC.Apps.userManager;

public class Admin implements userManager{
    @Override
    public boolean login(String usuario, String password){
        if ("admin".equals(usuario) && "1234".equals(password)){
            System.out.println("Login exitoso");
            return true;
        }else{
            System.out.println("Login Fallido");
            return false;
        }
    }
}
