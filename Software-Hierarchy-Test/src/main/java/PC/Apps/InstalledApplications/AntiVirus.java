package PC.Apps.InstalledApplications;

import  PC.Apps.AppManager;

public class AntiVirus  extends AppManager{

    boolean hasVirus;


    public boolean checkVirus(Integer NucleosUsados,Integer RamUsada){
        if (RamUsada <= NucleosUsados){
            hasVirus = true;

            System.out.println("El programa tiene virus");
        }else{
            hasVirus = false;
            System.out.println("El programa no tiene virus");
        }

        return hasVirus;
    }

    @Override
    public boolean checkApp() {
        return hasVirus;
    }
}
