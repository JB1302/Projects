package PC.Apps;

import PC.componentesPrincipales;

public abstract class AppManager extends componentesPrincipales {

    protected boolean hasValidCredentials;
    protected boolean isAppSafeToRun;

    protected  AppManager(){
    }

    protected AppManager(boolean hasValidCredentials, boolean isAppSafeToRun) {
        this.hasValidCredentials = hasValidCredentials;
        this.isAppSafeToRun = isAppSafeToRun;
    }

    protected AppManager(String hostName, String CPU, int RAM, boolean hasValidCredentials, boolean isAppSafeToRun) {
        super(hostName, CPU, RAM);
        this.hasValidCredentials = hasValidCredentials;
        this.isAppSafeToRun = isAppSafeToRun;
    }

    public abstract boolean checkApp();
}
