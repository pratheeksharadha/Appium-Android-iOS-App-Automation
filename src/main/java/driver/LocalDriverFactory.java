package driver;

import config.ConfigManager;
import io.appium.java_client.AppiumDriver;

public class LocalDriverFactory {

    public AppiumDriver createDriver(){
        String platform = ConfigManager.getPlatform();
        if("Android".equalsIgnoreCase(platform)){
            return AndroidDriverFactory.createAndroidDriver();
        } else if ("iOS".equalsIgnoreCase(platform)) {
            return IOSDriverFactory.createIOSDriver();
        }
        throw new RuntimeException("Unsupported Platform " +platform);
    }
}
