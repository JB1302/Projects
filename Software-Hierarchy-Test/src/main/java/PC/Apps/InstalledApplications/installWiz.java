package PC.Apps.InstalledApplications;

import PC.Apps.AppManager;

import java.io.File;

public class installWiz extends AppManager {

    private String folderPath;
    private String appName;
    private File appFile;

    public installWiz(String appName) {
        this.appName = appName;
        this.folderPath = "C:/Users/jstev/OneDrive/Documents/GitHub/Projects/Software-Hierarchy-Test/src/main/java/PC/Apps/InstalledApplications";
        this.appFile = new File(folderPath, appName + ".java");
    }


    @Override
    public boolean checkApp() {
        return appFile.exists();
    }
}
